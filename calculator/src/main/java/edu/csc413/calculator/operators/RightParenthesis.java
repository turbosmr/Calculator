package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class RightParenthesis extends Operator {

    public int priority() {

        return 5;
    }

    public Operand execute(Operand opd1, Operand opd2) {

        return null;
    }
}
