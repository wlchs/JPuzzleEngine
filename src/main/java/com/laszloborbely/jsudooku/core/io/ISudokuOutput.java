package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

/**
 * Interface of solution output handlers
 */
public interface ISudokuOutput {
    /**
     * Writer function of the solution matrix
     *
     * @param matrix Solution matrix
     */
    void write(IMatrix matrix);

    /**
     * Writer function for intermediate matrix states
     *
     * @param matrix Intermediate state matrix
     */
    void writeIntermediate(IMatrix matrix);

    /**
     * Boolean function indicating how many solutions are expected
     *
     * @return True if all of the solutions are wanted, false if only one
     */
    boolean exhaustive();
}
