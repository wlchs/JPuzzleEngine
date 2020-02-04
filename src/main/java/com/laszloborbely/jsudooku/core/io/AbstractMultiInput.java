package com.laszloborbely.jsudooku.core.io;

/**
 * Abstract class representing handler for multiple input puzzles
 */
public abstract class AbstractMultiInput implements ISudokuInput {
    /**
     * Boolean function indicating that there are multiple input objects available
     *
     * @return Always true
     */
    @Override
    public final boolean many() {
        return true;
    }
}
