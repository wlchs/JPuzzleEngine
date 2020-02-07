package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleElement;
import com.laszloborbely.jpuzzle.core.rules.IValidationRule;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

/**
 * Validation rule of quadratic matrices for checking whether each field contains at least one value
 */
public class QNonEmptyRule implements IValidationRule {
    /**
     * Validity criteria is fulfilled if each element of the puzzle contains at least a single value
     *
     * @param puzzle Input puzzle
     * @return True if there is no zero element
     */
    @Override
    public boolean isValid(IPuzzle puzzle) {
        QuadraticMatrix matrix = (QuadraticMatrix) puzzle;

        /*
         * Iterate over each matrix element
         */
        for (IPuzzleElement element : matrix) {
            QuadraticMatrixElement e = (QuadraticMatrixElement) element;

            /*
             * If there is at least one field empty, the validation fails
             */
            if (e.degreeOfFreedom() == 0) {
                return false;
            }
        }

        return true;
    }
}
