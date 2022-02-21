package com.exasol.udfdebugging;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exasol.bucketfs.Bucket;
import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ServiceAddress;
import com.exasol.udfdebugging.modules.coverage.CoverageModuleFactory;
import com.exasol.udfdebugging.modules.debugging.DebuggingModuleFactory;
import com.exasol.udfdebugging.modules.jprofiler.JProfilerModuleFactory;
import com.exasol.udfdebugging.modules.udflogs.UdfLogsModuleFactory;

/**
 * Test setup for testing UDFs in the database.
 */
public class UdfTestSetup implements AutoCloseable {
    private static final List<ModuleFactory> AVAILABLE_MODULES = List.of(new DebuggingModuleFactory(),
            new CoverageModuleFactory(), new JProfilerModuleFactory(), new UdfLogsModuleFactory());
    private static final Logger LOGGER = LoggerFactory.getLogger(UdfTestSetup.class);
    private final List<Module> enabledModules;

    /**
     * Create a new instance of {@link UdfTestSetup}.
     *
     * @param testHostIpAddress IP address of the host running this UDF Test Setup under which UDFs can reach it
     * @param bucket            BucketFS bucket to upload resource to
     * @param exasolConnection  connection to the Exasol database. Make sure that your tests use the same connection
     */
    public UdfTestSetup(final String testHostIpAddress, final Bucket bucket, final Connection exasolConnection) {
        this(port -> new ServiceAddress(testHostIpAddress, port), bucket, exasolConnection);
    }

    /**
     * Create a new instance of {@link UdfTestSetup}.
     * 
     * @param localServiceExposer Proxy factory that makes ports of the test host available in the container
     * @param bucket              BucketFS bucket to upload resource to
     * @param exasolConnection    connection to the Exasol database. Make sure that your tests use the same connection
     */
    private UdfTestSetup(final LocalServiceExposer localServiceExposer, final Bucket bucket,
            final Connection exasolConnection) {
        this.enabledModules = AVAILABLE_MODULES.stream().filter(ModuleFactory::isEnabled)
                .map(moduleFactory -> moduleFactory.buildModule(localServiceExposer, bucket, exasolConnection))
                .collect(Collectors.toList());
        printInfoMessage();
    }

    /**
     * Create a new instance of {@link UdfTestSetup}.
     * 
     * @param testSetup        Exasol test setup
     * @param exasolConnection connection to the Exasol database. Make sure that your tests use the same connection
     */
    public UdfTestSetup(final ExasolTestSetup testSetup, final Connection exasolConnection) {
        this(testSetup::makeLocalTcpServiceAccessibleFromDatabase, testSetup.getDefaultBucket(), exasolConnection);
    }

    /**
     * Get JVM options required for this setup.
     * 
     * @return array of JVM options
     */
    public String[] getJvmOptions() {
        return this.enabledModules.stream().flatMap(Module::getJvmOptions).toArray(String[]::new);
    }

    private void printInfoMessage() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(getInfoMessage());
        }
    }

    private String getInfoMessage() {
        return AVAILABLE_MODULES.stream()
                .map(module -> module.getModulePropertyName() + ": " + (module.isEnabled() ? "✓" : "✗"))
                .collect(Collectors.joining("; ")) + "\n";
    }

    @Override
    public void close() {
        for (final Module enabledModule : this.enabledModules) {
            try {
                enabledModule.close();
            } catch (final Exception exception) {
                // at least we tried
            }
        }
    }
}
