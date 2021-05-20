package homework.linkedlists;

import java.util.Arrays;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node (int value){
            this.value = value;
            this.next = null;
        }
    }

    // Create a new linked list with one node
    public SingleLinkedList(int value){

        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void insertAtFront(int value){

        //Create new node with specified value
        Node newNode = new Node(value);

        //New node points to (next) old head
        newNode.next = head;

        //New node becomes head
        this.head = newNode;

        //Increment size of list
        this.length++;
    }

    public void insertAtEnd(int value){

        //Create new node with specified value
        Node newNode = new Node(value);

        //Old tail (tail.next) points to new tail (newNode)
        this.tail.next = newNode;

        //Tail becomes new node
        this.tail = newNode;

        //Increment size of list
        this.length++;
    }

    public void insertNodeBefore(int nodeIdx,int value){

        if (nodeIdx < 0 || nodeIdx > this.length){
            System.out.println("Please specify a value between 0 and "+this.length);
        } else if (nodeIdx == 0) {
            //Insert at front
            this.insertAtFront(value);
        } else if (nodeIdx == this.length) {
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

            //Current node points (next) to new node
            current.next = newNode;

            //Increment size of list
            this.length++;
        }
    }

    public void removeNode(int nodeIdx){

        if (nodeIdx < 0 || nodeIdx > this.length){
            System.out.println("Please specify a value between 0 and "+this.length);
        } else if (nodeIdx == 0) {
            //Remove node at head, where head pointing to next node becomes head
            this.head = this.head.next;
            // Decrement size of list
            this.length--;
        } else {

            //Traverse list to reach node to be removed. Node is nodeIdx -1
            Node current = this.head;
            int i;
            for (i = 0; i < nodeIdx -1; i++){
                current = current.next;
            }

            //Current node points to next node + 1, thus removing next node from linked list
            current.next = current.next.next;

            //Decrement size of list
            this.length--;

            //Removing last node then tail needs to be updated to point to the current node
            if (i == this.length - 1){
                tail = current;
            }

        }
    }

    public int getSize(){
        return this.length;
    }

    public int[] printList(){

        Node current = head;
        int[] valuesArray = new int[this.length];
        int idx = 0;

        while (current != null){
            valuesArray[idx] = current.value;
            current = current.next;
            idx++;
        }
        return valuesArray;
    }

    public SingleLinkedList reverse(SingleLinkedList linkedList){

        SingleLinkedList reverseList = new SingleLinkedList(linkedList.head.value);

        Node current = linkedList.head;

        //Traverse list to create nodes to be be inserted at head of the reverse list
        while (current.next != null){
            current = current.next;
            Node newNode = new Node(current.value);

            //New node points (next) to the old head of the reverseList
            newNode.next = reverseList.head;

            //Head of reverse list becomes the new node
            reverseList.head = newNode;

            //Increment size of reverseList
            reverseList.length++;
        }

        return reverseList;
    }


    public static void main(String[] args) {
        SingleLinkedList myLinkedList = new SingleLinkedList(10);
        //insert at end of list
        myLinkedList.insertAtEnd(12);
        myLinkedList.insertAtEnd(16);
        //insert at front of list
        myLinkedList.insertAtFront(20);
        myLinkedList.insertAtFront(50);
        System.out.println("Size: " + myLinkedList.getSize());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //insert after node
        myLinkedList.insertNodeBefore(3, 25);
        System.out.println("length: " + myLinkedList.getSize());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //remove node index
        myLinkedList.removeNode(3);
        System.out.println("length: " + myLinkedList.getSize());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //reverse
        SingleLinkedList linkedList2 = myLinkedList.reverse(myLinkedList);
        System.out.println("reverse linkedList" + Arrays.toString(linkedList2.printList()));
    }
}
