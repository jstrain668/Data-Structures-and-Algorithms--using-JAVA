package interviews.questions;

import java.util.Stack;

public class PalindromeLinkedList {

    ListNode head;
    ListNode tail;
    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
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

    //Description: to solve push all the nodes onto a stack and then traverse from head again popping
    // each node and checking the popped node value against the current value.
    // Time Complexity: O(n+n)
    // Space Complexity: O(n)
    public boolean isPalindrome(ListNode head){

        //Empty list
        if (head == null){
            return false;
        }

        //One node list
        if (head.next == null){
            return true;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null){
            stack.add(current);
            current = current.next;
        }

        current = head;
        while (current != null){
            if (stack.pop().val != current.val){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        int[] nums = {1,2,2,1};
        int[] nums1 = {1,2};

        for (int i=0; i < nums1.length; i++){
            pll.append(nums1[i]);
        }

        System.out.println("Is LinkedList a palindrome: "+pll.isPalindrome(pll.head));

    }
}
