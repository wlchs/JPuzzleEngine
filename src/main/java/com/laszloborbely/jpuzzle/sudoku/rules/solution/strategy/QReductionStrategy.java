package com.laszloborbely.jpuzzle.sudoku.rules.solution.strategy;

import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Reduction strategy for quadratic sudoku puzzles
 * Removes a certain values from a list of quadratic matrix elements
 */
public abstract class QReductionStrategy {
    /**
     * Abstract method to reduce sudoku matrix solution-space
     *
     * @param matrix Input sudoku puzzle
     * @return True if the reduction was successful, false otherwise
     */
    public abstract boolean reduce(QuadraticMatrix matrix);

    /**
     * Abstract method to remove a certain Short value from each non-fixed
     * element of a list of quadratic matrix elements
     *
     * @param value Short value to remove from each element
     * @param list  List of puzzle elements
     * @return True if at least one element was removed from the list
     */
    protected final boolean removeValueFromList(Short value, List<QuadraticMatrixElement> list) {
        boolean reduced = false;
        for (QuadraticMatrixElement element : list) {
            if (!element.fixed()) {
                if (element.drop(value)) {
                    reduced = true;
                }
            }
        }

        return reduced;
    }

    /**
     * Abstract method to highlight uniquely appearing values in a list by removing every other value
     * from the corresponding quadratic matrix element
     *
     * @param list List of puzzle elements
     * @return True if at least one element could be highlighted, false otherwise
     */
    protected final boolean highlightUniqueElements(List<QuadraticMatrixElement> list) {
        boolean reduced = false;
        Map<Short, List<QuadraticMatrixElement>> valueMap = new HashMap<>();

        /*
         * Construct list value-element map
         */
        for (QuadraticMatrixElement element : list) {
            for (Short value : element.getValues()) {
                List<QuadraticMatrixElement> valueList = valueMap.getOrDefault(value, new ArrayList<>());
                valueList.add(element);
                valueMap.put(value, valueList);
            }
        }

        /*
         * Filter unique values
         */
        List<Map.Entry<Short, List<QuadraticMatrixElement>>> uniqueValues =
                valueMap.entrySet()
                        .stream()
                        .filter(e -> e.getValue().size() == 1)
                        .collect(Collectors.toList());

        /*
         * Drop unwanted values from matrix element list
         */
        for (Map.Entry<Short, List<QuadraticMatrixElement>> entry : uniqueValues) {
            Short value = entry.getKey();
            QuadraticMatrixElement element = entry.getValue().get(0);

            if (!element.fixed()) {
                element.setValue(value);
                reduced = true;
            }
        }

        return reduced;
    }
}
