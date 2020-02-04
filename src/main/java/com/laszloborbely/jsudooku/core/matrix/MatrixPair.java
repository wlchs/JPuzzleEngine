package com.laszloborbely.jsudooku.core.matrix;

/**
 * Final implementation of a matrix pair
 * Used by the matrix splitter to return two disjoint matrices
 */
public final class MatrixPair {
    /**
     * First matrix object - left leaf node
     */
    private IMatrix first;

    /**
     * Second matrix object - right leaf node
     */
    private IMatrix second;

    /**
     * Constructor containing the two leaf elements
     *
     * @param first  Left leaf node
     * @param second Right leaf node
     */
    public MatrixPair(IMatrix first, IMatrix second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Getter function for the first node
     *
     * @return First (left) matrix
     */
    public IMatrix getFirst() {
        return this.first;
    }

    /**
     * Getter function for the second node
     *
     * @return Second (right) matrix
     */
    public IMatrix getSecond() {
        return this.second;
    }
}
