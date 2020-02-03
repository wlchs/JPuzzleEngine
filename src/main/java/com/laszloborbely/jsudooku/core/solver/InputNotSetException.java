package com.laszloborbely.jsudooku.core.solver;

public class InputNotSetException extends Exception {
    public InputNotSetException() {
        super("Sudoku input not set!");
    }
}
