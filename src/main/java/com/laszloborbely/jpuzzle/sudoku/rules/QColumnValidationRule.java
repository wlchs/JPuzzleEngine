package com.laszloborbely.jpuzzle.sudoku.rules;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * Quadratic matrix column validation rule implementation
 */
public class QColumnValidationRule extends QUniqueValidationRule {
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
         * Iterate over each column of the matrix
         */
        for (List<QuadraticMatrixElement> column : this.columns(m)) {

            /*
             * Check for each column whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(column)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix column values
     *
     * @param m Input quadratic matrix to be separated into columns
     * @return List of column value lists
     */
    private List<List<QuadraticMatrixElement>> columns(QuadraticMatrix m) {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> columns = new ArrayList<>();

        /*
         * Iterate over columns
         */
        for (short c = 0; c < m.dimension(); ++c) {

            /*
             * Initialize current column array
             */
            List<QuadraticMatrixElement> column = new ArrayList<>();

            /*
             * Iterate over rows
             */
            for (short r = 0; r < m.dimension(); ++r) {

                /*
                 * Retrieve matrix element at the matching index
                 */
                QuadraticMatrixElement element = m.getElement(new QuadraticMatrixIndex(r, c));

                /*
                 * Add stored element to column list
                 */
                column.add(element);
            }

            /*
             * Add current column value list to columns array
             */
            columns.add(column);
        }

        return columns;
    }
}
