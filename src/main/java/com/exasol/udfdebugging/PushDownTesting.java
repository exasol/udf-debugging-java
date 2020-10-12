package com.exasol.udfdebugging;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PushDownTesting {
    public static String getPushDownSql(final Statement statement, final String query) throws SQLException {
        try (final ResultSet pushDownSqlResult = statement
                .executeQuery("SELECT PUSHDOWN_SQL FROM (EXPLAIN VIRTUAL " + query + ");")) {
            pushDownSqlResult.next();
            return pushDownSqlResult.getString("PUSHDOWN_SQL");
        }
    }

    public static String getSelectionThatIsSentToTheAdapter(final Statement statement, final String query) throws SQLException {
        try (final ResultSet pushDownSqlResult = statement
                .executeQuery("SELECT PUSHDOWN_JSON FROM (EXPLAIN VIRTUAL " + query + ");")) {
            pushDownSqlResult.next();
            final String pushdownJson = pushDownSqlResult.getString("PUSHDOWN_JSON");
            try (final JsonReader reader = Json.createReader(new StringReader(pushdownJson))) {
                final JsonObject response = reader.readArray().get(2).asJsonObject();
                return response.getJsonObject("pushdownRequest").getString("filter_expr_string_for_debug");
            }
        }
    }
}
