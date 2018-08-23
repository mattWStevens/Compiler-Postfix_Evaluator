package limitedcompiler;
import java.util.Stack;

/**
 * Represents a Postfix expression evaluator.
 * 
 * @author Matthew Stevens
 * @version 02/24/18
 */
public class Postfix 
{
    private Stack<Integer> result = new Stack();
    
    /**
     * Constructs a Postfix object.
     */
    public Postfix()
    {
        
    }
    
    /**
     * Evaluates a given String postfix expression and 
     * stores the answer back in the result Stack.
     * 
     * @param expression the postfix expression to be evaluated
     */
    public void evaluate(String expression)
    {
        for (int i = 0; i < expression.length(); i++)
        {
            // check for operands to be added to the Stack
            if (Character.isDigit(expression.charAt(i)))
            {
                result.push(Integer.parseInt(Character.toString(expression.charAt(i))));
            }
            
            else
            {
                if (!result.isEmpty())
                {
                    // op2 comes first because first in, last out
                    int op2 = result.pop();
                    int op1 = result.pop();
                    char operator = expression.charAt(i);
                    
                    // compute result
                    int answer = operate(op1, op2, operator);
                    
                    // push result back into stack
                    result.push(answer);
                }
            }
        }
    }
    
    /**
     * Returns the answer to the Postfix expression that was just evaluated. If
     * no expression was evaluated, it will return a default value of zero.
     * 
     * @return the answer to the Postfix expression or zero if no expression
     * was evaluated prior to invoking this method.
     */
    public int getAnswer()
    {
        // returns 0 if there was no answer
        return (!result.isEmpty()) ? result.pop() : 0;
    }
    
    //----------------------------------------------------------
    // private helper method
    //----------------------------------------------------------
    /**
     * Evaluates the expression specified by the given operands
     * and operator.
     * 
     * @param op1 the first operand in the expression
     * @param op2 the second operand in the expression
     * @param operator the operator in the expression
     * @return the result of the operation of the two operands
     * specified by the given operator.
     */
    private int operate(int op1, int op2, char operator)
    {
        int result = 0;
        
        if (operator == '+')
        {
            result = op1 + op2;
        }
        
        if (operator == '-')
        {
            result = op1 - op2;
        }
        
        if (operator == '/')
        {
            result = op1 / op2;
        }
        
        if (operator == '*')
        {
            result = op1 * op2;
        }
        
        return result;
    }
}