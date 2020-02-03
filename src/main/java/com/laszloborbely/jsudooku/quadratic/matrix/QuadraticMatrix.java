package com.laszloborbely.jsudooku.quadratic.matrix;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.core.matrix.IMatrixIndex;

public final class QuadraticMatrix implements IMatrix {
    private QuadraticMatrixElement[][] matrix = new QuadraticMatrixElement[9][9];

    @Override
    public QuadraticMatrixElement getElement(IMatrixIndex index) {
        QuadraticMatrixIndex i = (QuadraticMatrixIndex) index;

        return matrix[i.getX()][i.getY()];
    }
}
