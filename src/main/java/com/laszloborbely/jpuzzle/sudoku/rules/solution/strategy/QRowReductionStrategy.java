package com.laszloborbely.jpuzzle.sudoku.rules.solution.strategy;

import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Reduction strategy for sudoku puzzles
 * Removes potential values from a row if there is already a fixed value existing
 */
public class QRowReductionStrategy extends QReductionStrategy {
    /**
     * Row reducer method
     * Removes instances of fixed values from each row of the input puzzle
     *
     * @param matrix Input sudoku puzzle
     * @return True if the reduction was successful, false if not
     */
    @Override
    public boolean reduce(QuadraticMatrix matrix) {
        boolean reduced = false;

        /*
         * Iterate over each matrix row
         */
        for (List<QuadraticMatrixElement> row : matrix.rows()) {
            /*
             * Retrieve fixed Short values from row
             */
            List<Short> fixedList =
                    row.stream()
                            .filter(QuadraticMatrixElement::fixed)
                            .map(e -> e.getValues().get(0))
                            .collect(Collectors.toList());

            /*
             * Remove each fixed short value from other elements
             */
            for (Short fixed : fixedList) {
                if (this.removeValueFromList(fixed, row)) {
                    reduced = true;
                }
            }

            /*
             * Attempt to further reduce puzzle solution space by highlighting uniquely appearing elements
             */
            if (this.highlightUniqueElements(row)) {
                reduced = true;
            }
        }

        return reduced;
    }
}
