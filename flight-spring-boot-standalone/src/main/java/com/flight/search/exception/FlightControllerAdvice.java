package com.flight.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FlightControllerAdvice {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(FlightNotFoundException.class)
  public Map<String, String> handleBusinessException(FlightNotFoundException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("timestamp", String.valueOf(LocalDateTime.now()));
    errorMap.put("errorMessage", ex.getMessage());
    errorMap.put("error", HttpStatus.NOT_FOUND.name());
    return errorMap;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(SQLException.class)
  public Map<String, String> handleSQLException(SQLException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("timestamp", String.valueOf(LocalDateTime.now()));
    errorMap.put("errorMessage", ex.getMessage());
    errorMap.put("error", HttpStatus.INTERNAL_SERVER_ERROR.name());
    return errorMap;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(GenericException.class)
  public Map<String, String> handleGenericException(GenericException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("timestamp", String.valueOf(LocalDateTime.now()));
    errorMap.put("errorMessage", ex.getMessage());
    errorMap.put("error", HttpStatus.INTERNAL_SERVER_ERROR.name());
    return errorMap;
  }

}
