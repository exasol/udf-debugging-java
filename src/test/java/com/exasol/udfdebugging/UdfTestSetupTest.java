package com.exasol.udfdebugging;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class UdfTestSetupTest {
    public static final String DEBUG_PROPERTY = "test.debug";
    private static final String EXPECTED_DEBUG_JVM_OPTION = "-agentlib:jdwp=transport=dt_socket,server=n,address=1.2.3.4:8000,suspend=y";

    @Test
    void testDebuggingEnabled() {
        System.setProperty(DEBUG_PROPERTY, "true");
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4");
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions, hasItem(EXPECTED_DEBUG_JVM_OPTION));
    }

    @Test
    void testDebuggingIsDisabledByDefault() {
        System.clearProperty(DEBUG_PROPERTY);
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4");
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions, not(hasItem(EXPECTED_DEBUG_JVM_OPTION)));
    }

    @Test
    void testDebuggingDisabled() {
        System.setProperty(DEBUG_PROPERTY, "false");
        final UdfTestSetup udfTestSetup = new UdfTestSetup("1.2.3.4");
        final List<String> jvmOptions = Arrays.asList(udfTestSetup.getJvmOptions());
        assertThat(jvmOptions, not(hasItem(EXPECTED_DEBUG_JVM_OPTION)));
    }
}