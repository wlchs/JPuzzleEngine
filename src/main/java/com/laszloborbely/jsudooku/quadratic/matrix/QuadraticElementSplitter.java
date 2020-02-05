package com.laszloborbely.jsudooku.quadratic.matrix;

import com.laszloborbely.jsudooku.core.matrix.MatrixPair;

/**
 * Singleton class for implementing naive splitting of quadratic matrices
 */
public final class QuadraticElementSplitter {
    /**
     * Static splitter function
     * Divides the input matrix into two disjoint sub-matrices making sure the solution-space remains complete
     *
     * @param matrix Input matrix to split
     * @return Pair of disjoint sub-matrices
     */
    public static MatrixPair split(QuadraticMatrix matrix) {
        /*
         * Initialize left leaf node
         */
        QuadraticMatrix m1 = new QuadraticMatrix(matrix);

        /*
         * Initialize right leaf node
         */
        QuadraticMatrix m2 = new QuadraticMatrix(matrix);

        /*
         * Retrieve quadratic matrix dimension
         */
        short dimension = matrix.dimension();

        /*
         * Iterate over quadratic matrix rows
         */
        for (short x = 0; x < dimension; ++x) {

            /*
             * Iterate over quadratic matrix columns
             */
            for (short y = 0; y < dimension; ++y) {

                /*
                 * Create corresponding quadratic matrix index based on row and column values
                 */
                QuadraticMatrixIndex index = new QuadraticMatrixIndex(x, y);

                /*
                 * Retrieve matrix element at the matching position
                 */
                QuadraticMatrixElement element = matrix.getElement(index);

                /*
                 * Check if the matrix element is uniquely fixed
                 */
                if (!element.fixed()) {

                    /*
                     * Fix first element value in the left leaf node
                     */
                    m1.getElement(index).fixFirst();

                    /*
                     * Drop first element value in the right leaf node
                     */
                    m2.getElement(index).dropFirst();

                    /*
                     * Return matrix pair making up the complete solution space
                     */
                    return new MatrixPair(m1, m2);
                }
            }
        }

        /*
         * If there is no splitting point found, return null nodes
         */
        return new MatrixPair(null, null);
    }

    /**
     * Private constructor
     * Needed to prevent object initialization
     */
    private QuadraticElementSplitter() {
    }
}
