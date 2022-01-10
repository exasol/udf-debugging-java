package com.exasol.udfdebugging;

import java.sql.Connection;

import com.exasol.bucketfs.Bucket;

/**
 * Interface for factories for {@link Module}.
 */
public interface ModuleFactory {

    /**
     * Get if this module is enabled by system property.
     * 
     * @return {@code true} if this module is enabled
     */
    public boolean isEnabled();

    /**
     * Get the name of the property to enable this module.
     *
     * @return name of the property to enable this module
     */
    public String getModulePropertyName();

    /**
     * Build the {@link Module}.
     * 
     * @param localServiceExposer Proxy factory that makes ports of the test host available in the container
     * @param bucket              BucketFS bucket to upload resource to
     * @param exasolConnection    connection to the exasol database
     * @return built {@link Module}
     */
    public Module buildModule(final LocalServiceExposer localServiceExposer, Bucket bucket,
            final Connection exasolConnection);
}
