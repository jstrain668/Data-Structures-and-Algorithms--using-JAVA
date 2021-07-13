package interviews.questions;

import java.util.Stack;

//Reference: https://leetcode.com/problems/palindrome-linked-list/

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

    public ListNode reverse(ListNode head){

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public int getLinkedListSize(ListNode head){
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    //Description: Get Length of LL and reverse first half of the list(prev). The cur ptr is now pointing to the
    //second half of the list. Traverse second half of the the list and compare values against reverse first half of
    //the list. If values match return true otherwise false.
    //Time Complexity: O(n) = O(n) for traversing LL to get size + O(n/2) + O(n/2)
    //Space Complexity: O(1)
    public boolean isPalindrome2(ListNode head) {

        //Empty list
        if (head == null) {
            return false;
        }

        //One node list
        if (head.next == null) {
            return true;
        }

        int size = getLinkedListSize(head);

        int half = size/2;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        for(int i=1; i<=half; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }

        if (size % 2 == 1){
            cur = next;
        }

        for(int i=1; i<=half; i++) {
            if (pre.val != cur.val){
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return true;
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

        for (int i=0; i < nums.length; i++){
            pll.append(nums[i]);
        }

        System.out.println("Is LinkedList a palindrome: "+pll.isPalindrome(pll.head));
        System.out.println("Is LinkedList a palindrome: "+pll.isPalindrome2(pll.head));

    }
}
