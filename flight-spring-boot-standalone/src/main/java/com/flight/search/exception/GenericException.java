package com.flight.search.exception;


/**
 * The type Generic exception.
 * @author Manish Kumar
 */
public class GenericException extends RuntimeException{

    /**
     * Instantiates a new Generic exception.
     *
     * @param message the message
     */
public GenericException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Generic exception.
     *
     * @param message the message
     * @param cause the cause
     */
public GenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
