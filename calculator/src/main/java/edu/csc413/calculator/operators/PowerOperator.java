package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {

    private int answer;

    public int priority(){

        return 4;
    }

    public Operand execute(Operand op1, Operand op2 ){

        Double power = Math.pow(op1.getValue(), op2.getValue());
        answer = (int)power.doubleValue();

        return new Operand(answer);
    }
}

