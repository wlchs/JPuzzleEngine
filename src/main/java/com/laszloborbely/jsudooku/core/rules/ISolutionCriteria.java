package com.laszloborbely.jsudooku.core.rules;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

public interface ISolutionCriteria {
    boolean isSolved(IMatrix matrix);
}