package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {

    public int priority(){

        return 3;
    }

    public Operand execute(Operand op1, Operand op2 ){

        Double power = Math.pow(op1.getValue(), op2.getValue());
        int pow = (int)power.doubleValue();

        return new Operand(pow);
    }
}

