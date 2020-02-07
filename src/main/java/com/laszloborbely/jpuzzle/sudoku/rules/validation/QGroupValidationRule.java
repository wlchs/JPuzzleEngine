package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

import java.util.List;

/**
 * Quadratic matrix group validation rule implementation
 */
public class QGroupValidationRule extends QUniqueValidationRule {
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
         * Iterate over each group of the matrix
         */
        for (List<QuadraticMatrixElement> group : m.groups()) {

            /*
             * Check for each row whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(group)) {
                return false;
            }
        }

        return true;
    }
}
