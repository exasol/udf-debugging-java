package com.exasol.udfdebugging.modules.jprofiler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class InArchiveProfilerAgentPathDetectorTest {
    @Test
    void testExtractPath() {
        final Path exampleArchive = Path.of("src", "test", "resources", "jprofilerArchiveMock.tar.gz");
        assertThat(new InArchiveProfilerAgentPathDetector().findPathToAgent(exampleArchive),
                equalTo("subfolderA/linux-x64/libjprofilerti.so"));
    }
}