package com.laszloborbely.jsudooku.quadratic.io;

import com.laszloborbely.jsudooku.core.io.AbstractSingleOutput;

public class SingleConsoleOutput extends AbstractSingleOutput {
    @Override
    public void write() {
        System.out.println(outputMatrix);
    }
}
