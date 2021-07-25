package interviews.questions.amazon;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    Node head;
    Node tail;

// Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public void setRandom(Node random) {
            this.random = random;
        }
    }

    public Node append(int val){

        Node newNode = new Node(val);

        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        } else{
            this.tail.next = newNode;
            this.tail = newNode;
        }

        return newNode;
    }


    //Description: Create a second list from the original list and store it (in a HashMap) as the values where the keys
    // are the original list. Set the next and randowm pointers of the copy list by retrieving the correspoing values
    // from the key node in the HashMap. Return the head value node from the HashMap
    // Time Complexity: Two loops of O(n) - size of linked list O(n+n) = O(n)
    // Space complexity: O(n) for the hashmap
    public Node copyRandomListUsingHashMap(Node head)

    {
        HashMap<Node,Node> nodesMap = new HashMap();

        if(head == null)
            return null;

        Node first = head;
        while(head != null)
        {
            Node node = new Node(head.val);
            nodesMap.put(head,node);
            head = head.next;
        }

        for(Node originalNode : nodesMap.keySet())
        {
            nodesMap.get(originalNode).next = nodesMap.get(originalNode.next);
            nodesMap.get(originalNode).random = nodesMap.get(originalNode.random);
        }

        return nodesMap.get(first);
    }

    public Node copyRandomListAltHashMap(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node newHead = new Node(head.val);

        map.put(head, newHead);
        Node p = head;
        Node q = newHead;
        map.put(head, newHead);

        p = p.next;
        while (p != null) {   // Create a copy of the original linked list and store it with the original list in a HashMap
            Node temp = new Node(p.val);
            map.put(p, temp);
            q.next = temp;  // Appending temp node to the new list
            q = temp;     // Update q to point to the new node
            p = p.next;  //Move to the next node in the original list
        }

        p = head; // Reset p back to the head of the original list
        q = newHead; // Reset q back to the head of the new list (copy of the original without random ptr set)
        while (p != null) {
            if (p.random != null)
                q.random = map.get(p.random);
            else
                q.random = null;

            p = p.next;
            q = q.next;
        }

        return newHead;
    }


    // Description: Create the copy of node 1 and insert it between node 1 & node 2 in the original Linked List, create
    // a copy of 2 and insert it between 2 & 3. Continue in this fashion, add the copy of N after the Nth node
    // Now copy the random link in the same way. Traverse the list to separate it into its original and copy list
    // Time Complexity: O(n) + O(2n) + O(2n) = O(n)
    // Space Complexity: O(1)
    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        Node curr = head;
        Node temp = null;

        // insert additional node after
        // every node of original list
        while (curr != null) {
            temp = curr.next;

            // Inserting node
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;

        // adjust the random pointers of the
        // newly added nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null)
                        ? curr.random.next
                        : curr.random;

            // move to the next newly added node by
            // skipping an original node
            curr = curr.next.next;
        }

        Node original = head, copy = head.next;

        // save the start of copied linked list
        temp = copy;

        // now separate the original list and copied list
        while (original != null) {
            original.next =original.next.next;

            copy.next = (copy.next != null) ? copy.next.next
                    : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer clwrp = new CopyListWithRandomPointer();

        Node node1 = clwrp.append(7);
        Node node2 = clwrp.append(13);
        Node node3 = clwrp.append(11);
        Node node4 = clwrp.append(10);
        Node node5 = clwrp.append(1);

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        clwrp.copyRandomList(clwrp.head);
      //  clwrp.copyRandomListUsingHashMap(clwrp.head);
    }
}
