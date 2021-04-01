package com.exasol.udfdebugging.modules.coverage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.*;

import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.udfdebugging.ExposedServiceAddress;

class CoverageModuleTest {

    @Test
    void testUpload() throws InterruptedException, BucketAccessException, TimeoutException {
        final Bucket bucket = mock(Bucket.class);
        new CoverageModule((port) -> new ExposedServiceAddress("1.2.3.4", port), bucket);
        verify(bucket).uploadFile(Path.of("target", "jacoco-agent", "org.jacoco.agent-runtime.jar"),
                "org.jacoco.agent-runtime.jar");
    }

    @Test
    void testGetJvmOptions() {
        final Bucket bucket = mock(Bucket.class);
        when(bucket.getBucketFsName()).thenReturn("my_bucketfs");
        when(bucket.getBucketName()).thenReturn("my_bucket");
        final CoverageModule coverageModule = new CoverageModule((port) -> new ExposedServiceAddress("1.2.3.4", port),
                bucket);
        assertThat(coverageModule.getJvmOptions().collect(Collectors.toList()), contains(
                "-javaagent:/buckets/my_bucketfs/my_bucket/org.jacoco.agent-runtime.jar=output=tcpclient,address=1.2.3.4,port=3002"));
    }
}