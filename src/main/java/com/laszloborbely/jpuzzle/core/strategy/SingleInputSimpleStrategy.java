package com.laszloborbely.jpuzzle.core.strategy;

import com.laszloborbely.jpuzzle.core.io.IPuzzleInput;
import com.laszloborbely.jpuzzle.core.io.IPuzzleOutput;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleReducer;
import com.laszloborbely.jpuzzle.core.puzzle.PuzzlePair;

import java.util.Stack;

/**
 * Simple solving strategy for a single input
 * Runs until a valid solution is found
 */
public class SingleInputSimpleStrategy implements IStrategy {
    /**
     * Input object for a single puzzle
     * Contains exactly one puzzle element and a reducer object containing puzzle reduction rules
     */
    protected IPuzzleInput input;

    /**
     * Output object for a single solution
     * Exactly one solution puzzle can be set
     */
    protected IPuzzleOutput output;

    /**
     * Constructor
     * Sets initial member properties
     *
     * @param input  Parameter containing exactly one puzzle and a puzzle reducer object
     * @param output Parameter containing an empty output handler
     */
    public SingleInputSimpleStrategy(IPuzzleInput input, IPuzzleOutput output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Function to start strategy execution
     * Runs until a single solution or until no valid puzzles are available
     */
    public void execute() {
        /*
         * Get input puzzle from input handler
         */
        IPuzzle inputPuzzle = this.input.read();

        /*
         * Get reducer object from input handler
         */
        IPuzzleReducer reducer = this.input.getReducer();

        /*
         * Initialize empty output puzzle
         */
        IPuzzle outputPuzzle = null;

        /*
         * Initialize puzzle splitter stack
         * When a decision must be made, both options are pushed here
         */
        Stack<IPuzzle> puzzleStack = new Stack<>();

        /*
         * Initialize puzzle stack with the input puzzle
         */
        puzzleStack.push(inputPuzzle);

        /*
         * Execution runs until a solution is found or the puzzle stack is empty
         * The second case also means that the puzzle is unsolvable
         */
        while (outputPuzzle == null && !puzzleStack.empty()) {

            /*
             * Retrieve top element of the stack
             */
            IPuzzle puzzle = puzzleStack.pop();

            /*
             * Write intermediate state
             */
            output.writeIntermediate(puzzle);

            /*
             * Check if the top element is valid
             */
            if (reducer.validate(puzzle)) {

                /*
                 * Check if the top element is a solution
                 * If yes, set it as the output and terminate execution
                 */
                if (reducer.solution(puzzle)) {
                    outputPuzzle = puzzle;

                } else {
                    /*
                     * Split solution space into two
                     */
                    PuzzlePair split = reducer.split(puzzle);

                    /*
                     * Check first puzzle, if not null, push to stack
                     */
                    if (split.getFirst() != null) {
                        puzzleStack.push(split.getFirst());
                    }

                    /*
                     * Check second puzzle, if not null, push to stack
                     */
                    if (split.getSecond() != null) {
                        puzzleStack.push(split.getSecond());
                    }
                }
            }
        }

        /*
         * At the end, set potential solution as output
         */
        this.output.write(outputPuzzle);

    }
}
