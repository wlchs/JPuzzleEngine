package com.laszloborbely.jpuzzle.core.io;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;

/**
 * Interface of solution output handlers
 */
public interface IPuzzleOutput {
    /**
     * Writer function of the solutions
     *
     * @param puzzle Solution
     */
    void write(IPuzzle puzzle);

    /**
     * Writer function for intermediate puzzle states
     *
     * @param puzzle Intermediate puzzle state
     */
    void writeIntermediate(IPuzzle puzzle);

    /**
     * Boolean function indicating how many solutions are expected
     *
     * @return True if all of the solutions are wanted, false if only one
     */
    boolean exhaustive();
}
