package com.exasol.udfdebugging.modules.coverage;

import java.sql.Connection;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

/**
 * Factory for {@link CoverageModule}.
 */
public class CoverageModuleFactory extends AbstractModuleFactory {

    /**
     * Create a new instance of {@link CoverageModuleFactory}.
     */
    public CoverageModuleFactory() {
        super("coverage");
    }

    @Override
    public Module buildModule(final LocalServiceExposer localServiceExposer, final Bucket bucket,
            final Connection exasolConnection) {
        return new CoverageModule(localServiceExposer, bucket);
    }
}
