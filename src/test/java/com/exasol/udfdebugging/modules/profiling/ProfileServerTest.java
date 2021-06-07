package com.exasol.udfdebugging.modules.profiling;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ProfileServerTest {

    @Test
    void test(@TempDir final Path tempDir) throws InterruptedException, IOException {
        final ProfileServer profileServer = new ProfileServer(tempDir);
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8000/pushProfile"))
                .PUT(HttpRequest.BodyPublishers.ofString("test")).build();
        client.send(request, HttpResponse.BodyHandlers.discarding());
        assertThat(Files.readString(tempDir.resolve("profile-1.hpl")), equalTo("test"));
    }
}