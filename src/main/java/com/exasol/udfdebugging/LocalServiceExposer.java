package com.exasol.udfdebugging;

/**
 * Implementors of this interface exposes a local service (socket) into the Exasol database.
 */
@FunctionalInterface
public interface LocalServiceExposer {

    /**
     * Get the address for the network scope inside of the Exasol database for a given local service.
     * 
     * @param port port number
     * @return proxy
     */
    ExposedServiceAddress exposeLocalServiceToDatabase(int port);
}
