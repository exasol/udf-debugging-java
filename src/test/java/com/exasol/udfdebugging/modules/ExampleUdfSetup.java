package com.exasol.udfdebugging.modules;

import java.io.Closeable;
import java.sql.*;
import java.util.stream.Stream;

import com.exasol.bucketfs.Bucket;
import com.exasol.containers.ExasolContainer;
import com.exasol.dbbuilder.dialects.exasol.*;
import com.exasol.dbbuilder.dialects.exasol.udf.UdfScript;
import com.exasol.udfdebugging.ExposedServiceAddress;
import com.exasol.udfdebugging.LocalServiceExposer;

public class ExampleUdfSetup implements Closeable, AutoCloseable {
    private static final String SCHEMA_NAME = "TEST";
    private static final String UDF_NAME = "HELLO_WORLD";

    private final ExasolContainer<? extends ExasolContainer<?>> exasol = new ExasolContainer<>().withReuse(true);

    public ExampleUdfSetup() {
        this.exasol.start();
    }

    public LocalServiceExposer getHostPortProxy() {
        return port -> new ExposedServiceAddress(this.exasol.getHostIp(), port);
    }

    public Bucket getDefaultBucket() {
        return this.exasol.getDefaultBucket();
    }

    public ExasolContainer<? extends ExasolContainer<?>> getExasolContainer() {
        return this.exasol;
    }

    public void runJavaUdf(final Stream<String> jvmOptions) throws SQLException {
        try (final Connection connection = this.exasol.createConnection();
                final Statement statement = connection.createStatement()) {
            final ExasolObjectFactory exasolObjectFactory = new ExasolObjectFactory(connection,
                    ExasolObjectConfiguration.builder().withJvmOptions(jvmOptions.toArray(String[]::new)).build());
            final ExasolSchema schema = exasolObjectFactory.createSchema(SCHEMA_NAME);
            schema.createUdfBuilder(UDF_NAME).inputType(UdfScript.InputType.SCALAR).language(UdfScript.Language.JAVA)
                    .content("class HELLO_WORLD {\n"
                            + " static String run(ExaMetadata exa, ExaIterator ctx) throws Exception {\n"
                            + " \treturn exa.getScriptLanguage();\n" + " }\n" + "}")
                    .returns("VARCHAR(2000)").build();
            final ResultSet resultSet = statement.executeQuery("SELECT " + SCHEMA_NAME + "." + UDF_NAME + "()");
            resultSet.next();
            System.out.println(resultSet.getString(1));
        }
    }

    @Override
    public void close() {
        this.exasol.stop();
    }
}
