package com.laszloborbely.jsudooku.core.strategy;

import com.laszloborbely.jsudooku.core.io.AbstractSingleInput;
import com.laszloborbely.jsudooku.core.io.AbstractSingleOutput;
import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.core.matrix.IMatrixReducer;
import com.laszloborbely.jsudooku.core.matrix.MatrixPair;

import java.util.Stack;

/**
 * Simple solving strategy for a single input
 * Runs until a valid solution is found
 */
public class SingleInputSimpleStrategy implements IStrategy {

    /**
     * Input object for a single puzzle
     * Contains exactly one IMatrix element and a reducer object containing matrix reduction rules
     */
    protected AbstractSingleInput input;

    /**
     * Output object for a single solution
     * Exactly one solution matrix can be set
     */
    protected AbstractSingleOutput output;

    /**
     * Constructor
     * Sets initial member properties
     *
     * @param input  Parameter containing exactly one IMatrix and a MatrixReducer object
     * @param output Parameter containing an empty output handler
     */
    public SingleInputSimpleStrategy(AbstractSingleInput input, AbstractSingleOutput output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Function to start strategy execution
     * Runs until a single solution or until no valid matrices are available
     */
    public void execute() {
        /*
         * Get input matrix from input handler
         */
        IMatrix inputMatrix = this.input.getSingleInput();

        /*
         * Get reducer object from input handler
         */
        IMatrixReducer reducer = this.input.getReducer();

        /*
         * Initialize empty output matrix
         */
        IMatrix outputMatrix = null;

        /*
         * Initialize matrix splitter stack
         * When a decision must be made, both options are pushed here
         */
        Stack<IMatrix> matrixStack = new Stack<>();

        /*
         * Initialize matrix stack with the input matrix
         */
        matrixStack.push(inputMatrix);

        /*
         * Execution runs until a solution is found or the matrix stack is empty
         * The second case also means that the puzzle is unsolvable
         */
        while (outputMatrix == null && !matrixStack.empty()) {

            /*
             * Retrieve top element of the stack
             */
            IMatrix matrix = matrixStack.pop();

            /*
             * Check if the top element is a valid solution
             */
            if (reducer.solve(matrix)) {

                /*
                 * If yes, set it as the output and terminate execution
                 */
                outputMatrix = matrix;

            } else if (reducer.validate(matrix)) {
                /*
                 * Otherwise check if its valid
                 * If yes, split into two
                 */
                MatrixPair split = reducer.split(matrix);

                /*
                 * Push both parts to the matrix stack
                 */
                matrixStack.push(split.getFirst());
                matrixStack.push(split.getSecond());

            }
        }

        /*
         * At the end, set potential solution as output
         */
        this.output.setSingleOutput(outputMatrix);

    }
}
