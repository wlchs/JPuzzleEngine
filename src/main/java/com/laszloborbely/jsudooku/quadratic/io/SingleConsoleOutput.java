package com.laszloborbely.jsudooku.quadratic.io;

import com.laszloborbely.jsudooku.core.io.ISudokuOutput;
import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrix;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrixElement;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrixIndex;

/**
 * Output handler implementation for simple console logging
 */
public class SingleConsoleOutput implements ISudokuOutput {
    /**
     * Output handler write function
     * Prints the output solution matrix to the default console
     *
     * @param matrix Solution matrix
     */
    @Override
    public void write(IMatrix matrix) {
        /*
         * Cast solution matrix to its quadratic implementation to get access to dimension function
         */
        QuadraticMatrix output = (QuadraticMatrix) matrix;

        /*
         * Get quadratic matrix dimension (height = width)
         */
        short dimension = output.dimension();

        /*
         * Iterate over matrix coordinates
         */
        for (short x = 0; x < dimension; ++x) {
            for (short y = 0; y < dimension; ++y) {
                /*
                 * Create matrix index from row and column coordinates
                 */
                QuadraticMatrixIndex index = new QuadraticMatrixIndex(x, y);

                /*
                 * Get matrix element at the matching index
                 */
                QuadraticMatrixElement element = output.getElement(index);

                /*
                 * Retrieve first matrix field value
                 */
                short value = element.getValues().get(0);

                /*
                 * Print next value inline
                 */
                System.out.print(value);
            }

            /*
             * Line break after each row
             */
            System.out.println();
        }
    }

    /**
     * Exhaustive solution flag
     *
     * @return False by default
     */
    @Override
    public boolean exhaustive() {
        return false;
    }
}
