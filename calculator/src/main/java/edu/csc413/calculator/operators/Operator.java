package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,

    private static final HashMap<String, Operator> operators = new HashMap<>();

    static {

        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new LeftParenthesis());
        operators.put(")", new RightParenthesis());

    }

    public abstract int priority();
    public abstract Operand execute(Operand op1, Operand op2 );

    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     */
    public static boolean check( String token ) {

        return operators.containsKey(token);
    }

    public static Operator getOperator(String token){

        return operators.get(token);

    }

}
