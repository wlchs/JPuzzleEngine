package com.laszloborbely.jsudooku.core.io;

import com.laszloborbely.jsudooku.core.matrix.IMatrixReducer;

public interface ISudokuInput {
    void read();
    boolean many();
    IMatrixReducer getReducer();
}
