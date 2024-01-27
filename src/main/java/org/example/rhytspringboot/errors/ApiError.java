package org.example.rhytspringboot.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
public class ApiError {
  private final String message;
  private final int statusCode;

  @JsonInclude(NON_NULL)
  private final Collection<ValidationError> errors;

  public ApiError(HttpStatusCode statusCode, Collection<ValidationError> errors) {
    this.message = "Check the 'errors' property for more details.";
    this.statusCode = statusCode.value();
    this.errors = errors;
  }

  public ApiError(String message, int statusCode, Collection<ValidationError> errors) {
    this.message = message;
    this.statusCode = statusCode;
    this.errors = errors;
  }

  public ApiError(String message, HttpStatusCode statusCode) {
    this.message = message;
    this.statusCode = statusCode.value();
    this.errors = null;
  }
}
