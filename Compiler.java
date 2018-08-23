package limitedcompiler;
import java.util.Stack;

/**
 * Represents a Compiler that tests whether or not three different
 * kinds of parentheses match.
 * 
 * @author Matthew Stevens
 * @version 02/24/18
 */
public class Compiler 
{
    private Stack<Character> stack = new Stack();

    /**
     * Constructs a Compiler object.
     */
    public Compiler()
    {
        
    }
    
    /**
     * Evaluates whether or not the given string has all of its
     * parentheses matched correctly.
     * 
     * @param str the string to be evaluated
     * @return true if the parentheses match, false if they
     * do not
     */
    public boolean validate(String str)
    {
        boolean hit = false;    // keeps track of if a parenthesis has been hit
        int numParens = 0;  // var to make sure no unmatched parentheses
        
        for (int i = 0; i < str.length(); i++)
        {
            // counts number of parentheses
            if (isParen(str.charAt(i)))
            {
                numParens++;
            }
            
            // return false if first parenthesis is a right parenthesis
            if (numParens == 0 && isRightParen(str.charAt(i)))
            {
                return false;
            }
            
            // look for first instance of a left parenthesis
            if (isLeftParen(str.charAt(i)) && !hit)
            {
                stack.push(str.charAt(i));
                hit = true;
                
                continue; // check next letter once hit left paren
            }
            
            /*
                If left parenthesis is already in stack, check for 
                right parenthesis and then evaluate if they match
            */
            if (hit && isParen(str.charAt(i)))
            {
                // makes sure parenthesis following left is a right, not left
                if (isLeftParen(str.charAt(i)))
                {
                    return false;
                }
                
                else
                {
                    if (!stack.isEmpty())
                    {
                        char check = stack.pop();

                        boolean answer = check(check, str.charAt(i));
                
                        if (!answer)
                        {
                            return answer;
                        }
                
                        hit = false;
                    }
                }
            }
        }
        
        return (numParens % 2 == 0);  // make sure there are no unmatched parens
    }
    
    //--------------------------------------------------------
    // private helper methods
    //--------------------------------------------------------
    /**
     * Evaluates if given left parenthesis matches the given right
     * parenthesis.
     * 
     * @param check the left parenthesis to be checked
     * @param curr the right parenthesis to evaluate
     * @return true if the parentheses match, false otherwise
     */
    private boolean check(char check, char curr)
    {
        if (check == '<')
        {
            if (curr == '>')
            {
                return true;
            }
            
            else
            {
                return false;
            }
        }
        
        if (check == '{')
        {
            if (curr == '}')
            {
                return true;
            }
            
            else
            {
                return false;
            }
        }
        
        else
        {
            if (curr == ']')
            {
                return true;
            }
            
            else
            {
                return false;
            }
        }
    }
    
    /**
     * Checks whether or not the given character
     * is a parenthesis.
     * 
     * @param character the given character
     * @return true if the character is a parenthesis, false otherwise
     */
    private boolean isParen(char character)
    {
        return (character == '<' || character == '>' ||
                character == '[' || character == ']' ||
                character == '{' || character == '}');
    }
    
    /**
     * Checks whether or not the given parenthesis is a left
     * parenthesis.
     * 
     * @param paren the given parenthesis
     * @return true if the parenthesis is a left parenthesis, false
     * otherwise
     */
    private boolean isLeftParen(char paren)
    {
        return (paren == '<' || paren == '{' ||
                paren == '[');
    }
    
    /**
     * Checks whether or not the given parenthesis is a right
     * parenthesis.
     * 
     * @param paren the given parenthesis
     * @return true if the parenthesis is a right parenthesis, false
     * otherwise.
     */
    private boolean isRightParen(char paren)
    {
        return (paren == '>' || paren == '}' ||
                paren == ']');
    }
}