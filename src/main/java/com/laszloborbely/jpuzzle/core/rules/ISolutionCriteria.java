package com.laszloborbely.jpuzzle.core.rules;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;

/**
 * Interface of puzzle solution criteria
 */
public interface ISolutionCriteria {
    /**
     * Check solved state of the puzzle
     *
     * @param puzzle Input puzzle
     * @return True if the puzzle is a solution, false otherwise
     */
    boolean isSolved(IPuzzle puzzle);
}
