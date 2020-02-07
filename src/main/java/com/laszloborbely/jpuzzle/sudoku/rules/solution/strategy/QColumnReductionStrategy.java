package com.laszloborbely.jpuzzle.sudoku.rules.solution.strategy;

import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Reduction strategy for sudoku puzzles
 * Removes potential values from a column if there is already a fixed value existing
 */
public class QColumnReductionStrategy extends QReductionStrategy {
    /**
     * Column reducer method
     * Removes instances of fixed values from each column of the input puzzle
     *
     * @param matrix Input sudoku puzzle
     * @return True if the reduction was successful, false if not
     */
    @Override
    public boolean reduce(QuadraticMatrix matrix) {
        boolean reduced = false;

        /*
         * Iterate over each matrix column
         */
        for (List<QuadraticMatrixElement> column : matrix.columns()) {
            /*
             * Retrieve fixed Short values from column
             */
            List<Short> fixedList =
                    column.stream()
                            .filter(QuadraticMatrixElement::fixed)
                            .map(e -> e.getValues().get(0))
                            .collect(Collectors.toList());

            /*
             * Remove each fixed short value from other elements
             */
            for (Short fixed : fixedList) {
                if (this.removeValueFromList(fixed, column)) {
                    reduced = true;
                }
            }

            /*
             * Attempt to further reduce puzzle solution space by highlighting uniquely appearing elements
             */
            if (this.highlightUniqueElements(column)) {
                reduced = true;
            }
        }

        return reduced;
    }
}
