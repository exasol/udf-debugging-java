package com.exasol.udfdebugging.modules.udflogs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;
import java.util.function.Consumer;

import com.exasol.errorreporting.ExaError;

/**
 * This class opens a TCP socket and dumps everything to {@code STDOUT}. It is used for printing logs from the UDF.
 */
public final class LogRecorder implements AutoCloseable {
    private static final Path LOG_DIRECTORY = Path.of("target/udf-logs");
    private final Server server;

    /**
     * Create a new instance of {@link LogRecorder}.
     * 
     * @param logFileHandler callback to notify when a new log file is created
     */
    public LogRecorder(final Consumer<Path> logFileHandler) {
        try {
            if (!Files.exists(LOG_DIRECTORY)) {
                Files.createDirectory(LOG_DIRECTORY);
            }
            this.server = new Server(logFileHandler);
            new Thread(this.server).start();
        } catch (final IOException exception) {
            throw new UncheckedIOException(
                    ExaError.messageBuilder("E-UDJ-18")
                            .message("Failed to start server for retrieving UDF logs.", exception).toString(),
                    exception);
        }
    }

    @Override
    public void close() throws Exception {
        this.server.close();
    }

    /**
     * Get the port the log recorder listens on.
     * 
     * @return port number
     */
    public int getPort() {
        return this.server.getPort();
    }

    private static class Server implements Runnable, Closeable {
        private final ServerSocket serverSocket;
        private final Consumer<Path> logFileHandler;
        private boolean running = true;

        public Server(final Consumer<Path> logFileHandler) throws IOException {
            this.logFileHandler = logFileHandler;
            this.serverSocket = new ServerSocket(0);
        }

        int getPort() {
            return this.serverSocket.getLocalPort();
        }

        @Override
        public void run() {
            try {
                while (this.running) {
                    final Socket client = this.serverSocket.accept();
                    new Thread(new Logger(client, this.logFileHandler)).start();
                }
            } catch (final IOException exception) {
                // ignore
            }
        }

        @Override
        public void close() throws IOException {
            this.serverSocket.close();
            this.running = false;
        }
    }

    private static class Logger implements Runnable {
        private final Socket socket;
        private final Consumer<Path> logFileHandler;

        private Logger(final Socket socket, final Consumer<Path> logFileHandler) {
            this.socket = socket;
            this.logFileHandler = logFileHandler;
        }

        @Override
        public void run() {
            try {
                final Path logFile = Files.createTempFile(LOG_DIRECTORY, "udf-log-", ".txt");
                this.logFileHandler.accept(logFile);
                Files.copy(this.socket.getInputStream(), logFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (final IOException exception) {
                throw new UncheckedIOException(
                        ExaError.messageBuilder("E-UDJ-17").message("Failed to read from log stream.").toString(),
                        exception);
            } finally {
                try {
                    if (!this.socket.isClosed()) {
                        this.socket.close();
                    }
                } catch (final IOException e) {
                    // ignore
                }
            }
        }
    }
}
