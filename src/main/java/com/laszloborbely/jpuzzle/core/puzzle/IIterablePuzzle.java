package com.laszloborbely.jpuzzle.core.puzzle;

/**
 * Interface of iterable puzzles
 */
public interface IIterablePuzzle extends IPuzzle, Iterable<IPuzzleElement> {
    /**
     * Element getter function
     *
     * @param index Position of the element according to a specific puzzle index
     * @return Contained element at the specific index
     */
    IPuzzleElement getElement(IPuzzleIndex index);
}
