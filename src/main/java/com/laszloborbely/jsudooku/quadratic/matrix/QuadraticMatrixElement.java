package com.laszloborbely.jsudooku.quadratic.matrix;

import com.laszloborbely.jsudooku.core.matrix.IMatrixElement;

/**
 * Simple integer (short) element of a quadratic puzzle
 */
public class QuadraticMatrixElement implements IMatrixElement {

    /**
     * Private short member variable storing actual value
     */
    private Short value;

    /**
     * Empty constructor defining non-fixed matrix values
     */
    QuadraticMatrixElement() {

    }

    /**
     * Constructor for fixed matrix element
     * @param value Member value
     */
    QuadraticMatrixElement(Short value) {
        this.value = value;
    }

    /**
     * Member value getter function
     * @return Short member value of field
     */
    public Short getValue() {
        return this.value;
    }

    /**
     * Member value setter function
     * @param value Short value
     */
    public void setValue(Short value) {
        this.value = value;
    }
}
