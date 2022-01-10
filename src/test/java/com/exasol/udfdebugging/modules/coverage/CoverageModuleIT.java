package com.exasol.udfdebugging.modules.coverage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import org.jacoco.core.data.ExecutionDataReader;
import org.junit.jupiter.api.Test;

import com.exasol.errorreporting.ExaError;
import com.exasol.udfdebugging.modules.TestSetup;

class CoverageModuleIT {

    @Test
    void testCoverageReportIsWritten() throws SQLException, IOException {
        deleteExecutionFile();
        final TestSetup udfSetup = new TestSetup();
        final CoverageModule coverageModule = new CoverageModule(udfSetup.getHostPortProxy(),
                udfSetup.getDefaultBucket());
        udfSetup.runJavaUdf(coverageModule.getJvmOptions(), "");
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
