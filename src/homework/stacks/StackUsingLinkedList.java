package homework.stacks;


public class StackUsingLinkedList {
    Node top;
    Node bottom;
    int size;

    class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    public StackUsingLinkedList(){
        top = null;
        bottom = null;
        size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void push(String value){

        Node newNode = new Node(value);
        if(isEmpty()){
            // Inserting first node where head and tail are same
            top = newNode;
            bottom = newNode;
        } else {
            //New node points to Old head (pushing it down the stack)
            newNode.next = top;
            //New node becomes head
            top = newNode;
        }

        //Increment size of stack
        size++;
    }

    public String peek(){

        if (isEmpty())
            return null;

        //Return the head of the stack
        return top.value;
    }

    public void pop(){

        if(!isEmpty()) {
            // Top is removed by pointing it to the next node
            top = top.next;

            //If size of stack is one then top and bottom are null (empty stack)
            if (size == 1){
                bottom = null;
            }

            //Decrement by 1
            size--;
        }
    }

    public String getLastElement(){

        if(isEmpty())
            return null;

        return bottom.value;
    }

    public static void main(String[] args) {
        StackUsingLinkedList myStack = new StackUsingLinkedList();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.getLastElement());
    }
}
