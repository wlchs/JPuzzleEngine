package com.laszloborbely.jpuzzle.sudoku.matrix;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Simple integer (short) element list of a quadratic puzzle
 */
public class QuadraticMatrixElement implements IPuzzleElement {

    /**
     * Private short member variable storing possible values
     */
    private List<Short> values;

    /**
     * Empty constructor defining non-fixed matrix values
     */
    public QuadraticMatrixElement(Short dimension) {
        this.values = new ArrayList<>();
        for (short i = 1; i <= dimension; ++i) {
            this.values.add(i);
        }
    }

    /**
     * Constructor for fixed matrix element
     *
     * @param value Member value
     */
    public QuadraticMatrixElement(Short dimension, Short value) throws InvalidElementValueException {
        if (dimension < value || value < 1) {
            throw new InvalidElementValueException();
        }
        this.values = new ArrayList<>();
        this.values.add(value);
    }

    /**
     * Copy constructor
     * Creates a deep clone of matrix values
     *
     * @param that Matrix to copy
     */
    public QuadraticMatrixElement(QuadraticMatrixElement that) {
        this.values = new ArrayList<>();
        this.values.addAll(that.values);
    }

    /**
     * Member value getter function
     *
     * @return Potential values of field
     */
    public List<Short> getValues() {
        return this.values;
    }

    /**
     * Member value setter function
     *
     * @param values Potential values list
     */
    public void setValues(List<Short> values) {
        this.values = values;
    }

    public void setValue(Short value) {
        this.values.clear();
        this.values.add(value);
    }

    /**
     * Check whether the field value is fixed
     *
     * @return True if there is only one possible value in the list, false otherwise
     */
    public boolean fixed() {
        return this.values.size() == 1;
    }

    /**
     * Equation comparator function
     *
     * @param o Other object to compare
     * @return True if the member value arrays are identical
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuadraticMatrixElement)) return false;

        QuadraticMatrixElement that = (QuadraticMatrixElement) o;

        return Objects.equals(values, that.values);
    }

    /**
     * Hash code calculator function required for equation comparison
     *
     * @return Calculated hash value
     */
    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }

    /**
     * Method to drop matrix value elements except for the first one
     */
    public void fixFirst() {
        Short firstElement = this.values.get(0);
        this.values.clear();
        this.values.add(firstElement);
    }

    /**
     * Method to drop first matrix value element and keep the rest
     */
    public void dropFirst() {
        this.values.remove(0);
    }

    /**
     * Method to drop a specific value from the element list
     *
     * @param value Element to drop from list
     */
    public void drop(Short value) {
        this.values.remove(value);
    }

    /**
     * Calculate degree of freedom for the current matrix element
     * Degree of freedom in this case means the total count of potential matrix values in the field
     *
     * @return Size of values array
     */
    public short degreeOfFreedom() {
        return (short) this.values.size();
    }
}
