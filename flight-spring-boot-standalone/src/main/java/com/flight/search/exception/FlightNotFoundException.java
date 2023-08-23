package com.flight.search.exception;

/**
 * The type Flight not found exception.
 *
 * @author Manish Kumar
 */
public class FlightNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Flight not found exception.
   *
   * @param message the message
   */
  public FlightNotFoundException(String message) {
    super(message);
  }

  /**
   * Instantiates a new Flight not found exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public FlightNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
