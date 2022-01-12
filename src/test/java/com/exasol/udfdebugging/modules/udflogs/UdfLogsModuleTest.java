package com.exasol.udfdebugging.modules.udflogs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exasol.exasoltestsetup.ServiceAddress;
import com.exasol.udfdebugging.LocalServiceExposer;

@ExtendWith(MockitoExtension.class)
class UdfLogsModuleTest {
    @Mock
    private LocalServiceExposer localServiceExposer;
    @Mock
    private Connection connection;
    @Mock
    private Statement statement;

    @BeforeEach
    void setUp() throws SQLException {
        when(this.connection.createStatement()).thenReturn(this.statement);
    }

    @Test
    void testSQlException() throws SQLException {
        when(this.localServiceExposer.exposeLocalServiceToDatabase(anyInt()))
                .thenReturn(new ServiceAddress("my-host", 1234));
        when(this.statement.executeUpdate(anyString())).thenThrow(new SQLException("mock exception"));
        final IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> new UdfLogsModule(this.localServiceExposer, this.connection));
        assertThat(exception.getMessage(), equalTo("E-UDJ-16: Failed to set script output address."));
    }

    @Test
    void testSqlInjection() {
        when(this.localServiceExposer.exposeLocalServiceToDatabase(anyInt()))
                .thenReturn(new ServiceAddress("my-ho' + 'st", 1234));
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UdfLogsModule(this.localServiceExposer, this.connection));
        assertThat(exception.getMessage(),
                equalTo("F-UDJ-19: Invalid address 'my-ho' + 'st:1234'. The address must not contain a quotes."));
    }
}