package com.exasol.udfdebugging.modules.udflogs;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class LogRecorderTest {

    @Test
    void testLogsAreWrittenAsFile() throws Exception {
        final List<Path> logFiles = new ArrayList<>();
        final LogRecorder logRecorder = new LogRecorder(logFiles::add);
        final StreamToLogger connection = new StreamToLogger(logRecorder.getPort());
        connection.write("test");
        assertThat(logFiles, Matchers.hasSize(1));
        assertThat(Files.readString(logFiles.get(0)), Matchers.equalTo("test"));
        connection.close();
        logRecorder.close();
    }

    @Test
    void testParallelStreams() throws Exception {
        final List<Path> logFiles = new ArrayList<>();
        final LogRecorder logRecorder = new LogRecorder(logFiles::add);
        final StreamToLogger connection1 = new StreamToLogger(logRecorder.getPort());
        connection1.write("test");
        assertThat(logFiles, Matchers.hasSize(1));
        assertThat(Files.readString(logFiles.get(0)), Matchers.equalTo("test"));
        final StreamToLogger connection2 = new StreamToLogger(logRecorder.getPort());
        connection2.write("other");
        assertThat(logFiles, Matchers.hasSize(2));
        assertThat(Files.readString(logFiles.get(1)), Matchers.equalTo("other"));
        connection1.close();
        connection2.close();
        logRecorder.close();
    }

    private static class StreamToLogger implements Closeable {
        private final Socket socket;
        private final OutputStream outputStream;
        private final PrintWriter writer;

        public StreamToLogger(final int port) throws IOException {
            this.socket = new Socket("localhost", port);
            this.outputStream = this.socket.getOutputStream();
            this.writer = new PrintWriter(this.outputStream);
        }

        public void write(final String message) throws InterruptedException {
            this.writer.write(message);
            this.writer.flush();
            Thread.sleep(100);
        }

        @Override
        public void close() throws IOException {
            this.writer.close();
            this.outputStream.close();
            this.socket.close();
        }
    }
}