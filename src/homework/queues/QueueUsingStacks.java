package homework.queues;

import java.util.Stack;

/** Queue is FIFO (first in - first out) data structure, in which the elements are inserted from one side - rear and
 * removed from the other - front. The most intuitive way to implement it is with linked lists, but another approach
 * is using stacks. Stack is LIFO (last in - first out) data structure, in which elements are added and removed from
 * the same end, called top. To satisfy FIFO property of a queue we need to keep two stacks.
 * They serve to reverse arrival order of the elements and one of them store the queue elements in their final order.
*/

public class QueueUsingStacks {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // The newly arrived element is always added on top of stack s1
    // Push value to the back of the queue
    public void push(int value){
        s1.push(value);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        // if both stacks are empty
        if (empty())
        {
            System.out.println("Underflow!!");
            System.exit(0);
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {

        if (empty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }

        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks myQueue = new QueueUsingStacks();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        // the last element in the s1 will be our first item of queue.
        System.out.println("queue: "+myQueue.s1);
        System.out.println("peek: "+myQueue.peek());
        System.out.println("pop: "+myQueue.pop());
        System.out.println("queue: "+myQueue.s1);
        System.out.println("peek: "+myQueue.peek());
        System.out.println("is queue empty: "+myQueue.empty());
    }
}
