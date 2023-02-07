package com.exasol.udfdebugging;

import java.net.InetSocketAddress;

/**
 * Implementors of this interface exposes a local service (socket) into the Exasol database.
 */
@FunctionalInterface
public interface LocalServiceExposer {

    /**
     * Create an instance of {@code LocalServiceExposer} for a a host that does not require port mapping.
     *
     * @param host host name or IP address of host (but without port) providing the service to expose
     * @return new instance of {@code LocalServiceExposer}
     */
    public static LocalServiceExposer forHost(final String host) {
        return port -> new InetSocketAddress(host, port);
    }

    /**
     * Get the address for the network scope inside of the Exasol database for a given local service.
     *
     * @param port port number
     * @return proxy
     */
    InetSocketAddress exposeLocalServiceToDatabase(int port);
}
