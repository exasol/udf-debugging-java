package com.exasol.udfdebugging;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.net.InetSocketAddress;
import java.sql.*;
import java.util.List;

import org.itsallcode.junit.sysextensions.SystemOutGuard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exasol.bucketfs.Bucket;
import com.exasol.exasoltestsetup.ExasolTestSetup;

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
            final List<String> jvmOptions = List.of(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions, hasItem(EXPECTED_DEBUG_JVM_OPTION));
        }
    }

    private UdfTestSetup getUdfTestSetup() {
        return new UdfTestSetup("1.2.3.4", mock(Bucket.class), this.connection);
    }

    @Test
    void testGetTestSetupForETAJ() {
        System.setProperty(COVERAGE_PROPERTY, "true");
        final ExasolTestSetup testSetup = mock(ExasolTestSetup.class);
        final Bucket bucket = mock(Bucket.class);
        when(testSetup.getDefaultBucket()).thenReturn(bucket);
        when(testSetup.makeLocalTcpServiceAccessibleFromDatabase(anyInt()))
                .thenReturn(new InetSocketAddress("4.3.2.1", 123));
        try (final UdfTestSetup udfTestSetup = new UdfTestSetup(testSetup, this.connection)) {
            final List<String> jvmOptions = List.of(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions, hasItem(
                    "-javaagent:/buckets/null/null/org.jacoco.agent-runtime.jar=output=tcpclient,address=4.3.2.1,port=123"));
        }
    }

    @Test
    void testCoverageEnabled() {
        System.setProperty(COVERAGE_PROPERTY, "true");
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            final List<String> jvmOptions = List.of(udfTestSetup.getJvmOptions());
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
            final List<String> jvmOptions = List.of(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions.isEmpty(), equalTo(true));
        }
    }

    @Test
    void testDebuggingDisabled() {
        System.setProperty(DEBUG_PROPERTY, "false");
        try (final UdfTestSetup udfTestSetup = getUdfTestSetup()) {
            final List<String> jvmOptions = List.of(udfTestSetup.getJvmOptions());
            assertThat(jvmOptions, not(hasItem(EXPECTED_DEBUG_JVM_OPTION)));
        }
    }
}