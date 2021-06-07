package com.exasol.udfdebugging.modules.jprofiler;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

public class JProfilerModuleFactory extends AbstractModuleFactory {

    /**
     * Create a new instance of {@link JProfilerModuleFactory}.
     */
    public JProfilerModuleFactory() {
        super("jprofiler");
    }

    @Override
    public Module buildModule(final LocalServiceExposer localServiceExposer, final Bucket bucket) {
        return new JProfilerModule(bucket);
    }
}
