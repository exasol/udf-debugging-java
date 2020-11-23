package com.exasol.udfdebugging;

import java.util.stream.Stream;

/**
 * Modules define a specific functionality that users can enable using system properties.
 */
public interface Module {

    /**
     * Get JVM options required by this module.
     * 
     * @return JVM options
     */
    public Stream<String> getJvmOptions();
}
