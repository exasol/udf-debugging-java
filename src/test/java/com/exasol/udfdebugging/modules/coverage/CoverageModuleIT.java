package com.exasol.udfdebugging.modules.coverage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.jacoco.core.data.ExecutionDataReader;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.exasol.containers.ExasolContainer;
import com.exasol.dbbuilder.dialects.exasol.ExasolObjectConfiguration;
import com.exasol.dbbuilder.dialects.exasol.ExasolObjectFactory;
import com.exasol.dbbuilder.dialects.exasol.ExasolSchema;
import com.exasol.dbbuilder.dialects.exasol.udf.UdfScript;
import com.exasol.errorreporting.ExaError;
import com.github.dockerjava.api.model.ContainerNetwork;

@Testcontainers
class CoverageModuleIT {
    @Container
    private static final ExasolContainer<? extends ExasolContainer<?>> EXASOL = new ExasolContainer<>().withReuse(true);
    private static final String SCHEMA_NAME = "TEST";
    private static final String UDF_NAME = "HELLO_WORLD";

    private static String getTestHostIpFromInsideExasol() {
        final Map<String, ContainerNetwork> networks = EXASOL.getContainerInfo().getNetworkSettings().getNetworks();
        if (networks.size() == 0) {
            return null;
        }
        return networks.values().iterator().next().getGateway();
    }

    @Test
    void testCoverageReportIsWritten() throws SQLException, IOException, InterruptedException {
        deleteExecutionFile();
        final Connection connection = EXASOL.createConnection();
        final CoverageModule coverageModule = new CoverageModule(getTestHostIpFromInsideExasol(),
                EXASOL.getDefaultBucket());
        final ExasolObjectFactory exasolObjectFactory = new ExasolObjectFactory(connection, ExasolObjectConfiguration
                .builder().withJvmOptions(coverageModule.getJvmOptions().toArray(String[]::new)).build());
        final ExasolSchema schema = exasolObjectFactory.createSchema(SCHEMA_NAME);
        schema.createUdfBuilder(UDF_NAME).inputType(UdfScript.InputType.SCALAR).language(UdfScript.Language.JAVA)
                .content("class HELLO_WORLD {\n"
                        + " static String run(ExaMetadata exa, ExaIterator ctx) throws Exception {\n"
                        + " \treturn \"hello world\";\n" + " }\n" + "}")
                .returns("VARCHAR(2000)").build();
        connection.createStatement().executeQuery("SELECT " + SCHEMA_NAME + "." + UDF_NAME + "()");
        assertThat(countReportedJacocoSessions(), equalTo(1));
    }

    private int countReportedJacocoSessions() throws IOException {
        final AtomicInteger sessionCounter = new AtomicInteger(0);
        try (final InputStream inputStream = new FileInputStream(JacocoServer.COVERAGE_REPORT_PATH.toFile())) {
            final ExecutionDataReader reader = new ExecutionDataReader(inputStream);
            reader.setSessionInfoVisitor(sessionInfo -> sessionCounter.addAndGet(1));
            reader.setExecutionDataVisitor(executionData -> {
            });
            while (reader.read()) {
                // just read everything to invoke the callbacks
            }
        }
        return sessionCounter.get();
    }

    private void deleteExecutionFile() {
        if (JacocoServer.COVERAGE_REPORT_PATH.toFile().exists()) {
            JacocoServer.COVERAGE_REPORT_PATH.toFile().delete();
        }
        if (JacocoServer.COVERAGE_REPORT_PATH.toFile().exists()) {
            throw new IllegalStateException(ExaError.messageBuilder("E-UDJ-4")
                    .message("Failed to delete coverage file before test execution.").toString());
        }
    }
}
