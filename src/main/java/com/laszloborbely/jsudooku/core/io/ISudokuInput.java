package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.core.matrix.IMatrixReducer;

/**
 * Interface of input puzzles with the corresponding solution-space reducer
 */
public interface ISudokuInput {
    /**
     * Reader function which retrieves a valid puzzle matrix
     *
     * @return A valid input matrix
     */
    IMatrix read();

    /**
     * Function indicating whether there is only a single input puzzle or multiple ones
     *
     * @return True if more, false is single
     */
    boolean many();

    /**
     * Retrieves solution-space reducer strategy
     *
     * @return Corresponding reduction strategy
     */
    IMatrixReducer getReducer();
}
