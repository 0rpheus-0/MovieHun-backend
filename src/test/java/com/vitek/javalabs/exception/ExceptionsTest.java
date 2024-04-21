package com.vitek.javalabs.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ExtendWith(MockitoExtension.class)
class ExceptionsTest {
    private Exceptions exceptions;

    @BeforeEach
    void setUp() {
        exceptions = new Exceptions();
    }

    @Test
    void handleInternalServerError() {
        RuntimeException exception = new RuntimeException("Test exception");

        Exceptions.Error result = exceptions.handleInternalServerError(exception);

        assertNotNull(result);
        assertEquals("Something went wrong", result.getMessage());
    }

    @Test
    void handleTypeMismatchException() {
        MethodArgumentTypeMismatchException exception = mock(MethodArgumentTypeMismatchException.class);
        Exceptions.Error result = exceptions.handleypeMismatchException(exception);

        assertNotNull(result);
        assertEquals("Invalid format of parameter: " + "null", result.getMessage());
    }
}
