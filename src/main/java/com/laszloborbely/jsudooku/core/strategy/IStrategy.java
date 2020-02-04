package com.laszloborbely.jsudooku.core.strategy;

/**
 * Interface of matrix solving strategies
 */
public interface IStrategy {
    /**
     * Executes selected solving strategy and writes the results to the output handler
     */
    void execute();
}
