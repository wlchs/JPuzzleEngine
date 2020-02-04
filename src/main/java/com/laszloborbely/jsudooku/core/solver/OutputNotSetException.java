package com.laszloborbely.jsudooku.core.solver;

/**
 * Custom exception type which is thrown if no output handler is set
 */
public class OutputNotSetException extends Exception {
    /**
     * Default constructor defining error message
     */
    public OutputNotSetException() {
        super("Sudoku output not set!");
    }
}
