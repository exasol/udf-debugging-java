package com.exasol.udfdebugging.modules.jprofiler;

import java.sql.Connection;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.*;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

/**
 * {@link ModuleFactory} for {@link JProfilerModule}.
 */
public class JProfilerModuleFactory extends AbstractModuleFactory {

    /**
     * Create a new instance of {@link JProfilerModuleFactory}.
     */
    public JProfilerModuleFactory() {
        super("jprofiler");
    }

    @Override
    public Module buildModule(final LocalServiceExposer localServiceExposer, final Bucket bucket,
            final Connection exasolConnection) {
        return new JProfilerModule(bucket);
    }
}
