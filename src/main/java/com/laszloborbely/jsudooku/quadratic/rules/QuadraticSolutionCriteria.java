package com.laszloborbely.jsudooku.quadratic.rules;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.core.matrix.IMatrixElement;
import com.laszloborbely.jsudooku.core.rules.ISolutionCriteria;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrixElement;

/**
 * Quadratic matrix solution criteria implementation
 */
public class QuadraticSolutionCriteria implements ISolutionCriteria {
    /**
     * Solved state checker function
     * Verifies if the matrix fulfills the solving criteria, such as each field contains only a single value
     *
     * @param matrix Input matrix
     * @return True if each field contains only a single element, false if not
     */
    @Override
    public boolean isSolved(IMatrix matrix) {
        for (IMatrixElement element : matrix) {
            QuadraticMatrixElement e = (QuadraticMatrixElement) element;

            if (!e.fixed()) {
                return false;
            }
        }

        return true;
    }
}
