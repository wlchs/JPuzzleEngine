package com.laszloborbely.jsudooku.quadratic.io;

/**
 * Exhaustive console output strategy for receiving every single solution of an input puzzle
 */
public class ExhaustiveConsoleOutput extends SingleConsoleOutput {
    /**
     * Request every single possible solution
     *
     * @return True by default
     */
    @Override
    public boolean exhaustive() {
        return true;
    }
}
