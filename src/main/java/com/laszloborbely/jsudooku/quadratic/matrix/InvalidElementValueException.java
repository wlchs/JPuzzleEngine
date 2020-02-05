package com.laszloborbely.jsudooku.quadratic.matrix;

/**
 * Custom exception type for invalid matrix value initialization
 */
public class InvalidElementValueException extends Exception {
    /**
     * Default constructor
     * Sets exception error message
     */
    public InvalidElementValueException() {
        super("Matrix element value out of bounds!");
    }
}
