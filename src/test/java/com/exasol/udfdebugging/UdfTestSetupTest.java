package com.exasol.udfdebugging;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.bucketfs.Bucket;

class UdfTestSetupTest {
    public static final String COVERAGE_PROPERTY = "test.coverage";
    public static final String DEBUG_PROPERTY = "test.debug";
    private static final String EXPECTED_DEBUG_JVM_OPTION = "-agentlib:jdwp=transport=dt_socket,server=n,address=1.2.3.4:8000,suspend=y";

    @BeforeEach
    void before() {
        System.clearProperty(DEBUG_PROPERTY);
        System.clearProperty(COVERAGE_PROPERTY);
    }

    @Test
    void testDebuggingEnabled() {
        System.setProperty(DEBUG_PROPERTY, "true");
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4", mock(Bucket.class));
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions, hasItem(EXPECTED_DEBUG_JVM_OPTION));
    }

    @Test
    void testCoverageEnabled() {
        System.setProperty(COVERAGE_PROPERTY, "true");
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4", mock(Bucket.class));
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions, hasItem(
                "-javaagent:/buckets/null/null/org.jacoco.agent-runtime.jar=output=tcpclient,address=1.2.3.4,port=3002"));
    }

    @Test
    void testAllModulesAreDisabledByDefault() {
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4", mock(Bucket.class));
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions.isEmpty(), equalTo(true));
    }

    @Test
    void testDebuggingDisabled() {
        System.setProperty(DEBUG_PROPERTY, "false");
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4", mock(Bucket.class));
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions, not(hasItem(EXPECTED_DEBUG_JVM_OPTION)));
    }
}