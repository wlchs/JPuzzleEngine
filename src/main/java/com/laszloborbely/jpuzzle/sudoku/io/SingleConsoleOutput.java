package com.laszloborbely.jpuzzle.sudoku.io;

import com.laszloborbely.jpuzzle.core.io.IPuzzleOutput;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixIndex;

/**
 * Output handler implementation for simple console logging
 */
public class SingleConsoleOutput implements IPuzzleOutput {
    /**
     * Output handler write function
     * Prints the output solution matrix to the default console
     *
     * @param puzzle Solution matrix
     */
    @Override
    public void write(IPuzzle puzzle) {
        /*
         * Cast solution matrix to its quadratic implementation to get access to dimension function
         */
        QuadraticMatrix output = (QuadraticMatrix) puzzle;

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
                 * Initialize value field
                 */
                short value;

                /*
                 * Check if the element is fixed
                 */
                if (element.fixed()) {

                    /*
                     * Retrieve first matrix field value
                     */
                    value = element.getValues().get(0);

                } else {

                    /*
                     * If not, replace it with 0
                     */
                    value = 0;
                }

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

        /*
         * Empty line after matrix
         */
        System.out.println();
    }

    /**
     * Writer function for intermediate matrix states
     * Logs the state to the console by substituting 0s for unfixed fields
     *
     * @param puzzle Intermediate state matrix
     */
    @Override
    public void writeIntermediate(IPuzzle puzzle) {
        this.write(puzzle);
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
