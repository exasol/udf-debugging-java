package com.exasol.udfdebugging.modules.coverage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;

class CoverageModuleTest {

    @Test
    @SuppressWarnings("try") // auto-closeable resource coverageModule is never referenced in body of try statement
    void testUpload() throws BucketAccessException, TimeoutException, FileNotFoundException {
        final Bucket bucket = mock(Bucket.class);
        try (CoverageModule coverageModule = new CoverageModule(port -> new InetSocketAddress("1.2.3.4", port),
                bucket)) {
            verify(bucket).uploadFile(Path.of("target", "jacoco-agent", "org.jacoco.agent-runtime.jar"),
                    "org.jacoco.agent-runtime.jar");
        }
    }

    @Test
    void testGetJvmOptions() {
        final Bucket bucket = mock(Bucket.class);
        when(bucket.getBucketFsName()).thenReturn("my_bucketfs");
        when(bucket.getBucketName()).thenReturn("my_bucket");
        try (final CoverageModule coverageModule = new CoverageModule(port -> new InetSocketAddress("1.2.3.4", port),
                bucket)) {
            assertThat(coverageModule.getJvmOptions().collect(Collectors.toList()), contains(
                    "-javaagent:/buckets/my_bucketfs/my_bucket/org.jacoco.agent-runtime.jar=output=tcpclient,address=1.2.3.4,port=3002"));
        }
    }
}
