package com.laszloborbely.jsudooku.quadratic.matrix;

import com.laszloborbely.jsudooku.core.matrix.IMatrixIndex;

public final class QuadraticMatrixIndex implements IMatrixIndex {
    private short x;
    private short y;

    public QuadraticMatrixIndex(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public short getX() {
        return this.x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return this.y;
    }

    public void setY(short y) {
        this.y = y;
    }
}
