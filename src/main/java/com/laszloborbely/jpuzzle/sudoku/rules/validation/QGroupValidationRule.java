package com.laszloborbely.jpuzzle.sudoku.rules.validation;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrix;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixElement;
import com.laszloborbely.jpuzzle.sudoku.matrix.QuadraticMatrixIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * Quadratic matrix group validation rule implementation
 */
public class QGroupValidationRule extends QUniqueValidationRule {
    /**
     * Validity checker function
     *
     * @param puzzle Input puzzle
     * @return True if the validity criteria is fulfilled, false if not
     */
    @Override
    public boolean isValid(IPuzzle puzzle) {
        QuadraticMatrix m = (QuadraticMatrix) puzzle;

        /*
         * Iterate over each group of the matrix
         */
        for (List<QuadraticMatrixElement> group : this.groups(m)) {

            /*
             * Check for each row whether the uniqueness criteria is fulfilled
             */
            if (!this.unique(group)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix group values
     *
     * @param m Input quadratic matrix to be separated into groups
     * @return List of group value lists
     */
    private List<List<QuadraticMatrixElement>> groups(QuadraticMatrix m) {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> groups = new ArrayList<>();

        /*
         * Calculate quadratic matrix group size
         */
        short groupDimension = (short) Math.round(Math.sqrt(m.dimension()));

        /*
         * Iterate over each group
         */
        for (short horizontalGroups = 0; horizontalGroups < groupDimension; ++horizontalGroups) {
            for (short verticalGroups = 0; verticalGroups < groupDimension; ++verticalGroups) {
                /*
                 * Initialize current group element list
                 */
                List<QuadraticMatrixElement> group = new ArrayList<>();

                /*
                 * Get each element in the corresponding group
                 */
                for (short x = 0; x < groupDimension; ++x) {
                    for (short y = 0; y < groupDimension; ++y) {
                        QuadraticMatrixIndex index = new QuadraticMatrixIndex(
                                (short) (horizontalGroups * groupDimension + x),
                                (short) (verticalGroups * groupDimension + y)
                        );
                        QuadraticMatrixElement element = m.getElement(index);

                        /*
                         * Add group element to current group element list
                         */
                        group.add(element);
                    }
                }

                /*
                 * Add current group elements to global group list
                 */
                groups.add(group);
            }
        }

        return groups;
    }
}
