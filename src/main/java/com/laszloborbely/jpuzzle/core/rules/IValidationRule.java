package com.laszloborbely.jpuzzle.core.rules;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;

/**
 * Interface of puzzle validation rules
 */
public interface IValidationRule {
    /**
     * Validation check function
     *
     * @param puzzle Input puzzle
     * @return True if the puzzle is valid, false if not
     */
    boolean isValid(IPuzzle puzzle);
}
