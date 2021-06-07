package com.exasol.udfdebugging.modules.profiling;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

public class ProfilingModuleFactory extends AbstractModuleFactory {

    /**
     * Create a new instance of {@link ProfilingModuleFactory}.
     */
    public ProfilingModuleFactory() {
        super("profile");
    }

    @Override
    public Module buildModule(final LocalServiceExposer localServiceExposer, final Bucket bucket) {
        return new ProfilingModule(bucket, localServiceExposer);
    }
}
