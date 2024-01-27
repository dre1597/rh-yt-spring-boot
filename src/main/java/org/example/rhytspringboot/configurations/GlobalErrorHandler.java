package org.example.rhytspringboot.configurations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;


@RestControllerAdvice
public class GlobalErrorHandler {
  @ExceptionHandler(ResponseStatusException.class)

  public ResponseEntity<Map<String, ?>> status(ResponseStatusException e) {
    return ResponseEntity.status(e.getStatusCode())
        .body(Map.of(
            "status", e.getStatusCode().value(),
            "message", Optional.ofNullable(e.getReason()).orElse("Unknown error")
        ));
  }
}
