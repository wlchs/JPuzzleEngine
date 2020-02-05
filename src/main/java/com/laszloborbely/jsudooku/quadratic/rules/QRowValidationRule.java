package com.laszloborbely.jsudooku.quadratic.rules;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrix;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrixElement;
import com.laszloborbely.jsudooku.quadratic.matrix.QuadraticMatrixIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * Quadratic matrix row validation rule implementation
 */
public class QRowValidationRule extends QUniqueValidationRule {
    /**
     * Validity checker function
     *
     * @param matrix Input puzzle
     * @return True if the validity criteria is fulfilled, false if not
     */
    @Override
    public boolean isValid(IMatrix matrix) {
        QuadraticMatrix m = (QuadraticMatrix) matrix;

        /*
         * Iterate over each row of the matrix
         */
        for (List<QuadraticMatrixElement> row : this.rows(m)) {
            /*
             * Check for each row whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(row)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix row values
     *
     * @param m Input quadratic matrix to be separated into rows
     * @return List of row value lists
     */
    private List<List<QuadraticMatrixElement>> rows(QuadraticMatrix m) {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> rows = new ArrayList<>();

        /*
         * Iterate over rows
         */
        for (short r = 0; r < m.dimension(); ++r) {

            /*
             * Initialize current row array
             */
            List<QuadraticMatrixElement> row = new ArrayList<>();

            /*
             * Iterate over columns
             */
            for (short c = 0; c < m.dimension(); ++c) {

                /*
                 * Retrieve matrix element at the matching index
                 */
                QuadraticMatrixElement element = m.getElement(new QuadraticMatrixIndex(r, c));

                /*
                 * Add stored element to row list
                 */
                row.add(element);
            }

            /*
             * Add current row value list to rows array
             */
            rows.add(row);
        }

        return rows;
    }
}
