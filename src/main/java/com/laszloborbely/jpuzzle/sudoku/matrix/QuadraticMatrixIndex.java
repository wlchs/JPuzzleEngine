package com.laszloborbely.jpuzzle.sudoku.matrix;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleIndex;

/**
 * Index element implementation for quadratic matrices
 */
public final class QuadraticMatrixIndex implements IPuzzleIndex {
    /**
     * Member row value
     */
    private short x;

    /**
     * Member column value
     */
    private short y;

    /**
     * Initializing constructor setting the corresponding member values
     *
     * @param x Row value
     * @param y Column value
     */
    public QuadraticMatrixIndex(short x, short y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter function for row coordinate
     *
     * @return Short row value
     */
    public short getX() {
        return this.x;
    }

    /**
     * Getter function for column coordinate
     *
     * @return Short column value
     */
    public short getY() {
        return this.y;
    }
}
