package com.laszloborbely.jsudooku.core.solver;

import com.laszloborbely.jsudooku.core.io.ISudokuInput;
import com.laszloborbely.jsudooku.core.io.ISudokuOutput;
import com.laszloborbely.jsudooku.core.strategy.IStrategy;
import com.laszloborbely.jsudooku.core.strategy.StrategyFactory;

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
    public StrategySolver(ISudokuInput input, ISudokuOutput output) {
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
