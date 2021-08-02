package interviews.questions.amazon;

import java.util.*;

//Reference: https://www.geeksforgeeks.org/iterative-boundary-traversal-of-complete-binary-tree/

public class BoundaryOfCompleteBinTree {

    public class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }

    // Function to print the nodes of a complete
// binary tree in boundary traversal order
    public void boundaryTraversal(Node root)
    {
        if (root != null) {

            // If there is only 1 node print it
            // and return
            if ((root.left == null) && (root.right == null)) {
                System.out.print(root.data +"\n");
                return;
            }

            // List to store order of traversed
            // nodes
            List<Node> list = new ArrayList<>();
            list.add(root);

            // Traverse left boundary without root
            // and last node
            Node L = root.left;
            while (L.left != null) {
                list.add(L);
                L = L.left;
            }

            // BFS designed to only include leaf nodes
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node temp = q.peek();
                q.remove();
                if ((temp.left == null) && (temp.right == null)) {
                    list.add(temp);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            // Traverse right boundary without root
            // and last node
            List<Node> list_r = new ArrayList<>();
            Node R = root.right;
            while (R.right != null) {
                list_r.add(R);
                R = R.right;
            }

            // Reversing the order
            Collections.reverse(list_r);

            // Concatenating the two lists
            list.addAll(list_r);

            // Printing the node's data from the list
            for (Node i : list) {
                System.out.print(i.data + " ");
            }
            System.out.println();
            return;
        }
    }


    public Node createCompleteBinTree(){
        // Root node of the tree
        Node root = new Node(18);

        root.left = new Node(15);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(100);
        root.right.right = new Node(20);

        return root;
    }

    public static void main(String[] args) {
        BoundaryOfCompleteBinTree bocbt = new BoundaryOfCompleteBinTree();

        Node root = bocbt.createCompleteBinTree();
        bocbt.boundaryTraversal(root);

    }
}
