package BigO.example;

import java.util.Stack;

public class BalancedBrackets {

    public BalancedBrackets(){

    }

    public boolean areBracketsBalanced(String expr){

        Stack<Character> bracketStack = new Stack<Character>();

        for (int i=0; i < expr.length(); i++){
            char ch = expr.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{'){
                bracketStack.push(ch);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (bracketStack.empty())
                return false;
            char check;

            switch (ch) {
                case ')':
                    check = bracketStack.pop();
                    if (check == '[' || check == '{')
                        return false;
                    break;
                case '}':
                    check = bracketStack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = bracketStack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        //Check empty stack
        return bracketStack.empty();
    }
    // Driver code
    public static void main(String[] args)
    {
        //String expr = "([{}])";
        String expr = "[(])";
        BalancedBrackets bb = new BalancedBrackets();

        // Function call
        if (bb.areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
