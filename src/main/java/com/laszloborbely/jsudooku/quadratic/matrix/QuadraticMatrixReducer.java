package com.laszloborbely.jsudooku.quadratic.matrix;

import com.laszloborbely.jsudooku.core.matrix.IMatrix;
import com.laszloborbely.jsudooku.core.matrix.IMatrixReducer;
import com.laszloborbely.jsudooku.core.matrix.MatrixPair;
import com.laszloborbely.jsudooku.core.rules.ISolutionCriteria;
import com.laszloborbely.jsudooku.core.rules.IValidationRule;
import com.laszloborbely.jsudooku.quadratic.rules.QColumnValidationRule;
import com.laszloborbely.jsudooku.quadratic.rules.QGroupValidationRule;
import com.laszloborbely.jsudooku.quadratic.rules.QRowValidationRule;
import com.laszloborbely.jsudooku.quadratic.rules.QuadraticSolutionCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution-space reducer class
 */
public class QuadraticMatrixReducer implements IMatrixReducer {
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
     * @param matrix Input matrix to validate
     * @return True if all rules are valid, false otherwise
     */
    @Override
    public boolean validate(IMatrix matrix) {
        for (IValidationRule rule : validationRules) {
            if (!rule.isValid(matrix)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check whether the input matrix is a solution
     *
     * @param matrix Input matrix to check for solutions
     * @return True if the solution criteria is fulfilled, false otherwise
     */
    @Override
    public boolean solution(IMatrix matrix) {
        return solutionCriteria.isSolved(matrix);
    }

    /**
     * Matrix splitter function
     * Separates the solution-space into two parts forming a disjoint complete solution-space
     *
     * @param matrix Input matrix to split according to user-defined rule(s)
     * @return Split matrix pair
     */
    @Override
    public MatrixPair split(IMatrix matrix) {
        return QuadraticElementSplitter.split((QuadraticMatrix) matrix);
    }
}
