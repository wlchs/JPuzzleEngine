package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

/**
 * Abstract class representing handler for single output object
 */
public abstract class AbstractSingleOutput implements ISudokuOutput {
    /**
     * Internal matrix object storing single solution
     */
    protected IMatrix outputMatrix;

    /**
     * Boolean function indicating that there are no multiple output objects available
     *
     * @return Always false
     */
    @Override
    public final boolean many() {
        return false;
    }

    /**
     * Setter function of the output element
     *
     * @param output Solution of the puzzle
     */
    public final void setSingleOutput(IMatrix output) {
        this.outputMatrix = output;
    }
}
