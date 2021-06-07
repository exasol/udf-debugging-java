package com.exasol.udfdebugging.modules.profiling;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

import com.exasol.errorreporting.ExaError;
import com.sun.net.httpserver.*;

public class ProfileServer {
    public static final int PORT = 8000;
    private final Path profilesDirectory;
    int fileCounter = 1;

    public ProfileServer(final Path profilesDirectory) {
        this.profilesDirectory = profilesDirectory;
        final HttpServer server = startServer();
        server.createContext("/pushProfile", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    private HttpServer startServer() {
        final HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress(PORT), 0);
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-UDJ-10")
                    .message("Failed to start server for profiling results.").toString(), exception);
        }
        return server;
    }

    private class MyHandler implements HttpHandler {
        @Override
        public void handle(final HttpExchange requestHandle) throws IOException {
            final Path destinationFile = ProfileServer.this.profilesDirectory
                    .resolve("profile-" + ProfileServer.this.fileCounter + ".hpl");
            ProfileServer.this.fileCounter++;
            Files.copy(requestHandle.getRequestBody(), destinationFile);
            requestHandle.sendResponseHeaders(200, 0);
            requestHandle.getResponseBody().close();
        }
    }
}
