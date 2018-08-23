package limitedcompiler;

/**
 * Instantiates a Compiler object and a Postfix object and tests their methods.
 * 
 * @author Matthew Stevens
 * @version 02/24/18
 */
public class LimitedCompiler 
{
    /**
     * Creates both a Compiler and a Postfix object and tests their
     * primary functions.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Compiler c = new Compiler();
        Postfix p = new Postfix();
        
        /*
            Compiler Tests
        */
        System.out.println("Tests for the Compiler:");
        System.out.println("---------------------------");
        
        // test variables for Compiler
        String test = "ab<aaaaa>";
        String test2 = "ab<c]";
        String test3 = "a{}<c]";
        String test4 = "Hello, my< name is <Matt.";
        String test5 = "Hello, my< name is>Matt.";
        String test6 = "Hello, my{ name} is>Matt.";
        String test7 = ">Hello, my<name> is Matt.";
        String test8 = "<}";
        String test9 = "[";
        String test10 = "<slkd][]fjkl;";
        
        // tests
        System.out.println("Test of 'ab<aaaaa>': " + c.validate(test));
        System.out.println("Test of 'ab<c]': " + c.validate(test2));
        System.out.println("Test of 'a{}<c]': " + c.validate(test3));
        System.out.println("Test of 'Hello, my< name is <Matt.': " +
                           c.validate(test4));
        System.out.println("Test of 'Hello, my< name is>Matt.': " +
                           c.validate(test5));
        System.out.println("Test of 'Hello, my{ name} is>Matt.': " +
                           c.validate(test6));
        System.out.println("Test of '>Hello, my<name> is Matt.': " +
                           c.validate(test7));
        System.out.println("Test of '<}': " + c.validate(test8));
        System.out.println("Test of '[': " + c.validate(test9));
        System.out.println("Test of '<slkd][]fjkl;': " + c.validate(test10));
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        /*
            Postfix Tests
        */
        System.out.println("Tests for Postfix Expressions: ");
        System.out.println("----------------------------------");
        
        // test variables for Postfix
        String postTest = "52+85-*";
        String postTest2 = "52-49*+";
        String postTest3 = "62/79-+";
        String postTest4 = "12-2+";
        String postTest5 = "37*12+/";
        String postTest6 = "42*42**";
        String postTest7 = "19-12++";
        String postTest8 = "547*+";
        String postTest9 = "52-1-62/+";
        String postTest10 = "578*23-++";
        
        // evaluations and tests for Postfix
        p.evaluate(postTest);
        System.out.println("Test of 52+85-*: " + p.getAnswer());
        
        p.evaluate(postTest2);
        System.out.println("Test of 52-49*+: " + p.getAnswer()); 
        
        p.evaluate(postTest3);
        System.out.println("Test of 62/79-+: " + p.getAnswer());
        
        p.evaluate(postTest4);
        System.out.println("Test of 12-2+: " + p.getAnswer());
        
        p.evaluate(postTest5);
        System.out.println("Test of 37*12+/: " + p.getAnswer());
        
        p.evaluate(postTest6);
        System.out.println("Test of 42*42**: " + p.getAnswer());
        
        p.evaluate(postTest7);
        System.out.println("Test of 19-12++: " + p.getAnswer());
        
        p.evaluate(postTest8);
        System.out.println("Test of 547*+: " + p.getAnswer());
        
        p.evaluate(postTest9);
        System.out.println("Test of 52-1-62/+: " + p.getAnswer());
        
        p.evaluate(postTest10);
        System.out.println("Test of 578*23-++: " + p.getAnswer());
    }   
}