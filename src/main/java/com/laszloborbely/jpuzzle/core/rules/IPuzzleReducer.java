package com.laszloborbely.jpuzzle.core.rules;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.PuzzlePair;

/**
 * Puzzle reducer interface
 * Defines functions to implement solution search-space reduction
 */
public interface IPuzzleReducer {
    /**
     * Optimizes the puzzle with quick search-space reduction before an expensive split
     *
     * @param puzzle Input puzzle to optimize
     */
    void optimize(IPuzzle puzzle);

    /**
     * Validates current puzzle according to several user-defined rules
     *
     * @param puzzle Input puzzle to validate
     * @return True is valid, false if invalid
     */
    boolean validate(IPuzzle puzzle);

    /**
     * Checks puzzle for solutions
     *
     * @param puzzle Input puzzle to check for solutions
     * @return True if the puzzle is solved, false if not
     */
    boolean solution(IPuzzle puzzle);

    /**
     * Splits puzzle into two sub-puzzles
     * This is necessary to achieve full search-space scan
     *
     * @param puzzle Input puzzle to split according to user-defined rule(s)
     * @return Two resulting puzzles of the split operation
     */
    PuzzlePair split(IPuzzle puzzle);
}
