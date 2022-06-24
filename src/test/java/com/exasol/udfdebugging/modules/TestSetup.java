package com.exasol.udfdebugging.modules;

import java.io.Closeable;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.stream.Stream;

import com.exasol.bucketfs.Bucket;
import com.exasol.containers.ExasolContainer;
import com.exasol.dbbuilder.dialects.exasol.*;
import com.exasol.dbbuilder.dialects.exasol.udf.UdfScript;
import com.exasol.udfdebugging.LocalServiceExposer;

/**
 * This class contains common integration test setup.
 */
public class TestSetup implements Closeable, AutoCloseable {
    private static final String SCHEMA_NAME = "TEST";
    private static final String UDF_NAME = "HELLO_WORLD";

    private final ExasolContainer<? extends ExasolContainer<?>> exasol = new ExasolContainer<>().withReuse(true);
    private final Connection connection;

    public TestSetup() throws SQLException {
        this.exasol.start();
        this.connection = this.exasol.createConnection();
    }

    public LocalServiceExposer getHostPortProxy() {
        return port -> new InetSocketAddress(this.exasol.getHostIp(), port);
    }

    public Bucket getDefaultBucket() {
        return this.exasol.getDefaultBucket();
    }

    public ExasolContainer<? extends ExasolContainer<?>> getExasolContainer() {
        return this.exasol;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void runJavaUdf(final Stream<String> jvmOptions, final String lineToRun) throws SQLException {
        try (final Statement statement = this.connection.createStatement()) {
            final ExasolObjectFactory exasolObjectFactory = new ExasolObjectFactory(this.connection,
                    ExasolObjectConfiguration.builder().withJvmOptions(jvmOptions.toArray(String[]::new)).build());
            final ExasolSchema schema = exasolObjectFactory.createSchema(SCHEMA_NAME);
            schema.createUdfBuilder(UDF_NAME).inputType(UdfScript.InputType.SCALAR).language(UdfScript.Language.JAVA)
                    .content("class HELLO_WORLD {\n"
                            + " static String run(ExaMetadata exa, ExaIterator ctx) throws Exception {\n" + //
                            lineToRun + "\n" + //
                            " \treturn \"\";\n" + " }\n" + "}")
                    .returns("VARCHAR(2000)").build();
            statement.executeQuery("SELECT " + SCHEMA_NAME + "." + UDF_NAME + "()").close();
        }
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (final SQLException exception) {
            // at least we tried
        }
        this.exasol.stop();
    }
}
