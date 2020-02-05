package com.laszloborbely.jpuzzle.core.puzzle;

/**
 * Final implementation of a puzzle pair
 * Used by the matrix splitter to return two disjoint puzzles
 */
public final class PuzzlePair {
    /**
     * First puzzle object - left leaf node
     */
    private IPuzzle first;

    /**
     * Second puzzle object - right leaf node
     */
    private IPuzzle second;

    /**
     * Constructor containing the two leaf elements
     *
     * @param first  Left leaf node
     * @param second Right leaf node
     */
    public PuzzlePair(IPuzzle first, IPuzzle second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Getter function for the first node
     *
     * @return First (left) puzzle
     */
    public IPuzzle getFirst() {
        return this.first;
    }

    /**
     * Getter function for the second node
     *
     * @return Second (right) puzzle
     */
    public IPuzzle getSecond() {
        return this.second;
    }
}
