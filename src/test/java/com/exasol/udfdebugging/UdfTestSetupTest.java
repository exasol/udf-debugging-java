package com.exasol.udfdebugging;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import org.itsallcode.junit.sysextensions.SystemOutGuard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exasol.bucketfs.Bucket;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemOutGuard.class)
class UdfTestSetupTest {
    public static final String COVERAGE_PROPERTY = "test.coverage";
    public static final String DEBUG_PROPERTY = "test.debug";
    public static final String UDF_LOGS_PROPERTY = "test.udf-logs";
    private static final String EXPECTED_DEBUG_JVM_OPTION = "-agentlib:jdwp=transport=dt_socket,server=n,address=1.2.3.4:8000,suspend=y";
    @Mock
    private Connection connection;

    @BeforeEach
    void before() {
        System.clearProperty(DEBUG_PROPERTY);
        System.clearProperty(COVERAGE_PROPERTY);
        System.clearProperty(UDF_LOGS_PROPERTY);
    }

    @Test
    void testDebuggingEnabled() {
        System.setProperty(DEBUG_PROPERTY, "true");
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions, hasItem(EXPECTED_DEBUG_JVM_OPTION));
        }
    }

    private UdfTestSetup getUdfTestSetup() {
        return new UdfTestSetup("1.2.3.4", mock(Bucket.class), this.connection);
    }

    @Test
    void testCoverageEnabled() {
        System.setProperty(COVERAGE_PROPERTY, "true");
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions, hasItem(
                    "-javaagent:/buckets/null/null/org.jacoco.agent-runtime.jar=output=tcpclient,address=1.2.3.4,port=3002"));
        }
    }

    @Test
    void testUdfLogsEnabled() throws SQLException {
        final Statement statement = mock(Statement.class);
        when(this.connection.createStatement()).thenReturn(statement);
        System.setProperty(UDF_LOGS_PROPERTY, "true");
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            verify(statement)
                    .executeUpdate(ArgumentMatchers.startsWith("ALTER SESSION SET SCRIPT_OUTPUT_ADDRESS = '1.2.3.4"));
        }
    }

    @Test
    void testAllModulesAreDisabledByDefault() {
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions.isEmpty(), equalTo(true));
        }
    }

    @Test
    void testDebuggingDisabled() {
        System.setProperty(DEBUG_PROPERTY, "false");
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions, not(hasItem(EXPECTED_DEBUG_JVM_OPTION)));
        }
    }
}