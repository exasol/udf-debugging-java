package com.exasol.udfdebugging;

/**
 * This class describes the address of a proxy for ports of the test host.
 */
public class HostPortProxy {
    private final String hostName;
    private final int port;

    /**
     * Create a new instance of {@link HostPortProxy}.
     * 
     * @param hostName host name of the proxy
     * @param port     port number
     */
    public HostPortProxy(final String hostName, final int port) {
        this.hostName = hostName;
        this.port = port;
    }

    /**
     * Get the host name of the proxy.
     * 
     * @return host name
     */
    public String getHostName() {
        return this.hostName;
    }

    /**
     * Get the port number of the proxy.
     * 
     * @return port number
     */
    public int getPort() {
        return this.port;
    }
}
