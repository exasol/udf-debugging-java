package com.exasol.udfdebugging.modules.debugging;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.HostPortProxyFactory;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

public class DebuggingModuleFactory extends AbstractModuleFactory {
    /**
     * Create a new instance of {@link DebuggingModuleFactory}.
     */
    public DebuggingModuleFactory() {
        super("debug");
    }

    @Override
    public Module buildModule(final HostPortProxyFactory hostPortProxyFactory, final Bucket bucket) {
        return new DebuggingModule(hostPortProxyFactory);
    }
}
