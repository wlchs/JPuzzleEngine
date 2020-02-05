package com.laszloborbely.jsudooku.core.strategy;

import com.laszloborbely.jsudooku.core.io.ISudokuInput;
import com.laszloborbely.jsudooku.core.io.ISudokuOutput;
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
    protected ISudokuInput input;

    /**
     * Output object for a single solution
     * Exactly one solution matrix can be set
     */
    protected ISudokuOutput output;

    /**
     * Constructor
     * Sets initial member properties
     *
     * @param input  Parameter containing exactly one IMatrix and a MatrixReducer object
     * @param output Parameter containing an empty output handler
     */
    public SingleInputSimpleStrategy(ISudokuInput input, ISudokuOutput output) {
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
        IMatrix inputMatrix = this.input.read();

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
             * Write intermediate state
             */
            output.writeIntermediate(matrix);

            /*
             * Check if the top element is valid
             */
            if (reducer.validate(matrix)) {

                /*
                 * Check if the top element is a solution
                 * If yes, set it as the output and terminate execution
                 */
                if (reducer.solution(matrix)) {
                    outputMatrix = matrix;

                } else {
                    /*
                     * Split solution space into two
                     */
                    MatrixPair split = reducer.split(matrix);

                    /*
                     * Check first matrix, if not null, push to stack
                     */
                    if (split.getFirst() != null) {
                        matrixStack.push(split.getFirst());
                    }

                    /*
                     * Check second matrix, if not null, push to stack
                     */
                    if (split.getSecond() != null) {
                        matrixStack.push(split.getSecond());
                    }
                }
            }
        }

        /*
         * At the end, set potential solution as output
         */
        this.output.write(outputMatrix);

    }
}
