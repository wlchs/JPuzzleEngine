package com.laszloborbely.jpuzzle.sudoku.matrix;

import com.laszloborbely.jpuzzle.core.puzzle.IIterablePuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleElement;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleIndex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Quadratic matrix puzzle implementation
 * Contains a 2D array of matrix elements
 */
public final class QuadraticMatrix implements IIterablePuzzle {
    /**
     * Actual array containing field values
     */
    private QuadraticMatrixElement[][] matrix;

    /**
     * Dimension initializer constructor
     * Populates the 2D array with the matching field values
     *
     * @param dimension Matrix dimension (width = height)
     */
    public QuadraticMatrix(short dimension) {
        /*
         * Initialize field array
         */
        this.matrix = new QuadraticMatrixElement[dimension][dimension];

        /*
         * Iterate over rows
         */
        for (short x = 0; x < dimension; ++x) {

            /*
             * Iterate over columns
             */
            for (short y = 0; y < dimension; ++y) {

                /*
                 * Initialize corresponding matrix element
                 */
                this.matrix[x][y] = new QuadraticMatrixElement(dimension);
            }
        }
    }

    /**
     * Initializing constructor
     * Copies the input matrix and saves it as the member array
     *
     * @param matrix Input matrix fields
     */
    public QuadraticMatrix(QuadraticMatrixElement[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Copy constructor
     * Creates a deep clone of the field value matrix
     *
     * @param that Copied matrix
     */
    public QuadraticMatrix(QuadraticMatrix that) {
        /*
         * Retrieve copied matrix dimension
         */
        short dimension = that.dimension();

        /*
         * Initialize member matrix based on copied matrix dimension
         */
        this.matrix = new QuadraticMatrixElement[dimension][dimension];

        /*
         * Iterate over rows
         */
        for (short x = 0; x < dimension; ++x) {

            /*
             * Iterate over columns
             */
            for (short y = 0; y < dimension; ++y) {

                /*
                 * Create deep copy of target matrix element
                 */
                this.matrix[x][y] = new QuadraticMatrixElement(that.matrix[x][y]);
            }
        }
    }

    /**
     * Quadratic matrix element getter function
     * In this particular case, index should be of type QuadraticMatrixIndex
     *
     * @param index Position of the element according to a specific matrix index
     * @return Quadratic matrix element at the corresponding position
     */
    @Override
    public QuadraticMatrixElement getElement(IPuzzleIndex index) {
        /*
         * Create matrix index of the correct type
         */
        QuadraticMatrixIndex i = (QuadraticMatrixIndex) index;

        /*
         * Parse matrix index coordinates
         */
        return matrix[i.getX()][i.getY()];
    }

    /**
     * Iterator getter function for member matrix elements
     *
     * @return Iterator of matrix elements
     */
    @Override
    public Iterator<IPuzzleElement> iterator() {
        return new QuadraticMatrixIterator();
    }

    /**
     * Matrix dimension getter function
     *
     * @return Short value of matrix width / height
     */
    public short dimension() {
        return (short) matrix.length;
    }

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix row values
     *
     * @return List of row value lists
     */
    public List<List<QuadraticMatrixElement>> rows() {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> rows = new ArrayList<>();

        /*
         * Iterate over rows
         */
        for (short r = 0; r < this.dimension(); ++r) {

            /*
             * Initialize current row array
             */
            List<QuadraticMatrixElement> row = new ArrayList<>();

            /*
             * Iterate over columns
             */
            for (short c = 0; c < this.dimension(); ++c) {

                /*
                 * Retrieve matrix element at the matching index
                 */
                QuadraticMatrixElement element = this.getElement(new QuadraticMatrixIndex(r, c));

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

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix column values
     *
     * @return List of column value lists
     */
    public List<List<QuadraticMatrixElement>> columns() {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> columns = new ArrayList<>();

        /*
         * Iterate over columns
         */
        for (short c = 0; c < this.dimension(); ++c) {

            /*
             * Initialize current column array
             */
            List<QuadraticMatrixElement> column = new ArrayList<>();

            /*
             * Iterate over rows
             */
            for (short r = 0; r < this.dimension(); ++r) {

                /*
                 * Retrieve matrix element at the matching index
                 */
                QuadraticMatrixElement element = this.getElement(new QuadraticMatrixIndex(r, c));

                /*
                 * Add stored element to column list
                 */
                column.add(element);
            }

            /*
             * Add current column value list to columns array
             */
            columns.add(column);
        }

        return columns;
    }

    /**
     * Reformat matrix structure by returning a list of lists of quadratic matrix group values
     *
     * @return List of group value lists
     */
    public List<List<QuadraticMatrixElement>> groups() {
        /*
         * Initialize return array
         */
        List<List<QuadraticMatrixElement>> groups = new ArrayList<>();

        /*
         * Calculate quadratic matrix group size
         */
        short groupDimension = (short) Math.round(Math.sqrt(this.dimension()));

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
                        QuadraticMatrixElement element = this.getElement(index);

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

    /**
     * Internal iterator class for quadratic matrices
     */
    class QuadraticMatrixIterator implements Iterator<IPuzzleElement> {
        /*
         * Row coordinate counter
         */
        short x;

        /*
         * Column coordinate counter
         */
        short y;

        /**
         * Default constructor initializing member values with 0; 0
         */
        QuadraticMatrixIterator() {
            this.x = 0;
            this.y = 0;
        }

        /**
         * Boolean function for checking whether the matrix has any more elements to iterate over
         *
         * @return False if the bottom right corner is reached, True otherwise
         */
        @Override
        public boolean hasNext() {
            return !(x == dimension() - 1 && y == dimension() - 1);
        }

        /**
         * Iterator next function
         *
         * @return The next element of the matrix if available, otherwise null
         */
        @Override
        public IPuzzleElement next() {
            if (!hasNext()) {
                return null;
            }

            if (y == dimension() - 1) {
                ++x;
                y = 0;
            } else {
                ++y;
            }

            return getElement(new QuadraticMatrixIndex(x, y));
        }
    }
}
