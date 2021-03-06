package com.exasol.udfdebugging.modules.debugging;

import java.util.stream.Stream;

import com.exasol.exasoltestsetup.ServiceAddress;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;

public class DebuggingModule implements Module {
    public static final int DEBUGGING_PORT = 8000;
    private final LocalServiceExposer localServiceExposer;

    /**
     * Create a new instance of {@link DebuggingModule}.
     * 
     * @param localServiceExposer Proxy factory that makes ports of the test host available in the container
     */
    public DebuggingModule(final LocalServiceExposer localServiceExposer) {
        this.localServiceExposer = localServiceExposer;
    }

    @Override
    public Stream<String> getJvmOptions() {
        final ServiceAddress proxyForHostPort = this.localServiceExposer.exposeLocalServiceToDatabase(DEBUGGING_PORT);
        return Stream.of("-agentlib:jdwp=transport=dt_socket,server=n,address=" + proxyForHostPort.getHostName() + ":"
                + proxyForHostPort.getPort() + ",suspend=y");
    }
}
