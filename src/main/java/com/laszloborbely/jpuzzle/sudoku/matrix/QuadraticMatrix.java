package com.laszloborbely.jpuzzle.sudoku.matrix;

import com.laszloborbely.jpuzzle.core.puzzle.IIterablePuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleElement;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleIndex;

import java.util.Iterator;

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
