package com.exasol.udfdebugging.modules.udflogs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LogRecorderTest {

    @Test
    void testLogsAreWrittenAsFile() throws Exception {
        final List<Path> logFiles = new ArrayList<>();
        try (final LogRecorder logRecorder = new LogRecorder(logFiles::add);
                final StreamToLogger connection = new StreamToLogger(logRecorder.getPort());) {
            connection.write("test");
            assertAll(() -> assertThat(logFiles, hasSize(1)),
                    () -> assertThat(Files.readString(logFiles.get(0)), equalTo("test")));
        }
    }

    @Test
    void testParallelStreams() throws Exception {
        final List<Path> logFiles = new ArrayList<>();
        try (final LogRecorder logRecorder = new LogRecorder(logFiles::add);
                final StreamToLogger connection1 = new StreamToLogger(logRecorder.getPort());) {
            connection1.write("test");
            assertAll(() -> assertThat(logFiles, hasSize(1)),
                    () -> assertThat(Files.readString(logFiles.get(0)), equalTo("test")));
            try (final StreamToLogger connection2 = new StreamToLogger(logRecorder.getPort())) {
                connection2.write("other");
                assertAll(() -> assertThat(logFiles, hasSize(2)),
                        () -> assertThat(Files.readString(logFiles.get(1)), equalTo("other")));
            }
        }
    }

    private static class StreamToLogger implements Closeable {
        private final Socket socket;
        private final PrintWriter writer;

        public StreamToLogger(final int port) throws IOException {
            this.socket = new Socket("localhost", port);
            this.writer = new PrintWriter(this.socket.getOutputStream());
        }

        @SuppressWarnings("java:S2925") // sleep is required
        public void write(final String message) throws InterruptedException {
            this.writer.write(message);
            this.writer.flush();
            Thread.sleep(100);
        }

        @Override
        public void close() throws IOException {
            this.writer.close();
            this.socket.close();
        }
    }
}
