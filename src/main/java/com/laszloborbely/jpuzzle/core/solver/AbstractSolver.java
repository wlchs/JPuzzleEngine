package com.laszloborbely.jpuzzle.core.solver;

import com.laszloborbely.jpuzzle.core.io.IPuzzleInput;
import com.laszloborbely.jpuzzle.core.io.IPuzzleOutput;

/**
 * Abstract class for puzzle solvers
 * Stores necessary input and output object as well as defines default getter and setter functions
 */
public abstract class AbstractSolver {
    /**
     * Input puzzle object containing one or more puzzles and the corresponding reducer
     */
    protected IPuzzleInput input;

    /**
     * Output puzzle handler defining solution strategy and output location
     */
    protected IPuzzleOutput output;

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
    public AbstractSolver(IPuzzleInput input, IPuzzleOutput output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Input handler setter function
     *
     * @param input Input handler
     */
    public void setInput(IPuzzleInput input) {
        this.input = input;
    }

    /**
     * Input handler getter function
     *
     * @return Stored input handler
     * @throws InputNotSetException If input handler is not set
     */
    public IPuzzleInput getInput() throws InputNotSetException {
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
    public void setOutput(IPuzzleOutput output) {
        this.output = output;
    }

    /**
     * Output handler getter function
     *
     * @return Stored output handler
     * @throws OutputNotSetException If no output handler is set
     */
    public IPuzzleOutput getOutput() throws OutputNotSetException {
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
     *
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
