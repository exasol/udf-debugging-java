package com.exasol.udfdebugging.modules.udflogs;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.ServiceAddress;
import com.exasol.udfdebugging.LocalServiceExposer;
import com.exasol.udfdebugging.Module;

/**
 * This module redirects the STDOUT of UDFs to files on the test host.
 * <p>
 * For that it uses the {@code ALTER SESSION SET SCRIPT_OUTPUT_ADDRESS} command of the Exasol database.
 * </p>
 */
public class UdfLogsModule implements Module {
    private static final Logger LOGGER = Logger.getLogger(UdfLogsModule.class.getName());
    private final LogRecorder logRecorder;
    private final List<Path> capturedLogFiles = new ArrayList<>();

    /**
     * Create a new instance of {@link UdfLogsModule}.
     * 
     * @param localServiceExposer proxy factory that makes ports of the test host available in the container
     * @param exasolConnection    connection to the exasol database
     */
    public UdfLogsModule(final LocalServiceExposer localServiceExposer, final Connection exasolConnection) {
        final Consumer<Path> logFileHandler = file -> {
            this.capturedLogFiles.add(file);
            LOGGER.log(Level.INFO, "Created log file for UDF output: {0}", file);
        };
        this.logRecorder = new LogRecorder(logFileHandler);
        final ServiceAddress inDbAddress = localServiceExposer.exposeLocalServiceToDatabase(this.logRecorder.getPort());
        redirectLogging(exasolConnection, inDbAddress);
    }

    @Override
    public Stream<String> getJvmOptions() {
        return Stream.empty();
    }

    /**
     * Get all log files that were captured.
     * 
     * @return list of captured log files.
     */
    public List<Path> getCapturedLogFiles() {
        return this.capturedLogFiles;
    }

    private void redirectLogging(final Connection exasolConnection, final ServiceAddress logServerAddress) {
        try (final Statement statement = exasolConnection.createStatement()) {
            final String logServerAddressString = logServerAddress.toString();
            if (logServerAddressString.contains("'")) {
                throw new IllegalArgumentException(ExaError.messageBuilder("F-UDJ-19")
                        .message("Invalid address {{address}}. The address must not contain a quotes.",
                                logServerAddressString)
                        .toString());
            }
            statement.executeUpdate("ALTER SESSION SET SCRIPT_OUTPUT_ADDRESS = '" + logServerAddressString + "';");
        } catch (final SQLException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-UDJ-16").message("Failed to set script output address.").toString(),
                    exception);
        }
    }

    @Override
    public void close() {
        try {
            this.logRecorder.close();
        } catch (final Exception exception) {
            // at least we tried
        }
    }
}
