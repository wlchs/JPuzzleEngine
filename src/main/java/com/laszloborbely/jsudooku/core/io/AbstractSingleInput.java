package com.laszloborbely.jsudooku.core.io;

public abstract class AbstractSingleInput implements ISudokuInput {
    @Override
    public final boolean many() {
        return false;
    }
}
