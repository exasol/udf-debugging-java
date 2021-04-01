package com.exasol.udfdebugging;

/**
 * Factory interface for {@link HostPortProxy}.
 */
@FunctionalInterface
public interface HostPortProxyFactory {

    /**
     * Get the address of a proxy that makes the port of the test host available in the exasol database.
     * 
     * @param port port number
     * @return proxy
     */
    HostPortProxy getProxyForHostPort(int port);
}
