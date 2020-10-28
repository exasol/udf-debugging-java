package com.exasol.udfdebugging.modules;

import com.exasol.udfdebugging.Module;
import com.exasol.udfdebugging.ModuleFactory;

/**
 * Abstract basis for {@link Module}.
 */
public abstract class AbstractModuleFactory implements ModuleFactory {
    private final String moduleProperty;

    /**
     * Create a new instance of {@link AbstractModuleFactory}.
     * 
     * @param moduleName name of the module
     */
    protected AbstractModuleFactory(final String moduleName) {
        this.moduleProperty = "test." + moduleName;
    }

    @Override
    public final boolean isEnabled() {
        return System.getProperty(this.moduleProperty, "false").equals("true");
    }

    @Override
    public String getModulePropertyName() {
        return this.moduleProperty;
    }
}
