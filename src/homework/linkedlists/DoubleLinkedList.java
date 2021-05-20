package homework.linkedlists;

import java.util.Arrays;

public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int size;

    class Node {
        Node next;
        Node previous;
        int value;

        Node (int value){
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public DoubleLinkedList(int value){
        head = new Node(value);
        tail = head;
        size = 1;
    }

    public void insertAtEnd(int value){

        //Create new node with specified value
        Node newNode = new Node(value);

        //Old tail (tail.next) points to new tail (newNode)
        this.tail.next = newNode;

        //New node previous will be the old tail
        newNode.previous = tail;

        //Tail becomes new node
        this.tail = newNode;

        //Increment size of list
        this.size++;
    }

    public void insertAtFront(int value){

        //Create new node with specified value
        Node newNode = new Node(value);

        //New node points to (next) old head
        newNode.next = head;

        //Old head previous points to new Node (new head)
        head.previous = newNode;

        //New node becomes head
        this.head = newNode;

        //Increment size of list
        this.size++;
    }

    public void insertNodeBefore(int nodeIdx,int value){

        if (nodeIdx < 0 || nodeIdx > this.size){
            System.out.println("Please specify a value between 0 and "+this.size);
        } else if (nodeIdx == 0) {
            //Insert at front
            this.insertAtFront(value);
        } else if (nodeIdx == this.size) {
            //Insert at end
            this.insertAtEnd(value);
        } else {
            // Traverse to node index -1 as inserting before that index
            Node current = this.head;
            for (int i = 0; i < nodeIdx -1; i++){
                current = current.next;
            }

            //Create new node
            Node newNode = new Node(value);

            //New node points (next) to where the current points (next) to
            newNode.next = current.next;

            //New node previous points back to the current node
            newNode.previous = current;

            //Current next node points to new node
            current.next = newNode;

            //Current node + 1 points back (previous) to the new node
            newNode.next.previous = newNode;

            //Increment size of list
            this.size++;
        }
    }

    public void removeNode(int nodeIdx) {

        if (nodeIdx < 0 || nodeIdx > this.size) {
            System.out.println("Please specify a value between 0 and " + this.size);
        } else if (nodeIdx == 0) {
            //Remove node at head, where head pointing to next node becomes head
            this.head = this.head.next;
            this.head.previous = null;
            // Decrement size of list
            this.size--;
        } else {

            //Traverse list to reach node to be removed. Node is nodeIdx -1
            Node current = this.head;
            int i;
            for (i = 0; i < nodeIdx - 1; i++) {
                current = current.next;
            }

            //Current node points to next node + 1, thus removing next node from linked list
            current.next = current.next.next;

            //Decrement size of list
            this.size--;

            //Removing last node then tail needs to be updated to point to the current node
            if (i == this.size - 1) {
                tail = current;
            } else {
                // The next node previous link points back to current node
                current.next.previous = current;
            }

        }
    }

    public int[] printList(){
        Node current = head;
        int[] valuesArray = new int[this.size];
        int idx = 0;

        while (current != null){
            valuesArray[idx] = current.value;
            current = current.next;
            idx++;
        }
        return valuesArray;
    }

    public int getSize(){
        return size;
    }

    public DoubleLinkedList reverse(DoubleLinkedList linkedList){

        DoubleLinkedList reverseList = new DoubleLinkedList(linkedList.head.value);

        Node current = linkedList.head;

        //Traverse list to create nodes to be be inserted at head of the reverse list
        while (current.next != null){
            current = current.next;
            Node newNode = new Node(current.value);

            //New node points (next) to the old head of the reverseList
            newNode.next = reverseList.head;

            //Old head previous node points to new Node (new head)
            reverseList.head.previous = newNode;

            //Head of reverse list becomes the new node
            reverseList.head = newNode;

            //Increment size of reverseList
            reverseList.size++;
        }

        return reverseList;
    }

    public static void main(String[] args) {
        DoubleLinkedList myDoublyLinkedList = new DoubleLinkedList(5);
        myDoublyLinkedList.insertAtEnd(3);
        myDoublyLinkedList.insertAtEnd(4);
        myDoublyLinkedList.insertAtFront(2);
        myDoublyLinkedList.insertAtFront(1);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
        myDoublyLinkedList.removeNode(0);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
        myDoublyLinkedList.insertNodeBefore(2, 200);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
        System.out.println("length: " + myDoublyLinkedList.getSize());

        System.out.println("head value: " + myDoublyLinkedList.head.value);
        System.out.println("head.previous: " + myDoublyLinkedList.head.previous);

        System.out.println("tail value: " + myDoublyLinkedList.tail.value);
        System.out.println("tail.next: " + myDoublyLinkedList.tail.next);
        //reverse
        DoubleLinkedList linkedList2 = myDoublyLinkedList.reverse(myDoublyLinkedList);
        System.out.println("reverse linkedList" + Arrays.toString(linkedList2.printList()));
    }
}
