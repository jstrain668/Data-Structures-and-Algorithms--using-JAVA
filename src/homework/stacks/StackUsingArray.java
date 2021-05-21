package homework.stacks;

import data_structures.stacks.stack_using_arrays.Stack;

import java.util.ArrayList;

public class StackUsingArray {

    ArrayList<String> stackArray;

    public StackUsingArray(){
        stackArray = new ArrayList<>();
    }

    public void push(String value){
        stackArray.add(value);
    }

    public String pop(){
        if (!isEmpty())
            return stackArray.remove(stackArray.size()-1);

        return null;
    }

    public boolean isEmpty(){
        return stackArray.size() == 0;
    }

    public String peek() {
        if (this.stackArray.size() > 0) {
            return stackArray.get(stackArray.size() - 1);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
    }
}
