package com.laszloborbely.jpuzzle.core.puzzle;

/**
 * Interface of puzzles
 * Extends the iterable interface to iterate over the contained puzzle elements
 */
public interface IPuzzle extends Iterable<IPuzzleElement> {
    /**
     * Element getter function
     *
     * @param index Position of the element according to a specific puzzle index
     * @return Contained element at the specific index
     */
    IPuzzleElement getElement(IPuzzleIndex index);
}
