package com.laszloborbely.jsudooku.core.solver;

import com.laszloborbely.jsudooku.core.io.ISudokuInput;
import com.laszloborbely.jsudooku.core.io.ISudokuOutput;
import com.laszloborbely.jsudooku.core.strategy.IStrategy;
import com.laszloborbely.jsudooku.core.strategy.StrategyFactory;

public class StrategySolver extends AbstractSolver {
    protected IStrategy strategy;

    public StrategySolver() {
    }

    public StrategySolver(ISudokuInput input, ISudokuOutput output) {
        super(input, output);
    }

    @Override
    public void solve() throws Exception {
        super.solve();
        this.strategy = StrategyFactory.createFrom(this.input, this.output);
        this.strategy.execute();
    }
}
