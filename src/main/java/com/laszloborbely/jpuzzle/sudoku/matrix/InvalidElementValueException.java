package com.laszloborbely.jpuzzle.sudoku.matrix;

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
