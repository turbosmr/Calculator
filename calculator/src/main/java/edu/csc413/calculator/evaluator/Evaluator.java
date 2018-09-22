package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.Operator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {

  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;
  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/()";

  //This is just to keep from having to reuse code three times
  public void Stacks(){

    Operator oldOpr = operatorStack.pop();
    Operand op2 = operandStack.pop();
    Operand op1 = operandStack.pop();
    operandStack.push(oldOpr.execute(op1, op2));

  }
  public Evaluator() {

    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval(String expression) {

    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            throw new RuntimeException("*****invalid token******");
          }

          Operator newOperator = Operator.getOperator(token);

          if (!token.equals("(")){

            while ((!operatorStack.isEmpty()) && (operatorStack.peek().priority() >= newOperator.priority())) {

              //calls the function Stacks to implement the pushing and pop of the stacks
              Stacks();
            }
          }

          operatorStack.push( newOperator );

          if (token.equals(")")){

            operatorStack.pop();
            while (!(operatorStack.peek().priority() == 0) ) {

              Stacks();
            }
             operatorStack.pop();
          }
        }
      }
    }

      while(!operatorStack.isEmpty()){

        Stacks();
      }
    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop.

    return operandStack.pop().getValue();
  }
}

