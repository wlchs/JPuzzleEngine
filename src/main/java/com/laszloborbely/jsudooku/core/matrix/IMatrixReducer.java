package com.laszloborbely.jsudooku.core.matrix;

/**
 * Matrix reducer interface
 * Defines functions to implement solution search-space reduction
 */
public interface IMatrixReducer {

    /**
     * Validates current matrix according to several user-defined rules
     *
     * @param matrix Input matrix to validate
     * @return True is valid, false if invalid
     */
    boolean validate(IMatrix matrix);

    /**
     * Checks matrix for solutions
     *
     * @param matrix Input matrix to check for solutions
     * @return True if the matrix is solved, false if not
     */
    boolean solve(IMatrix matrix);

    /**
     * Splits matrix into two sub-matrices
     * This is necessary to achieve full search-space scan
     *
     * @param matrix Input matrix to split according to user-defined rule(s)
     * @return Two resulting matrices of the split operation
     */
    MatrixPair split(IMatrix matrix);
}
