package interviews.questions;

import java.util.ArrayList;
import java.util.List;

//Reference: https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

    private ListNode head;
    private ListNode tail;

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }

    }

    public void insertAtFront(int value){

        if (this.head == null){
            this.head = new ListNode(value);
            this.tail = this.head;
        } else {
            //Create new node with specified value
            ListNode newNode = new ListNode(value);

            //New node points to (next) old head
            newNode.next = head;

            //New node becomes head
            this.head = newNode;
        }
    }

    public void insertAtEnd(int value){

        if (this.head == null){
            this.head = new ListNode(value);
            this.tail = this.head;
        } else {
            //Create new node with specified value
            ListNode newNode = new ListNode(value);

            //Old tail points to newNode via next pointer
            this.tail.next = newNode;

            //New node becomes tail
            this.tail = newNode;
        }
    }

    public ListNode getHead(){
        return this.head;
    }

    public ListNode getTail(){
        return this.tail;
    }

    // Description: Given the head node of a singly linked list, reverse the list and return the
    // head of the reversed singly linked list. Use current which points to head of list to traverse
    // the list. Next points to the next node on the list and prev the previous node in the list. As each
    // node is traversed it becomes the head until the lst node is processed which becomes the head
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode reverseList(ListNode head){

        if (head == null)
            throw new IllegalArgumentException("Head of list cannot be null");

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return head = prev;
    }

    public List printList(ListNode head){

        ListNode current = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = 0;

        while (current != null){
            arrayList.add(index,current.val);
            current = current.next;
            index++;
        }
        return arrayList;
    }

    public ListNode recursiveReverseList(ListNode head){

        //Null list passed in
        if (head == null)
            return head;

        //List with one node or reached end of list
        if (head.next == null)
            return head;

        ListNode newHeadNode = recursiveReverseList(head.next);

        // Change references for middle chain
        head.next.next = head;
        head.next = null;

        return newHeadNode;
    }

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        rll.insertAtFront(1);
        rll.insertAtEnd(2);
        rll.insertAtEnd(3);
        rll.insertAtEnd(4);
        rll.insertAtEnd(5);
        System.out.println("Original list: "+rll.printList(rll.getHead()).toString());
        ListNode reverseHeadNode = rll.reverseList(rll.getHead());
        System.out.println("Reversed list: "+rll.printList(reverseHeadNode).toString());
        ListNode originalHeadNode = rll.recursiveReverseList(reverseHeadNode);
        System.out.println("Original list: "+rll.printList(originalHeadNode).toString());
    }
}
