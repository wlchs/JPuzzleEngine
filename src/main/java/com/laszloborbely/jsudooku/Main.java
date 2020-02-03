package com.laszloborbely.jsudooku;

import com.laszloborbely.jsudooku.core.io.SingleConstInput;
import com.laszloborbely.jsudooku.core.io.SingleConsoleOutput;
import com.laszloborbely.jsudooku.core.solver.AbstractSolver;
import com.laszloborbely.jsudooku.core.solver.StrategySolver;

public class Main {
    public static void main(String[] args) {
        AbstractSolver solver = new StrategySolver(new SingleConstInput(), new SingleConsoleOutput());
        try {
            solver.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
