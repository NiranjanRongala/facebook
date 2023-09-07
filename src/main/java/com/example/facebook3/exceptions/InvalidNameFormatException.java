package com.example.facebook3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class InvalidNameFormatException extends Exception {
    public InvalidNameFormatException(String exception) {
        super(exception);
    }
}

@RestControllerAdvice
class NameExceptionHandler {
    @ExceptionHandler(InvalidNameFormatException.class)
    public ResponseEntity<String> getMessage(InvalidNameFormatException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}