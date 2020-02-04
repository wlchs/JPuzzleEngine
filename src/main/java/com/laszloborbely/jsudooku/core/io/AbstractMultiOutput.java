package com.laszloborbely.jsudooku.core.io;

/**
 * Abstract class representing handler for multiple output puzzles
 */
public abstract class AbstractMultiOutput implements ISudokuOutput {
    /**
     * Boolean function indicating that there are multiple output objects available
     *
     * @return Always true
     */
    @Override
    public final boolean many() {
        return true;
    }
}
