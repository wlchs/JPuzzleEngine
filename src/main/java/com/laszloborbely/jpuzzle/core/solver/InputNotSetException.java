package com.laszloborbely.jpuzzle.core.solver;

/**
 * Custom exception type which is thrown if no input handler is set
 */
public class InputNotSetException extends Exception {
    /**
     * Default constructor defining error message
     */
    public InputNotSetException() {
        super("Puzzle input not set!");
    }
}
