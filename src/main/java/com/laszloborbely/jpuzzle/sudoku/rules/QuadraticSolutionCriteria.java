package com.laszloborbely.jpuzzle.sudoku.rules;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleElement;
import com.laszloborbely.jpuzzle.core.rules.ISolutionCriteria;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

/**
 * Quadratic matrix solution criteria implementation
 */
public class QuadraticSolutionCriteria implements ISolutionCriteria {
    /**
     * Solved state checker function
     * Verifies if the matrix fulfills the solving criteria, such as each field contains only a single value
     *
     * @param puzzle Input matrix
     * @return True if each field contains only a single element, false if not
     */
    @Override
    public boolean isSolved(IPuzzle puzzle) {
        QuadraticMatrix matrix = (QuadraticMatrix) puzzle;

        for (IPuzzleElement element : matrix) {
            QuadraticMatrixElement e = (QuadraticMatrixElement) element;

            if (!e.fixed()) {
                return false;
            }
        }

        return true;
    }
}
