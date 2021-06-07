package com.exasol.udfdebugging.modules.jprofiler;

import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.errorreporting.ExaError;
import com.exasol.udfdebugging.Module;

public class JProfilerModule implements Module {
    private final String jvmOption;

    public JProfilerModule(final Bucket bucket) {
        uploadProfiler(bucket);
        this.jvmOption = "-agentpath:/buckets/" + bucket.getBucketFsName() + "/" + bucket.getBucketName() + "/"
                + "jprofiler_linux_12_0_2/jprofiler12.0.2/bin/linux-x64/libjprofilerti.so=port=11002";
    }

    private void uploadProfiler(final Bucket bucket) {
        try {
            bucket.uploadFile(Path.of("~/jprofiler_linux_12_0_2.tar.gz"), "jprofiler_linux_12_0_2.tar.gz");
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        } catch (final BucketAccessException | TimeoutException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-13").message("Failed to upload jprofiler tar").toString(),
                    exception);
        }
    }

    @Override
    public Stream<String> getJvmOptions() {
        return Stream.of(this.jvmOption);
    }
}
