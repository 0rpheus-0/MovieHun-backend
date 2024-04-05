package com.vitek.javalabs.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class Exceptions {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public Message handleInternalServerError(RuntimeException ex) {
        log.error("Unexpected exception", ex);
        return new Message("Something went wrong");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Message handleBadRequestException(BadRequestException ex) {
        log.error("Bad request", ex);
        return new Message("Try again");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Message handleNotFoundException(NotFoundException ex) {
        log.error("Not Found", ex);
        return new Message("Not Found. Try something else");
    }

    public record Message(String message) {
    }
}
