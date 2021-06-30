package interviews.questions;

import java.util.Stack;


// Description: Use two stacks, one stack executes the per se stack functions and the min stack which
// always keeps the min value at the top of the minStack. When pushing to the minStack, the value is pushed
// is on is either the current peek value of minStack or the supplied value which ever is smaller.
// Time Complexity : O(1) for each of the stack operations
// Space Complexity: O(n) - have the additional space of the second stack.
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || minStack.peek() > val){
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {

        if (!stack.isEmpty() && !minStack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current min stack: "+minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("Current top of stack: "+minStack.top()); // return 0
        System.out.println("Current min stack: "+minStack.getMin()); // return -2
    }
}
