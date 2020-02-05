package com.laszloborbely.jpuzzle.sudoku.io;

import com.laszloborbely.jpuzzle.core.io.IPuzzleInput;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleReducer;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixIndex;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixReducer;

/**
 * Input handler implementation
 * Parses a simple 2D array of short values to an input matrix
 */
public class SingleQuadraticInput implements IPuzzleInput {
    /**
     * Member variable for input matrix
     * Always populated in the constructor
     */
    private QuadraticMatrix inputMatrix;

    /**
     * Initializing constructor
     *
     * @param matrix Raw 2D array containing input matrix values
     */
    public SingleQuadraticInput(Short[][] matrix) {
        /*
         * Initialize matrix object
         */
        inputMatrix = new QuadraticMatrix((short) matrix.length);

        /*
         * Iterate over row coordinates
         */
        for (short x = 0; x < matrix.length; ++x) {

            /*
             * Retrieve matching matrix row from 2D array
             */
            Short[] row = matrix[x];

            /*
             * Iterate over column coordinates
             */
            for (short y = 0; y < row.length; ++y) {

                /*
                 * Retrieve matching element value
                 */
                Short value = row[y];

                /*
                 * If the init value is 0, it is not fixed
                 * If not, add it to the matrix object as a fix element
                 */
                if (value != 0) {
                    /*
                     * Create matrix index object based on row and column coordinates
                     */
                    QuadraticMatrixIndex index = new QuadraticMatrixIndex(x, y);

                    /*
                     * Retrieve matrix element at the corresponding coordinates
                     */
                    QuadraticMatrixElement element = inputMatrix.getElement(index);

                    /*
                     * Fix element value
                     */
                    element.setValue(value);
                }
            }
        }
    }

    /**
     * Matrix input read function
     * Returns the internally stored puzzle
     *
     * @return Parsed input puzzle
     */
    @Override
    public QuadraticMatrix read() {
        return this.inputMatrix;
    }

    /**
     * Input streaming flag
     *
     * @return Set to false by default
     */
    @Override
    public boolean streamed() {
        return false;
    }

    /**
     * Function for retrieving solution-space reducer object
     *
     * @return Default quadratic matrix reducer object
     */
    @Override
    public IPuzzleReducer getReducer() {
        return new QuadraticMatrixReducer();
    }
}
