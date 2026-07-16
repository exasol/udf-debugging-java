package com.exasol.udfdebugging;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import com.exasol.udfdebugging.modules.TestSetup;

class PushDownTestingIT {
    private static final String VS_SCHEMA = "VS_SCHEMA";
    private static final String VS_ADAPTER = VS_SCHEMA + ".VS_ADAPTER";
    private static final String VIRTUAL_SCHEMA_NAME = "TEST_VS";
    private static final String TABLE_NAME = "THE_TABLE";

    private static String loadAdapterScriptContent() {
        try {
            return Files.readString(Paths.get("src/test/resources/virtual_schema_stub.lua"), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new AssertionError("Failed to read adapter script file.", exception);
        }
    }


    @Test
    void testGetPushDownSqlFromExplainVirtual() throws SQLException {
        try (
                final TestSetup testSetup = new TestSetup();
                final Statement statement = testSetup.getConnection().createStatement()
        ) {
            createVirtualSchema(statement);
            final String pushDownSql = PushDownTesting.getPushDownSql(statement,
                    "SELECT THE_VALUE FROM " + VIRTUAL_SCHEMA_NAME + "." + TABLE_NAME);
            assertThat(pushDownSql, equalTo("SELECT 'Hello VS!'"));
        }
    }

    @Test
    void testGetSelectionThatIsSentToTheAdapter() throws SQLException {
        try (
                final TestSetup testSetup = new TestSetup();
                final Statement statement = testSetup.getConnection().createStatement()
        ) {
            createVirtualSchema(statement);
            final String pushDownSql = PushDownTesting.getSelectionThatIsSentToTheAdapter(statement,
                    "SELECT THE_VALUE FROM " + VIRTUAL_SCHEMA_NAME + "." + TABLE_NAME
                            + " WHERE THE_VALUE = 'something'");
            assertThat(pushDownSql, equalTo(TABLE_NAME +".THE_VALUE='something'"));
        }
    }

    private void createVirtualSchema(final Statement statement) throws SQLException {
        statement.execute("DROP SCHEMA IF EXISTS " + VS_SCHEMA + "CASCADE");
        statement.execute("CREATE SCHEMA " + VS_SCHEMA);
        statement.execute("CREATE TABLE ORIGIN_TABLE(THE_VALUE CHAR(9))");
        statement.execute("CREATE LUA ADAPTER SCRIPT " + VS_ADAPTER + " AS\n" + loadAdapterScriptContent() + "\n/");
        statement.execute("CREATE VIRTUAL SCHEMA " + VIRTUAL_SCHEMA_NAME + " USING " + VS_ADAPTER);
    }
}
