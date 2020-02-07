package com.laszloborbely.jpuzzle.sudoku.rules.solution.strategy;

import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

import java.util.List;

/**
 * Reduction strategy for quadratic sudoku puzzles
 * Removes a certain values from a list of quadratic matrix elements
 */
public abstract class QReductionStrategy {
    /**
     * Abstract method to reduce sudoku matrix solution-space
     *
     * @param matrix Input sudoku puzzle
     */
    public abstract void reduce(QuadraticMatrix matrix);

    /**
     * Abstract method to remove a certain Short value from each non-fixed
     * element of a list of quadratic matrix elements
     *
     * @param value Short value to remove from each element
     * @param list  List of puzzle elements
     */
    protected final void removeValueFromList(Short value, List<QuadraticMatrixElement> list) {
        for (QuadraticMatrixElement element : list) {
            if (!element.fixed()) {
                element.drop(value);
            }
        }
    }
}
