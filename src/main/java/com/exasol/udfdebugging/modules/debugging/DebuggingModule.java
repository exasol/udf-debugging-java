package com.exasol.udfdebugging.modules.debugging;

import java.util.stream.Stream;

import com.exasol.udfdebugging.*;
import com.exasol.udfdebugging.Module;

public class DebuggingModule implements Module {
    public static final int DEBUGGING_PORT = 8000;
    private final HostPortProxyFactory hostPortProxyFactory;

    /**
     * Create a new instance of {@link DebuggingModule}.
     * 
     * @param hostPortProxyFactory Proxy factory that makes ports of the test host available in the container
     */
    public DebuggingModule(final HostPortProxyFactory hostPortProxyFactory) {
        this.hostPortProxyFactory = hostPortProxyFactory;
    }

    @Override
    public Stream<String> getJvmOptions() {
        final HostPortProxy proxyForHostPort = this.hostPortProxyFactory.getProxyForHostPort(DEBUGGING_PORT);
        return Stream.of("-agentlib:jdwp=transport=dt_socket,server=n,address=" + proxyForHostPort.getHostName() + ":"
                + proxyForHostPort.getPort() + ",suspend=y");
    }
}
