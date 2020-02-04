package com.laszloborbely.jsudooku.core.io;

/**
 * Abstract class representing handler for single input puzzle
 */
public abstract class AbstractSingleInput implements ISudokuInput {
    /**
     * Boolean function indicating that there are no multiple input objects available
     *
     * @return Always false
     */
    @Override
    public final boolean many() {
        return false;
    }
}
