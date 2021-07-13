package com.exasol.udfdebugging.modules.jprofiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import com.exasol.errorreporting.ExaError;

/**
 * This class finds the path to the libjprofilerti.so in the jprofiler tar.gz archive.
 */
class InArchiveProfilerAgentPathDetector {
    private static final String AGENT_NAME = "linux-x64/libjprofilerti.so";

    /**
     * Find the path to the libjprofilerti.so in the jprofiler tar.gz archive.
     *
     * @param jprofilerArchive path of the jprofiler tar.gz archive
     * @return path to the agent lib inside of the archive
     */
    String findPathToAgent(final Path jprofilerArchive) {
        try (final TarArchiveInputStream tarInput = new TarArchiveInputStream(
                new GzipCompressorInputStream(Files.newInputStream(jprofilerArchive)))) {
            ArchiveEntry nextEntry = tarInput.getNextEntry();
            while (nextEntry != null) {
                final String entryPath = nextEntry.getName();
                if (entryPath.endsWith(AGENT_NAME)) {
                    return entryPath;
                }
                nextEntry = tarInput.getNextEntry();
            }
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-UDJ-14")
                    .message("Failed to extract JProfiler tar.gz archive for extracting the version information.")
                    .ticketMitigation().toString(), exception);
        }
        throw new IllegalStateException(ExaError.messageBuilder("E-UDJ-15")
                .message("Could not find " + AGENT_NAME + " in the provided jprofiler archive ({{archive file}}).",
                        jprofilerArchive)
                .mitigation("Make sure that you specified the correct jprofiler archive.")
                .mitigation(
                        "Future version of JProfiler could also have different agent file names. In that case, please open a ticket.")
                .toString());
    }
}
