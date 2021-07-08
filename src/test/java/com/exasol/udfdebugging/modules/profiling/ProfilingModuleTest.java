package com.exasol.udfdebugging.modules.profiling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.*;

import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;

class ProfilingModuleTest {
    @Test
    void testFileIsUploaded() throws InterruptedException, BucketAccessException, TimeoutException {
        final Bucket bucket = mock(Bucket.class);
        new ProfilingModule(bucket, null);
        verify(bucket).uploadFile(Path.of(".cache", "honest-profiler", "libagent.so"), "libagent.so");
    }

    @Test
    void testJvmOption() {
        final Bucket bucket = mock(Bucket.class);
        when(bucket.getBucketFsName()).thenReturn("mybfs");
        when(bucket.getBucketName()).thenReturn("mybucket");
        final ProfilingModule module = new ProfilingModule(bucket, null);
        assertThat(module.getJvmOptions().collect(Collectors.toList()), containsInAnyOrder(
                "-agentpath:/buckets/mybfs/mybucket/libagent.so=interval=7,logPath=/tmp/profile.hpl"));
    }
}