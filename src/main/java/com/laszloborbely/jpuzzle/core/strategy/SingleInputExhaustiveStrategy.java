package com.laszloborbely.jpuzzle.core.strategy;

import com.laszloborbely.jpuzzle.core.io.IPuzzleInput;
import com.laszloborbely.jpuzzle.core.io.IPuzzleOutput;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleReducer;
import com.laszloborbely.jpuzzle.core.puzzle.PuzzlePair;

import java.util.Stack;

/**
 * Solving strategy for finding every solution for one input puzzle
 */
public class SingleInputExhaustiveStrategy implements IStrategy {
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
     * Initialing constructor
     *
     * @param input  Input handler
     * @param output Output handler
     */
    public SingleInputExhaustiveStrategy(IPuzzleInput input, IPuzzleOutput output) {
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
         * Get input puzzle from input handler
         */
        IPuzzle inputPuzzle = this.input.read();

        /*
         * Get reducer object from input handler
         */
        IPuzzleReducer reducer = this.input.getReducer();

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
        while (!puzzleStack.empty()) {

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
                 * If yes, write output
                 */
                if (reducer.solution(puzzle)) {
                    output.write(puzzle);

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
    }
}
