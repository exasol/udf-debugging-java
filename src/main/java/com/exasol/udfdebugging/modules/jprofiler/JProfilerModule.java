package com.exasol.udfdebugging.modules.jprofiler;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.errorreporting.ExaError;
import com.exasol.udfdebugging.Module;

/**
 * {@link Module} for adding a JProfiler to an UDF instance.
 */
class JProfilerModule implements Module {
    public static final String AGENT_OPTION = "jProfilerAgent";
    private final String jvmOption;
    private final Path jprofilerArchive;

    /**
     * Create a new instance of {@link JProfilerModule}.
     * 
     * @param bucket bucket to upload the profiler to
     */
    JProfilerModule(final Bucket bucket) {
        this.jprofilerArchive = getJProfilerArchive();
        assertProfilerExists(this.jprofilerArchive);
        final String inArchivePath = new InArchiveProfilerAgentPathDetector().findPathToAgent(this.jprofilerArchive);
        uploadProfiler(bucket);
        this.jvmOption = "-agentpath:" + "/buckets/" + bucket.getBucketFsName() + "/" + bucket.getBucketName()
                + "/jprofiler/" + inArchivePath + "=port=11002";
    }

    private void uploadProfiler(final Bucket bucket) {
        try {
            bucket.uploadFile(this.jprofilerArchive, "jprofiler.tar.gz");
        } catch (final BucketAccessException | TimeoutException | FileNotFoundException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-13").message("Failed to upload jprofiler tar").toString(),
                    exception);
        }
    }

    private void assertProfilerExists(final Path jprofilerAgent) {
        if (!Files.exists(jprofilerAgent)) {
            throw new IllegalStateException(ExaError.messageBuilder("E-UDJ-8")
                    .message("Could not find jprofiler archive or open on path {{agent path}}).", jprofilerAgent)
                    .mitigation("Please download the JProfiler for Linux without JRE from the JProfiler website "
                            + "and specify the commandline option -D" + AGENT_OPTION
                            + "=<PATH TO jprofiler.tar.gz> or save it as ~/jprofiler.tar.gz.")
                    .toString());
        }
    }

    private Path getJProfilerArchive() {
        final String jProfilerAgentProperty = System.getProperty(AGENT_OPTION, "");
        if (jProfilerAgentProperty.isBlank()) {
            return Path.of(System.getProperty("user.home")).resolve("jprofiler.tar.gz");
        } else {
            return Path.of(jProfilerAgentProperty);
        }
    }

    @Override
    public Stream<String> getJvmOptions() {
        return Stream.of(this.jvmOption);
    }

    @Override
    public void close() {
        // nothing to close
    }
}
