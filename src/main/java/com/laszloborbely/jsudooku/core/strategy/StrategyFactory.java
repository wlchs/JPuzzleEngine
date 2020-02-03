package com.laszloborbely.jsudooku.core.strategy;

import com.laszloborbely.jsudooku.core.io.*;

public final class StrategyFactory {
    public static IStrategy createFrom(AbstractSingleInput input, AbstractSingleOutput output) {
        return new SingleInputSimpleStrategy(input, output);
    }

    public static IStrategy createFrom(AbstractSingleInput input, AbstractMultiOutput output) {
        return new SingleInputExhaustiveStrategy(input, output);
    }

    public static IStrategy createFrom(AbstractMultiInput input, AbstractSingleOutput output) {
        return new ManyInputSimpleStrategy(input, output);
    }

    public static IStrategy createFrom(AbstractMultiInput input, AbstractMultiOutput output) {
        return new ManyInputExhaustiveStrategy(input, output);
    }

    public static IStrategy createFrom(ISudokuInput input, ISudokuOutput output) {
        boolean inputArity = input.many();
        boolean outputArity = output.many();

        if (!inputArity && !outputArity) {
            return createFrom((AbstractSingleInput) input, (AbstractSingleOutput) output);
        }
        if (!inputArity) {
            return createFrom((AbstractSingleInput) input, (AbstractMultiOutput) output);
        }
        if (!outputArity) {
            return createFrom((AbstractMultiInput) input, (AbstractSingleOutput) output);
        }
        return createFrom((AbstractMultiInput) input, (AbstractMultiOutput) output);
    }

    private StrategyFactory() {
    }
}
