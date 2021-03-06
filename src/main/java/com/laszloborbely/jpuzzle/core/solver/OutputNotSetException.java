package com.laszloborbely.jpuzzle.core.solver;

/**
 * Custom exception type which is thrown if no output handler is set
 */
public class OutputNotSetException extends Exception {
    /**
     * Default constructor defining error message
     */
    public OutputNotSetException() {
        super("Puzzle output not set!");
    }
}
