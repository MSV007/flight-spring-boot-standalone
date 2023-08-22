package com.flight.search.exception;

/**
 * The type Sql exception.
 * @author Manish Kumar
 */
public class SQLException extends RuntimeException{

    /**
     * Instantiates a new Sql exception.
     *
     * @param message the message
     */
public SQLException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Sql exception.
     *
     * @param message the message
     * @param cause the cause
     */
public SQLException(String message, Throwable cause) {
        super(message, cause);
    }
}
