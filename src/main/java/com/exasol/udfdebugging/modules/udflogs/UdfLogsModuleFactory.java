package com.exasol.udfdebugging.modules.udflogs;

import java.sql.Connection;

import com.exasol.bucketfs.Bucket;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.modules.AbstractModuleFactory;

/**
 * Factory for {@link UdfLogsModule}.
 */
public class UdfLogsModuleFactory extends AbstractModuleFactory {
    /**
     * Create a new instance of {@link UdfLogsModuleFactory}.
     */
    public UdfLogsModuleFactory() {
        super("udf-logs");
    }

    @Override
    public Module buildModule(final LocalServiceExposer localServiceExposer, final Bucket bucket,
            final Connection exasolConnection) {
        return new UdfLogsModule(localServiceExposer, exasolConnection);
    }
}
