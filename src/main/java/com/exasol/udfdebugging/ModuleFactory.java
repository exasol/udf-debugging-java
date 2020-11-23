package com.exasol.udfdebugging;

import com.exasol.bucketfs.Bucket;

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
     * @param testHostIpAddress IP address of the host running this UDF Test Setup under which UDFs can reach it
     * @param bucket            BucketFS bucket to upload resource to
     * @return built {@link Module}
     */
    public Module buildModule(final String testHostIpAddress, Bucket bucket);
}
