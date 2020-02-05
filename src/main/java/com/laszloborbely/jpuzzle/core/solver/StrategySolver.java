package com.laszloborbely.jpuzzle.core.solver;

import com.laszloborbely.jpuzzle.core.io.IPuzzleInput;
import com.laszloborbely.jpuzzle.core.io.IPuzzleOutput;
import com.laszloborbely.jpuzzle.core.strategy.IStrategy;
import com.laszloborbely.jpuzzle.core.strategy.StrategyFactory;

/**
 * Actual solver implementation using solving strategies
 */
public class StrategySolver extends AbstractSolver {
    /**
     * Solving strategy object
     */
    protected IStrategy strategy;

    /**
     * Initializing constructor
     *
     * @param input  Input handler
     * @param output Output handler
     */
    public StrategySolver(IPuzzleInput input, IPuzzleOutput output) {
        super(input, output);
    }

    /**
     * Overridden solver function
     * Makes use of the parent function for executing handler checks
     * Creates the matching strategy type using the strategy factory class
     *
     * @throws Exception If any of the handlers were left uninitialized
     */
    @Override
    public void solve() throws Exception {
        /*
         * Call parent function for null checks
         */
        super.solve();

        /*
         * Create matching strategy based on the handler types
         */
        this.strategy = StrategyFactory.createFrom(this.input, this.output);

        /*
         * Execute solving strategy
         */
        this.strategy.execute();
    }
}
