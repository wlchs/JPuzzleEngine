package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.rules.IValidationRule;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass of uniqueness criteria validation for quadratic matrices
 */
public abstract class QUniqueValidationRule implements IValidationRule {
    /**
     * Uniqueness checker function
     * Checks whether the input matrix element list has only unique fixed valies
     *
     * @param list Quadratic matrix element list
     * @return True if each fixed value is unique, false if not
     */
    protected final boolean unique(List<QuadraticMatrixElement> list) {
        ArrayList<QuadraticMatrixElement> uniques = new ArrayList<>();

        for (QuadraticMatrixElement element : list) {
            if (element.fixed()) {
                if (uniques.contains(element)) {
                    return false;
                } else {
                    uniques.add(element);
                }
            }
        }

        return true;
    }
}
