package com.laszloborbely.jsudooku.core.strategy;

import com.laszloborbely.jsudooku.core.io.ISudokuInput;
import com.laszloborbely.jsudooku.core.io.ISudokuOutput;
import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.core.matrix.IMatrixReducer;
import com.laszloborbely.jsudooku.core.matrix.MatrixPair;

import java.util.Stack;

/**
 * Solving strategy for finding every solution for one input puzzle
 */
public class SingleInputExhaustiveStrategy implements IStrategy {
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
     * Initialing constructor
     *
     * @param input  Input handler
     * @param output Output handler
     */
    public SingleInputExhaustiveStrategy(ISudokuInput input, ISudokuOutput output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Strategy execution function
     * Solves the input puzzle by finding every possible solution
     * The results are then pushed to the output handler
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
        while (!matrixStack.empty()) {

            /*
             * Retrieve top element of the stack
             */
            IMatrix matrix = matrixStack.pop();

            /*
             * Write intermediate state
             */
            /* output.writeIntermediate(matrix); */

            /*
             * Check if the top element is valid
             */
            if (reducer.validate(matrix)) {

                /*
                 * Check if the top element is a solution
                 * If yes, write output
                 */
                if (reducer.solution(matrix)) {
                    output.write(matrix);

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
    }
}
