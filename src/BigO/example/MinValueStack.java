package BigO.example;

import java.util.Stack;

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
