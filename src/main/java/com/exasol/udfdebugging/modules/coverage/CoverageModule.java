package com.exasol.udfdebugging.modules.coverage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.errorreporting.ExaError;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;

/**
 * {@link Module} for measuring code coverage in UDFs.
 */
public class CoverageModule implements Module {
    private static final String JACOCO_AGENT_NAME = "org.jacoco.agent-runtime.jar";
    private static final Path JACOCO_AGENT_PATH = Path.of("target", "jacoco-agent", JACOCO_AGENT_NAME);
    private final String jvmOption;

    /**
     * Create a new instance of {@link CoverageModule}.
     * 
     * @param localServiceExposer Proxy factory that makes ports of the test host available in the container
     * @param bucket              Bucket to upload the agent to
     */
    public CoverageModule(final LocalServiceExposer localServiceExposer, final Bucket bucket) {
        assertJacocoAgentExists();
        uploadAgentToBucketFs(bucket);
        JacocoServer.startIfNotRunning();
        final InetSocketAddress proxyForHostPort = localServiceExposer.exposeLocalServiceToDatabase(JacocoServer.PORT);
        this.jvmOption = "-javaagent:/buckets/" + bucket.getBucketFsName() + "/" + bucket.getBucketName() + "/"
                + JACOCO_AGENT_NAME + "=output=tcpclient,address=" + proxyForHostPort.getHostName() + ",port="
                + proxyForHostPort.getPort();
    }

    private void assertJacocoAgentExists() {
        if (!JACOCO_AGENT_PATH.toFile().exists()) {
            throw new IllegalArgumentException(ExaError.messageBuilder("E-UDJ-1")
                    .message(
                            "Could not find jacoco agent ({{PATH}}). The agent should we generated by the maven build.")
                    .parameter("PATH", JACOCO_AGENT_PATH.toString())
                    .mitigation("Add the 'udf_coverage' module to the project-keeper plugin.").toString());
        }
    }

    @Override
    public Stream<String> getJvmOptions() {
        return Stream.of(this.jvmOption);
    }

    private void uploadAgentToBucketFs(final Bucket bucket) {
        try {
            bucket.uploadFile(JACOCO_AGENT_PATH, JACOCO_AGENT_NAME);
        } catch (final TimeoutException | BucketAccessException | FileNotFoundException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-5").message("Failed to upload jacoco agent to BucketFS.").toString(),
                    exception);
        }
    }

    @Override
    public void close() throws IOException {
        // nothing to close
    }
}
