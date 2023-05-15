package com.example.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice indicates this class will contain special methods
// for handling exceptional conditions
// - the handler methods should be annotated with @ExceptionHandler
@ControllerAdvice
public class GlobalExceptionHandler {


    // When an EntityNotFoundException is thrown, this method will handle it and
    // return a response to whatever sent the original HTTP request
    // - a ResponseEntity<T> represents a HTTP response message where T is the type of
    //   data in the body
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundHandler(EntityNotFoundException enfe) {
        return new ResponseEntity<>(enfe.getMessage(), HttpStatus.NOT_FOUND);
    }
}
