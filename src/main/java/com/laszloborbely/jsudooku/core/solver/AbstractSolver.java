package com.laszloborbely.jsudooku.core.solver;

import com.laszloborbely.jsudooku.core.io.ISudokuInput;
import com.laszloborbely.jsudooku.core.io.ISudokuOutput;

public abstract class AbstractSolver {
    protected ISudokuInput input;
    protected ISudokuOutput output;

    public AbstractSolver() {}

    public AbstractSolver(ISudokuInput input, ISudokuOutput output) {
        this.input = input;
        this.output = output;
    }

    public void setInput(ISudokuInput input) {
        this.input = input;
    }

    public ISudokuInput getInput() throws InputNotSetException {
        if (this.input == null) {
            throw new InputNotSetException();
        }

        return this.input;
    }

    public void setOutput(ISudokuOutput output) {
        this.output = output;
    }

    public ISudokuOutput getOutput() throws OutputNotSetException {
        if (this.output == null) {
            throw new OutputNotSetException();
        }

        return output;
    }

    public void solve() throws Exception {
        if (this.input == null) {
            throw new InputNotSetException();
        }

        if (this.output == null) {
            throw new OutputNotSetException();
        }
    }
}
