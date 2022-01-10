package com.exasol.udfdebugging.modules.udflogs;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.exasol.udfdebugging.modules.TestSetup;

class UdfLogsModuleIT {

    @Test
    void testGetLog() throws SQLException, IOException {
        try (final TestSetup testSetup = new TestSetup();
                final UdfLogsModule logsModule = new UdfLogsModule(testSetup.getHostPortProxy(),
                        testSetup.getConnection());) {
            testSetup.runJavaUdf(logsModule.getJvmOptions(), "System.out.println(\"hello from udf\");");
            final String log = Files.readString(logsModule.getCapturedLogFiles().get(0));
            assertThat(log, containsString("hello from udf"));
        }
    }
}