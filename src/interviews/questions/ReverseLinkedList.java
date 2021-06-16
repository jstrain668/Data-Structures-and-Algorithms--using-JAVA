package interviews.questions;

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

            //New node points to (next) old head
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

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        rll.insertAtFront(1);
        rll.insertAtEnd(2);
        rll.insertAtEnd(3);
        rll.insertAtEnd(4);
        rll.insertAtEnd(5);
        ListNode node = rll.reverseList(rll.getHead());
    }
}
