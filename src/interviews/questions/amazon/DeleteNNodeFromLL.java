package interviews.questions.amazon;

//Question: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

//Solution: Calculate the size of the linked list. Calculate which node in the list to be deleted = size - n + 1.
//if the node to be deleted is the head then reset head to the next node or null if only one node in the list. Locate
// the prev node to the node to be deleted. Set the prev node next node to the next->next node of the prev node.
//Time Complexity: O(n) for determining size of list and possibly another O(n) for locating the node to be deleted
//Space Complexity: O(1)

public class DeleteNNodeFromLL {

    ListNode head;
    ListNode tail;

    public class ListNode{
        ListNode next;
        int val;
        public ListNode(int val){
            this.val = val;
        }
    }

    public void append(int val){

        ListNode newNode = new ListNode(val);

        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void createLinkedList(){
        append(5);
        append(10);
        append(15);
        append(20);
        append(25);
        append(30);
        append(35);
        append(40);
    }

    public void createLinkedList2(){
        append(1);
        append(2);
        append(3);
        append(4);
        append(5);
    }

    public void createLinkedList3(){
        append(1);
    }

    public void createLinkedList4(){
        append(1);
        append(2);
    }

    public ListNode getPreviousNode(ListNode head,int n){

        if (head == null){
            return null;
        }

        ListNode current = head;

        // move `n` nodes ahead in the linked list
        for (int i=1; current !=null && i < n; i++){
            current = current.next;
        }

        return current;
    }

    private int getSize(ListNode head){

        int count = 0;
        ListNode current = head;

        while (current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){
            return null;
        }

        int size = getSize(head);

        // return if `n` is more than the total number of nodes in the list
        if (n > size){
            return null;
        }

        ListNode prevNode = null;
        int pos = size - n + 1;

        if (pos == 1){
            head = head.next;
        } else {
            prevNode = getPreviousNode(head,pos-1);
            prevNode.next = prevNode.next.next;
        }

        return head;
    }

    public void printList(ListNode root){

        while (root != null){
            System.out.print(root.val + ", ");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteNNodeFromLL delNode = new DeleteNNodeFromLL();
        delNode.createLinkedList4();
        ListNode start = delNode.removeNthFromEnd(delNode.head,2);
        delNode.printList(start);

    }
}
