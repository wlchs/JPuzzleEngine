package com.laszloborbely.jpuzzle.core.strategy;

import com.laszloborbely.jpuzzle.core.io.IPuzzleInput;
import com.laszloborbely.jpuzzle.core.io.IPuzzleOutput;

/**
 * Singleton factory for creating the matching solving strategy for the input and output handlers
 */
public final class StrategyFactory {
    /**
     * Static factory method for strategy creation
     *
     * @param input  Input handler
     * @param output Output handler
     * @return Returns the matching strategy implementation
     */
    public static IStrategy createFrom(IPuzzleInput input, IPuzzleOutput output) {
        /*
         * Check for streaming input
         */
        boolean streamedInput = input.streamed();

        /*
         * Check whether all solutions are required or only one
         */
        boolean exhaustiveOutput = output.exhaustive();

        /*
         * Single input single solution
         */
        if (!streamedInput && !exhaustiveOutput) {
            return new SingleInputSimpleStrategy(input, output);
        }

        /*
         * Single input every solution
         */
        if (!streamedInput) {
            return new SingleInputExhaustiveStrategy(input, output);
        }

        /*
         * Multiple inputs single solution
         */
        if (!exhaustiveOutput) {
            return new ManyInputSimpleStrategy(input, output);
        }

        /*
         * Multiple inputs every solution
         */
        return new ManyInputExhaustiveStrategy(input, output);
    }

    /**
     * Private constructor
     * No object creation is required
     */
    private StrategyFactory() {
    }
}
