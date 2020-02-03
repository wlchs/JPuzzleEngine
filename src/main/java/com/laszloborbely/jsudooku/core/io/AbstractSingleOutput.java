package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

public abstract class AbstractSingleOutput implements ISudokuOutput {
    protected IMatrix outputMatrix;

    @Override
    public final boolean many() {
        return false;
    }

    public final void setSingleOutput(IMatrix output) {
        this.outputMatrix = output;
    }
}
