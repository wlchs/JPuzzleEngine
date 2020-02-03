package com.laszloborbely.jsudooku.core.io;

public abstract class AbstractMultiOutput implements ISudokuOutput {
    @Override
    public final boolean many() {
        return true;
    }
}
