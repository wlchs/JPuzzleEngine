package com.laszloborbely.jsudooku.core.matrix;

public final class MatrixPair {
    private IMatrix first;
    private IMatrix second;

    public MatrixPair(IMatrix first, IMatrix second) {
        this.first = first;
        this.second = second;
    }

    public IMatrix getFirst() {
        return this.first;
    }

    public void setFirst(IMatrix first) {
        this.first = first;
    }

    public IMatrix getSecond() {
        return this.second;
    }

    public void setSecond(IMatrix second) {
        this.second = second;
    }
}
