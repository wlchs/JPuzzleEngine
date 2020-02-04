package com.laszloborbely.jsudooku.core.matrix;

/**
 * Interface of matrix puzzles
 * Extends the iterable interface to iterate over the contained matrix elements
 */
public interface IMatrix extends Iterable<IMatrixElement> {
    /**
     * Element getter function
     *
     * @param index Position of the element according to a specific matrix index
     * @return Contained element at the specific index
     */
    IMatrixElement getElement(IMatrixIndex index);
}
