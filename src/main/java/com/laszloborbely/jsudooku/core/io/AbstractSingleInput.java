package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

public abstract class AbstractSingleInput implements ISudokuInput {
    protected IMatrix inputMatrix;

    @Override
    public final boolean many() {
        return false;
    }

    public final IMatrix getSingleInput() throws MatrixReadException {
        if (inputMatrix == null) {
            this.read();
        }
        return this.inputMatrix;
    }
}
