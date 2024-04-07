package com.vitek.javalabs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class Exceptions {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public Error handleInternalServerError(RuntimeException ex) {
        log.error("Unexpected exception", ex);
        return new Error("Oops...");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Error handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("Type mismatch", ex);
        return new Error(String.format("Invalid format of parameter: %s",
                ex.getName()));
    }

    @Getter
    @AllArgsConstructor
    public class Error {
        private String message;
    }
}
