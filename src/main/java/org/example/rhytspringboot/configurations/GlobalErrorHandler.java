package org.example.rhytspringboot.configurations;

import org.example.rhytspringboot.errors.ApiError;
import org.example.rhytspringboot.errors.ValidationError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestControllerAdvice
public class GlobalErrorHandler {

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ApiError> status(ResponseStatusException exception) {
    return ResponseEntity.status(exception.getStatusCode())
        .body(new ApiError(exception.getReason(), exception.getStatusCode()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> validation(MethodArgumentNotValidException exception) {
    return ResponseEntity.status(BAD_REQUEST)
        .body(new ApiError(BAD_REQUEST, ValidationError.of(exception)));
  }
}
