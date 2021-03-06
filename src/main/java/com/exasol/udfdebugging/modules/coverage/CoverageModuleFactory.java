package com.exasol.udfdebugging.modules.coverage;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

public class CoverageModuleFactory extends AbstractModuleFactory {

    /**
     * Create a new instance of {@link CoverageModuleFactory}.
     */
    public CoverageModuleFactory() {
        super("coverage");
    }

    @Override
    public Module buildModule(final LocalServiceExposer localServiceExposer, final Bucket bucket) {
        return new CoverageModule(localServiceExposer, bucket);
    }
}
