package com.laszloborbely.jpuzzle.sudoku.matrix;

import com.laszloborbely.jpuzzle.core.puzzle.IPuzzle;
import com.laszloborbely.jpuzzle.core.puzzle.IPuzzleReducer;
import com.laszloborbely.jpuzzle.core.puzzle.PuzzlePair;
import com.laszloborbely.jpuzzle.core.rules.ISolutionCriteria;
import com.laszloborbely.jpuzzle.core.rules.IValidationRule;
import com.laszloborbely.jpuzzle.sudoku.rules.QColumnValidationRule;
import com.laszloborbely.jpuzzle.sudoku.rules.QGroupValidationRule;
import com.laszloborbely.jpuzzle.sudoku.rules.QRowValidationRule;
import com.laszloborbely.jpuzzle.sudoku.rules.QuadraticSolutionCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution-space reducer class
 */
public class QuadraticMatrixReducer implements IPuzzleReducer {
    /*
     * Quadratic matrix solution criteria
     */
    ISolutionCriteria solutionCriteria;

    /*
     * Quadratic matrix validation rule list
     */
    List<IValidationRule> validationRules;

    /**
     * Default constructor initializing solution criteria and validation rules
     */
    public QuadraticMatrixReducer() {
        /*
         * Initialize solution criteria
         */
        solutionCriteria = new QuadraticSolutionCriteria();

        /*
         * Initialize matrix validation rules
         */
        validationRules = new ArrayList<>();
        validationRules.add(new QRowValidationRule());
        validationRules.add(new QColumnValidationRule());
        validationRules.add(new QGroupValidationRule());
    }

    /**
     * Validate matrix according to several validation rules
     *
     * @param puzzle Input matrix to validate
     * @return True if all rules are valid, false otherwise
     */
    @Override
    public boolean validate(IPuzzle puzzle) {
        for (IValidationRule rule : validationRules) {
            if (!rule.isValid(puzzle)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check whether the input matrix is a solution
     *
     * @param puzzle Input matrix to check for solutions
     * @return True if the solution criteria is fulfilled, false otherwise
     */
    @Override
    public boolean solution(IPuzzle puzzle) {
        return solutionCriteria.isSolved(puzzle);
    }

    /**
     * Matrix splitter function
     * Separates the solution-space into two parts forming a disjoint complete solution-space
     *
     * @param puzzle Input matrix to split according to user-defined rule(s)
     * @return Split matrix pair
     */
    @Override
    public PuzzlePair split(IPuzzle puzzle) {
        return QuadraticElementSplitter.split((QuadraticMatrix) puzzle);
    }
}
