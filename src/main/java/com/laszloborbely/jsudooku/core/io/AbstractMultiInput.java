package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

public abstract class AbstractMultiInput implements ISudokuInput {
    protected IMatrix inputMatrix;

    @Override
    public final boolean many() {
        return true;
    }

    public final IMatrix getNextInput() throws MatrixReadException {
        if (inputMatrix == null) {
            this.read();
        }

        IMatrix next = this.inputMatrix;
        this.inputMatrix = null;
        return next;
    }
}
