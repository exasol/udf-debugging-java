package com.exasol.udfdebugging.modules.profiling;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.*;

import org.junit.jupiter.api.Test;

import com.exasol.udfdebugging.modules.TestSetup;

class ProfilingModuleIT {

    @Test
    void test() throws SQLException, InterruptedException, IOException {
        final TestSetup udfSetup = new TestSetup();
        final Statement statement = udfSetup.getExasolContainer().createConnection().createStatement();
        final ResultSet resultSet = statement
                .executeQuery("SELECT SESSION_PARAMETER(current_session, 'SCRIPT_LANGUAGES')");
        resultSet.next();
        System.out.println(resultSet.getString(1));
        final ProfilingModule profilingModule = new ProfilingModule(udfSetup.getDefaultBucket(), null);
        udfSetup.getExasolContainer().execInContainer("python3",
                "/buckets/bfsdefault/default/profilingReportCapturer.py");
        udfSetup.runJavaUdf(profilingModule.getJvmOptions());
        Thread.sleep(1000);
        assertTrue(profilingModule.getFolderForResults().resolve("profile-1.hpl").toFile().exists());
    }
}
