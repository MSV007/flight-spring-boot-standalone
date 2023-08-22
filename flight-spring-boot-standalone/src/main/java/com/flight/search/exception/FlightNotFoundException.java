package com.flight.search.exception;


/**
 * The type Flight not found exception.
 * @author Manish Kumar
 */
public class FlightNotFoundException extends RuntimeException{

  /**
   * Instantiates a new Flight not found exception.
   *
   * @param message the message
   */
  public FlightNotFoundException(String message) {
        super(message);
    }

}