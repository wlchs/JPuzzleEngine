package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

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
        for (List<QuadraticMatrixElement> row : m.rows()) {
            /*
             * Check for each row whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(row)) {
                return false;
            }
        }

        return true;
    }
}
