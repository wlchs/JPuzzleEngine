package com.laszloborbely.jsudooku.core.rules;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;

/**
 * Interface of matrix validation rules
 */
public interface IValidationRule {
    /**
     * Validation check function
     *
     * @param matrix Input puzzle
     * @return True if the matrix is valid, false if not
     */
    boolean isValid(IMatrix matrix);
}
