package BigO.example;

import java.util.Stack;

/**
        * Created by gouthamvidyapradhan on 08/03/2017. Design a stack that supports push, pop, top, and
        * retrieving the minimum element in constant time.
        *
        * <p>push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top()
        * -- Get the top element. getMin() -- Retrieve the minimum element in the stack. Example: MinStack
        * minStack = new MinStack(); minStack.push(-2); minStack.push(0); minStack.push(-3);
        * minStack.getMin(); --> Returns -3. minStack.pop(); minStack.top(); --> Returns 0.
        * minStack.getMin(); --> Returns -2.
        */

public class MinValueStack {

    private Stack<Node> stack;

    class Node {
        int value;
        int min;

        Node(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    public MinValueStack(){
        this.stack = new Stack<Node>();
    }


    public void push(int value){

        if (this.stack.empty()){
            this.stack.push(new Node(value,value));
        } else{

            int minValue = Math.min(value,getMinValue());
            this.stack.push(new Node(value,minValue));
        }
    }

    public void pop(){
        if (!this.stack.empty()){
            this.stack.pop();
        }
    }

    public int top(){
        if (!this.stack.empty()){
            return this.stack.peek().value;
        }

        throw new RuntimeException("Cannot retrieve top value from empty stack");
    }

    public int getMinValue(){
        if (!this.stack.empty()){
            return this.stack.peek().min;
        }

        throw new RuntimeException("Cannot retrieve min value from empty stack");
    }
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MinValueStack minStack = new MinValueStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMinValue());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMinValue());
    }
}
