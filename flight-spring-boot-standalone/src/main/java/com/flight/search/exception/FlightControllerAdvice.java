package com.flight.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.flight.search.exception.ErrorConstant.*;

/** The type Flight controller advice. */
@RestControllerAdvice
public class FlightControllerAdvice {

  /**
   * Handle business exception map.
   *
   * @param ex the ex
   * @return the map
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(FlightNotFoundException.class)
  public Map<String, String> handleBusinessException(FlightNotFoundException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put(TIMESTAMP, String.valueOf(LocalDateTime.now()));
    errorMap.put(ERROR_MESSAGE, ex.getMessage());
    errorMap.put(ERROR, HttpStatus.NOT_FOUND.name());
    return errorMap;
  }

  /**
   * Handle sql exception map.
   *
   * @param ex the ex
   * @return the map
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(SQLException.class)
  public Map<String, String> handleSQLException(SQLException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put(TIMESTAMP, String.valueOf(LocalDateTime.now()));
    errorMap.put(ERROR_MESSAGE, ex.getMessage());
    errorMap.put(ERROR, HttpStatus.INTERNAL_SERVER_ERROR.name());
    return errorMap;
  }

  /**
   * Handle generic exception map.
   *
   * @param ex the ex
   * @return the map
   */
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(GenericException.class)
  public Map<String, String> handleGenericException(GenericException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put(TIMESTAMP, String.valueOf(LocalDateTime.now()));
    errorMap.put(ERROR_MESSAGE, ex.getMessage());
    errorMap.put(ERROR, HttpStatus.UNPROCESSABLE_ENTITY.name());
    return errorMap;
  }
}
