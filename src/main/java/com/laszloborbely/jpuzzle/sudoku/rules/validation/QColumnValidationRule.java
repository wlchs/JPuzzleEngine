package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

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
        for (List<QuadraticMatrixElement> column : m.columns()) {

            /*
             * Check for each column whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(column)) {
                return false;
            }
        }

        return true;
    }
}
