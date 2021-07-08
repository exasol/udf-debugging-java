package com.exasol.udfdebugging.modules.profiling;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.errorreporting.ExaError;
import com.exasol.udfdebugging.*;
import com.exasol.udfdebugging.Module;

/**
 * {@link Module} for running honest profiler in UDFs.
 */
public class ProfilingModule implements Module {
    private static final Path LOCAL_PROFILER_DIR = Path.of(".cache", "honest-profiler");
    private static final String PROFILER_AGENT_NAME = "liblagent.so";
    private static final Logger LOGGER = Logger.getLogger(ProfilingModule.class.getName());
    private static final String PROFILING_REPORT_CAPTURER_PY = "profilingReportCapturer.py";
    private final String jvmOption;
    private final Path folderForResults;

    public ProfilingModule(final Bucket bucket, final LocalServiceExposer localServiceExposer) {
        downloadHonestProfilerIfNotCached();
        uploadProfiler(bucket);
        uploadProfileCapturer(bucket);
        final ExposedServiceAddress profileServerAddress = localServiceExposer
                .exposeLocalServiceToDatabase(ProfileServer.PORT);

        System.out.println("Please run /buckets/" + bucket.getBucketFsName() + "/" + bucket.getBucketName() + "/"
                + PROFILING_REPORT_CAPTURER_PY + " " + profileServerAddress.getHostName() + ":"
                + profileServerAddress.getPort() + " in your test cluster and press any key to continue.");
        this.jvmOption = "-agentpath:/buckets/" + bucket.getBucketFsName() + "/" + bucket.getBucketName() + "/"
                + PROFILER_AGENT_NAME + "=interval=7,logPath=/tmp/profile.hpl";
        this.folderForResults = createFolderForResults();
        LOGGER.log(Level.INFO, "Profiling results will be written to {0}.", this.folderForResults);
        new ProfileServer(this.folderForResults);
    }

    public Path getFolderForResults() {
        return this.folderForResults;
    }

    private void uploadProfileCapturer(final Bucket bucket) {
        try {
            bucket.uploadInputStream(
                    () -> getClass().getClassLoader().getResourceAsStream(PROFILING_REPORT_CAPTURER_PY),
                    PROFILING_REPORT_CAPTURER_PY);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        } catch (final BucketAccessException | TimeoutException e) {
            throw new IllegalStateException(ExaError.messageBuilder("E-UDJ-12")
                    .message("Failed to upload profiler log caputuerer to bucketfs.").toString());
        }
    }

    private Path createFolderForResults() {
        try {
            return Files.createTempDirectory("profilingResult");
        } catch (final IOException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-11")
                            .message("Failed to create temporary local folder for profiling results.").toString(),
                    exception);
        }
    }

    private void uploadProfiler(final Bucket bucket) {
        try {
            bucket.uploadFile(LOCAL_PROFILER_DIR.resolve(PROFILER_AGENT_NAME), PROFILER_AGENT_NAME);
        } catch (final BucketAccessException | TimeoutException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-9").message("Failed to upload profiler to bucketfs.").toString(),
                    exception);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private void downloadHonestProfilerIfNotCached() {
        if (!LOCAL_PROFILER_DIR.toFile().exists()) {
            LOCAL_PROFILER_DIR.toFile().mkdirs();
            downloadHonestProfiler();
        }
    }

    private void downloadHonestProfiler() {
        try {
            final URL url = new URL("http://insightfullogic.com/honest-profiler.zip");
            try (final ZipInputStream profilerZipStream = new ZipInputStream(
                    new BufferedInputStream(url.openStream()))) {
                ZipEntry nextEntry = profilerZipStream.getNextEntry();
                while (nextEntry != null) {
                    extractFileFromZip(profilerZipStream, nextEntry);
                    nextEntry = profilerZipStream.getNextEntry();
                }
            }
        } catch (final IOException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-8").message("Failed to download honest profiler.").toString(),
                    exception);
        }
    }

    private void extractFileFromZip(final ZipInputStream profilerZipStream, final ZipEntry nextEntry)
            throws IOException {
        try (final FileOutputStream fileOutputStream = new FileOutputStream(
                LOCAL_PROFILER_DIR.resolve(nextEntry.getName()).toFile())) {
            int len;
            final byte[] buffer = new byte[10000];
            while ((len = profilerZipStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, len);
            }
        }
    }

    @Override
    public Stream<String> getJvmOptions() {
        return Stream.of(this.jvmOption);
    }
}
