package com.exasol.udfdebugging.modules.debugging;

import java.util.stream.Stream;

import com.exasol.udfdebugging.Module;

public class DebuggingModule implements Module {
    public static final String DEBUGGING_PORT = "8000";
    private final String testHostIpAddress;

    /**
     * Create a new instance of {@link DebuggingModule}.
     * 
     * @param testHostIpAddress IP address of the host running this UDF Test Setup under which UDFs can reach it
     */
    public DebuggingModule(final String testHostIpAddress) {
        this.testHostIpAddress = testHostIpAddress;
    }

    @Override
    public Stream<String> getJvmOptions() {
        return Stream.of("-agentlib:jdwp=transport=dt_socket,server=n,address=" + this.testHostIpAddress + ":"
                + DEBUGGING_PORT + ",suspend=y");
    }
}
