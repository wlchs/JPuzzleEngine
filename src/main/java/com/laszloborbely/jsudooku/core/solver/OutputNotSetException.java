package com.laszloborbely.jsudooku.core.solver;

public class OutputNotSetException extends Exception {
    public OutputNotSetException() {
        super("Sudoku output not set!");
    }
}
