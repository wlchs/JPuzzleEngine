package com.laszloborbely.jsudooku.core.io;

public abstract class AbstractSingleOutput implements ISudokuOutput {
    @Override
    public final boolean many() {
        return false;
    }
}
