package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

/**
 * Interface of solution output handlers
 */
public interface ISudokuOutput {
    /**
     * Writer function of the solution matrix
     */
    void write(IMatrix matrix);

    /**
     * Boolean function indicating how many solutions are expected
     *
     * @return True if all of the solutions are wanted, false if only one
     */
    boolean exhaustive();
}
