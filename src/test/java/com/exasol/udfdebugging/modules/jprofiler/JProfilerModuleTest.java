package com.exasol.udfdebugging.modules.jprofiler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;

class JProfilerModuleTest {
    private static final Path MOCK_AGENT_ARCHIVE = Path.of("src", "test", "resources", "jprofilerArchiveMock.tar.gz");

    @BeforeAll
    static void beforeAll() {
        System.setProperty(JProfilerModule.AGENT_OPTION, MOCK_AGENT_ARCHIVE.toString());
    }

    @Test
    void testUpload() throws BucketAccessException, TimeoutException, FileNotFoundException {
        final Bucket bucket = mock(Bucket.class);
        new JProfilerModule(bucket);
        verify(bucket).uploadFile(MOCK_AGENT_ARCHIVE, "jprofiler.tar.gz");
    }

    @Test
    void testGetJvmOptions() {
        final Bucket bucket = mock(Bucket.class);
        when(bucket.getBucketFsName()).thenReturn("my_bucketfs");
        when(bucket.getBucketName()).thenReturn("my_bucket");
        final JProfilerModule coverageModule = new JProfilerModule(bucket);
        assertThat(coverageModule.getJvmOptions().collect(Collectors.toList()),
                contains("-agentpath:/buckets/my_bucketfs/my_bucket/jprofiler/subfolderA/linux-x64/libjprofilerti.so"
                        + "=port=11002"));
    }
}