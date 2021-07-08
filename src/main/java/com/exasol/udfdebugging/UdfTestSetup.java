package com.exasol.udfdebugging;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exasol.bucketfs.Bucket;
import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ServiceAddress;
import com.exasol.udfdebugging.modules.coverage.CoverageModuleFactory;
import com.exasol.udfdebugging.modules.debugging.DebuggingModuleFactory;

/**
 * Test setup for testing UDFs in the database.
 */
public class UdfTestSetup {
    private static final List<ModuleFactory> AVAILABLE_MODULES = List.of(new DebuggingModuleFactory(),
            new CoverageModuleFactory());
    private static final Logger LOGGER = LoggerFactory.getLogger(UdfTestSetup.class);
    private final List<Module> enabledModules;

    /**
     * Create a new instance of {@link UdfTestSetup}.
     *
     * @param testHostIpAddress IP address of the host running this UDF Test Setup under which UDFs can reach it
     * @param bucket            BucketFS bucket to upload resource to
     */
    public UdfTestSetup(final String testHostIpAddress, final Bucket bucket) {
        this(port -> new ServiceAddress(testHostIpAddress, port), bucket);
    }

    /**
     * Create a new instance of {@link UdfTestSetup}.
     * 
     * @param localServiceExposer Proxy factory that makes ports of the test host available in the container
     * @param bucket              BucketFS bucket to upload resource to
     */
    private UdfTestSetup(final LocalServiceExposer localServiceExposer, final Bucket bucket) {
        this.enabledModules = AVAILABLE_MODULES.stream().filter(ModuleFactory::isEnabled)
                .map(moduleFactory -> moduleFactory.buildModule(localServiceExposer, bucket))
                .collect(Collectors.toList());
        printInfoMessage();
    }

    /**
     * Create a new instance of {@link UdfTestSetup}.
     * 
     * @param testSetup Exasol test setup
     */
    public UdfTestSetup(final ExasolTestSetup testSetup) {
        this(testSetup::makeLocalTcpServiceAccessibleFromDatabase, testSetup.getDefaultBucket());
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
        final StringBuilder messageBuilder = new StringBuilder("Udf Test Setup Configuration:\n");
        AVAILABLE_MODULES.forEach(module -> {
            messageBuilder.append(module.getModulePropertyName());
            messageBuilder.append(":\t");
            messageBuilder.append(module.isEnabled() ? "enabled" : "disabled");
            messageBuilder.append("\n");
        });
        return messageBuilder.toString();
    }
}
