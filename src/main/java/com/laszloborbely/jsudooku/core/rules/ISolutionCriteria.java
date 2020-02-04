package com.laszloborbely.jsudooku.core.rules;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

/**
 * Interface of puzzle solution criteria
 */
public interface ISolutionCriteria {
    /**
     * Check solved state of the puzzle
     *
     * @param matrix Input matrix
     * @return True if the matrix is a solution, false otherwise
     */
    boolean isSolved(IMatrix matrix);
}
