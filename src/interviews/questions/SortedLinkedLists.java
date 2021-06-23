package interviews.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortedLinkedLists {

    ListNode head;
    ListNode tail;

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void insert(int value){

        ListNode newNode = new ListNode(value);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public ListNode buildList(int[] nums){

        if (nums == null || nums.length == 0){
            return null;
        }

        for(int i=0; i < nums.length; i++){
            insert(nums[i]);
        }

        return this.head;
    }

    // https://www.educative.io/m/merge-two-sorted-linked-lists
    // Since both lists are sorted. Resolve the head of the merged list by determining
    // which head value of each list is less than or equal to the other. Tail also points to
    // to the head initially. Traverse both lists until one of the lists is processed. Nodes
    // are added to merged list in ascending order. The remaining nodes in the list not
    // fully traversed are appended to the merged list.
    // Time Complexity O(n)
    // Space Complexity O(1) - not creating new list, re-arranging existing lists into
    // a merged list
    public ListNode mergeTwoLists(ListNode slh1, ListNode slh2){

        // if both lists are empty then merged list is also empty
        if (slh1 == null && slh2 == null){
            return null;
        }

        // if one of the lists is empty then other is the merged list
        if (slh1 == null) {
            return slh2;
        } else if (slh2 == null) {
            return slh1;
        }

        // Resolve the head of to be merged and sorted list
        ListNode mergedHead = null;
        if (slh1.val <= slh2.val) {
            mergedHead = slh1;
            slh1 = slh1.next;
        } else {
            mergedHead = slh2;
            slh2 = slh2.next;
        }

        //Tail also points to head at the beginning of a new linked list
        ListNode mergedTail = mergedHead;

        //Resolve the rest of the merged list. Both lists are processed until there are no more
        //nodes to be processed in of the lists.

        while (slh1 != null && slh2 != null){

            ListNode temp = null;
            if(slh1.val <= slh2.val){
                temp = slh1;
                slh1 = slh1.next;
            } else {
                temp = slh2;
                slh2 = slh2.next;
            }

            mergedTail.next = temp;
            mergedTail = temp;
        }

        //Append the remaining nodes of the list to the merged list
        if (slh1 != null) {
            mergedTail.next = slh1;
        } else if (slh2 != null) {
            mergedTail.next = slh2;
        }

        return mergedHead;
    }

    public List convertToArrayList(ListNode head){

        ListNode current = head;
        List<Integer> sList = new ArrayList<>();

        while(current != null){
            sList.add(current.val);
            current = current.next;
        }
        return sList;
    }

    public void printSortedLinkedList(ListNode head){

        List<Integer> sList = convertToArrayList(head);

        //Using list iterator
        Iterator litr = sList.listIterator();

        while(litr.hasNext()){
            System.out.println(litr.next());
        }
    }

    public static void main(String[] args) {
        SortedLinkedLists sll1 = new SortedLinkedLists();
        int[] nums1 = new int[] {1,2,4};
        ListNode sortedListHead1 = sll1.buildList(nums1);

        SortedLinkedLists sll2 = new SortedLinkedLists();
        int[] nums2 = new int[] {1,3,4};
        ListNode sortedListHead2 = sll2.buildList(nums2);

        ListNode mergedListHead = sll1.mergeTwoLists(sortedListHead1, sortedListHead2);
        sll1.printSortedLinkedList(mergedListHead);

    }
}
