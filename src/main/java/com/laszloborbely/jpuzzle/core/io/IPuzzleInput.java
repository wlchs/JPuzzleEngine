package com.laszloborbely.jpuzzle.core.io;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.rules.IPuzzleReducer;

/**
 * Interface of input puzzles with the corresponding solution-space reducer
 */
public interface IPuzzleInput {
    /**
     * Reader function which retrieves a valid puzzle
     *
     * @return A valid input puzzle
     */
    IPuzzle read();

    /**
     * Function indicating whether there is only a single input puzzle or multiple ones
     *
     * @return True if more, false is single
     */
    boolean streamed();

    /**
     * Retrieves solution-space reducer strategy
     *
     * @return Corresponding reduction strategy
     */
    IPuzzleReducer getReducer();
}
