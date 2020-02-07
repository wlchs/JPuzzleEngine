package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * Quadratic matrix row validation rule implementation
 */
public class QRowValidationRule extends QUniqueValidationRule {
    /**
     * Validity checker function
     *
     * @param puzzle Input puzzle
     * @return True if the validity criteria is fulfilled, false if not
     */
    @Override
    public boolean isValid(IPuzzle puzzle) {
        QuadraticMatrix m = (QuadraticMatrix) puzzle;

        /*
         * Iterate over each row of the matrix
         */
        for (List<QuadraticMatrixElement> row : this.rows(m)) {
            /*
             * Check for each row whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(row)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix row values
     *
     * @param m Input quadratic matrix to be separated into rows
     * @return List of row value lists
     */
    private List<List<QuadraticMatrixElement>> rows(QuadraticMatrix m) {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> rows = new ArrayList<>();

        /*
         * Iterate over rows
         */
        for (short r = 0; r < m.dimension(); ++r) {

            /*
             * Initialize current row array
             */
            List<QuadraticMatrixElement> row = new ArrayList<>();

            /*
             * Iterate over columns
             */
            for (short c = 0; c < m.dimension(); ++c) {

                /*
                 * Retrieve matrix element at the matching index
                 */
                QuadraticMatrixElement element = m.getElement(new QuadraticMatrixIndex(r, c));

                /*
                 * Add stored element to row list
                 */
                row.add(element);
            }

            /*
             * Add current row value list to rows array
             */
            rows.add(row);
        }

        return rows;
    }
}
