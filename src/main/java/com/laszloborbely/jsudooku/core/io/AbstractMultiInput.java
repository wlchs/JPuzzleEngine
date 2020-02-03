package com.laszloborbely.jsudooku.core.io;

public abstract class AbstractMultiInput implements ISudokuInput {
    @Override
    public final boolean many() {
        return true;
    }
}
