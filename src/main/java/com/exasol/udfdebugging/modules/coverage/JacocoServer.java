package com.exasol.udfdebugging.modules.coverage;

/*
 * *****************************************************************************
 * Modified example from {@link https://raw.githubusercontent.com/jacoco/jacoco/master/org.jacoco.examples/src/org/jacoco/examples/ExecutionDataServer.java}
 *
 * Original license:
 *
 * Copyright (c) 2009, 2020 Mountainminds GmbH & Co. KG and Contributors
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;

import org.jacoco.core.data.*;
import org.jacoco.core.runtime.RemoteControlReader;
import org.jacoco.core.runtime.RemoteControlWriter;

import com.exasol.errorreporting.ExaError;

/**
 * This class starts a socket server to collect the code coverage data from the jacoco agent in the udfs. The collected
 * data is dumped to a local file.
 */
final class JacocoServer implements Runnable {

    static final int PORT = 3002;
    static final Path COVERAGE_REPORT_PATH = Path.of("target", "jacoco-udf.exec");
    private static JacocoServer instance;
    private final ExecutionDataWriter fileWriter;

    private JacocoServer() throws IOException {
        this.fileWriter = new ExecutionDataWriter(new FileOutputStream(COVERAGE_REPORT_PATH.toFile()));
    }

    static void startIfNotRunning() {
        if (instance == null) {
            try {
                instance = new JacocoServer();
                new Thread(instance).start();
            } catch (final IOException exception) {
                throw new IllegalStateException(ExaError.messageBuilder("E-UDJ-2")
                        .message("Failed to create jacoco log server thread.").toString(), exception);
            }
        }
    }

    @Override
    public void run() {
        try (final ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                final Handler handler = new Handler(server.accept(), this.fileWriter);
                new Thread(handler).start();
            }
        } catch (final IOException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-3").message("Failed to start jacoco log server.").toString(),
                    exception);
        }
    }

    private static class Handler implements Runnable, ISessionInfoVisitor, IExecutionDataVisitor {

        private final Socket socket;
        private final RemoteControlReader reader;
        private final ExecutionDataWriter fileWriter;

        Handler(final Socket socket, final ExecutionDataWriter fileWriter) throws IOException {
            this.socket = socket;
            this.fileWriter = fileWriter;

            // Just send a valid header:
            new RemoteControlWriter(socket.getOutputStream());

            this.reader = new RemoteControlReader(socket.getInputStream());
            this.reader.setSessionInfoVisitor(this);
            this.reader.setExecutionDataVisitor(this);
        }

        public void run() {
            try {
                while (this.reader.read()) {
                    // read everything so that visitors are invoked
                }
                this.socket.close();
                synchronized (this.fileWriter) {
                    this.fileWriter.flush();
                }
            } catch (final IOException exception) {
                throw new IllegalStateException(
                        ExaError.messageBuilder("E-UDJ-7").message("Failed to write jacoco report.").toString(),
                        exception);
            }
        }

        public void visitSessionInfo(final SessionInfo info) {
            synchronized (this.fileWriter) {
                this.fileWriter.visitSessionInfo(info);
            }
        }

        public void visitClassExecution(final ExecutionData data) {
            synchronized (this.fileWriter) {
                this.fileWriter.visitClassExecution(data);
            }
        }
    }
}