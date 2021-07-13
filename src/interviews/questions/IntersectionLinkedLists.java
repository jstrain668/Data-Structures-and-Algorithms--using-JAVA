package interviews.questions;

//Reference: https://leetcode.com/problems/intersection-of-two-linked-lists/

import java.util.HashSet;

public class  IntersectionLinkedLists {

    ListNode head;
    ListNode tail;
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public IntersectionLinkedLists(){
        this.head = null;
        this.tail = null;
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

    public void appendNodes(ListNode head){

        ListNode current = head;

        while (current != null){
            this.tail.next = current;
            this.tail = current;
            current = current.next;
        }
    }

    public int length(ListNode head)
    {
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        return len;

    }

    //Description: The goal is to advance the head of the list which has a bigger size to a node which
    // has the same number of nodes as the smaller list. From this point compare both nodes until match
    // found or no match found after both lists processed.
    // The length of each list is retrieved and whoever has the bigger size has their head node
    // advanced by the difference of the list sizes.
    // Time Complexity: O(len(listA) + len(listB) + diff(lista,listb) + minLen(listA,listB)) = O(n)
    // Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        int len1=length(headA);
        int len2=length(headB);

        if(len1>len2)
        {
            for(int i=0;i<len1-len2;i++)
            {
                headA=headA.next;
            }
        }
        else
        {
            for(int i=0;i<len2-len1;i++)
            {
                headB=headB.next;
            }
        }

        while(headA!=null && headB!=null)
        {
            if(headA==headB)
            {
                return headA;
            }
            else
            {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }

    // Description: Store all nodes from listA in a HashSet. Check each node in listB to
    // determine it exists in HashSet. If it exists return the ListNode otherwise return null
    // Time Complexity O(listA size + listB size) = O(a+b=n)
    // Space Complexity O(listA size) = O(a)
    public ListNode getIntersectionNodeHashSet(ListNode headA, ListNode headB){

        if (headA == null || headB == null){
            return null;
        }

        HashSet<ListNode> hSet = new HashSet<>();

        while (headA != null){
            hSet.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (hSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionLinkedLists ill1 = new IntersectionLinkedLists();
        IntersectionLinkedLists ill2 = new IntersectionLinkedLists();
        IntersectionLinkedLists ill3 = new IntersectionLinkedLists();
        int[] listA = {4,1};
        int[] listB = {5,6,1};
        int[] listC = {8,4,5};

        for (int i=0; i < listA.length; i++){
            ill1.append(listA[i]);
        }

        for (int i=0; i < listB.length; i++){
            ill2.append(listB[i]);
        }

        for (int i=0; i < listB.length; i++){
            ill3.append(listC[i]);
        }
        ill1.appendNodes(ill3.head);
        ill2.appendNodes(ill3.head);

        System.out.println("Intersection node: "+ill1.getIntersectionNode(ill1.head,ill2.head).val);
        System.out.println("Intersection node: "+ill1.getIntersectionNodeHashSet(ill1.head,ill2.head).val);
    }
}
