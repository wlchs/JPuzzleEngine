package com.laszloborbely.jsudooku.core.solver;

import com.laszloborbely.jsudooku.core.io.ISudokuInput;
import com.laszloborbely.jsudooku.core.io.ISudokuOutput;

/**
 * Abstract class for puzzle solvers
 * Stores necessary input and output object as well as defines default getter and setter functions
 */
public abstract class AbstractSolver {
    /**
     * Input puzzle object containing one or more puzzles and the corresponding reducer
     */
    protected ISudokuInput input;

    /**
     * Output puzzle handler defining solution strategy and output location
     */
    protected ISudokuOutput output;

    /**
     * Default constructor
     */
    public AbstractSolver() {

    }

    /**
     * Constructor initializing input and output objects
     *
     * @param input  Input handler
     * @param output Output handler
     */
    public AbstractSolver(ISudokuInput input, ISudokuOutput output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Input handler setter function
     *
     * @param input Input handler
     */
    public void setInput(ISudokuInput input) {
        this.input = input;
    }

    /**
     * Input handler getter function
     *
     * @return Stored input handler
     * @throws InputNotSetException If input handler is not set
     */
    public ISudokuInput getInput() throws InputNotSetException {
        /*
         * Null check
         */
        if (this.input == null) {
            /*
             * Throw if not set
             */
            throw new InputNotSetException();
        }

        /*
         * Return non-null object otherwise
         */
        return this.input;
    }

    /**
     * Output setter function
     *
     * @param output Output handler
     */
    public void setOutput(ISudokuOutput output) {
        this.output = output;
    }

    /**
     * Output handler getter function
     *
     * @return Stored output handler
     * @throws OutputNotSetException If no output handler is set
     */
    public ISudokuOutput getOutput() throws OutputNotSetException {
        /*
         * Null check
         */
        if (this.output == null) {
            /*
             * Throw if not set
             */
            throw new OutputNotSetException();
        }

        /*
         * Return non-null object otherwise
         */
        return this.output;
    }

    /**
     * Start solver execution
     * In this abstract class, only handler checks are implemented
     * Actual solver implementation must be done in the inheriting classes
     * @throws Exception If either input or output is not set
     */
    public void solve() throws Exception {
        /*
         * Input handler null check
         */
        if (this.input == null) {
            /*
             * Throw if not set
             */
            throw new InputNotSetException();
        }

        /*
         * Output handler null check
         */
        if (this.output == null) {
            /*
             * Throw if not set
             */
            throw new OutputNotSetException();
        }
    }
}
