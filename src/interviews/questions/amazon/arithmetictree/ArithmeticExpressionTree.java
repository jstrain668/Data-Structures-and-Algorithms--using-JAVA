package interviews.questions.amazon.arithmetictree;

import java.util.Arrays;
import java.util.Stack;

//Question: Question (Object Oriented): An arithmetic expression can be represented as a computation tree. For instance,
// (5 x 3) + (4 / 2) is a balanced binary tree with "+" as the root node. Design classes to represent the tree with the
// goal of computing the value.
// Not concerned with constructing the tree or parsing and expression. You can assume these classes will be instantiated
// for you. The problem here is to represent the expression as OO classes.


//Reference: https://leetcode.ca/2020-05-15-1628-Design-an-Expression-Tree-With-Evaluate-Function/
//Reference: https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
//Reference: https://www2.seas.gwu.edu/~simhaweb/cs1112/modules/module10/suppl/index.html


//Solution: A common superclass with an “evaluate()” method. Subclasses representing literals and operators.
public class ArithmeticExpressionTree {

    ExpTreeNode buildTree(String[] postfix) {
        Stack<ExpTreeNode> stack = new Stack<>();
        for (String s : postfix) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(new OperatorTreeNode(s, stack.pop(), stack.pop()));
                    break;
                default:
                    stack.push(new LiteralTreeNode(s));
            }
        }
        return stack.pop();
    }

    //Parsing of an expression and building of a postfix expression is out of scope. The postfix expression is provided
    //as an array of strings.
    public static void main(String[] args) {
        ArithmeticExpressionTree aet = new ArithmeticExpressionTree();
        String[] s= {"3","4","+","2","*","7","/"};
        String[] s2 = {"4","5","7","2","+","-","*"};
        ExpTreeNode expTree = aet.buildTree(s2);
        System.out.println("Postfix expression: "+ Arrays.toString(s2)+ " evaluates to: "+expTree.evaluate());

    }
}
