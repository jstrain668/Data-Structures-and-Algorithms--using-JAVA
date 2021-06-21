package interviews.questions;


import java.util.ArrayList;
import java.util.Arrays;

public class BSTInsert {

    Node root;

    public class Node {
        Node left, right;
        int val;

        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    // BST organizes its tree by inserting nodes to the left or right of the root node, where new nodes
    // become leaf nodes to its parent. Node is created in left subtree if its value is less than its parent
    // to the right if greater than.
    // Traverse to the leaf node to find appropriate location to create node
    // Time Complexity: O(n) is worst case if array of numbers is sorted otherwise its the height of the
    // tree
    // Space Complexity O(n)
    public void insertIterative(int value){
        // Create root node if null
       if (this.root == null){
           this.root = new Node(value);
           return;
       }

       //Start traversing from root node
       Node current = root;

       //Store the parent of the current node. Initially this is null
       Node parent = null;

       //Traverse until reach the leaf node which will be the parent of the new Node
       while (current != null){

           parent = current;
           if (value < current.val){
               current = current.left;
           } else {
               current = current.right;
           }
       }

       //Create a new node in left or right subtree
       if (value < parent.val){
           parent.left = new Node(value);
       } else {
           parent.right = new Node(value);
       }
    }

    // Traverse the BST in order, by visiting smallest, then next smallest value and so on until largest
    // value is reached. Recursive calls are made until the leaf node of the left subtree is reached then
    // right subtree is traversed to its leaf node and so on until all nodes are visited in left to right

    public ArrayList<Integer> inOrder(Node root, ArrayList<Integer> output){

        //Base condition for exiting recursive method
        if (root == null){
            return output;
        }

        //Keep going left until null
        inOrder(root.left,output);

        output.add(root.val);

        //Keep going right until null
        inOrder(root.right,output);

        return output;
    }

    public Node insertRecursive(Node root,int value){

        if (root == null){
            return new Node(value);
        }

        if (value < root.val){
            root.left = insertRecursive(root.left, value);
        } else {
            root.right = insertRecursive(root.right,value);
        }

        return root;
    }

    public static void main(String[] args)
    {
        BSTInsert bstInsert = new BSTInsert();
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        System.out.println("Source int array: "+ Arrays.toString(keys));

        for (int value: keys) {
            bstInsert.insertIterative(value);
            //bstInsert.root = bstInsert.insertRecursive(bstInsert.root,value);
        }

        ArrayList<Integer> output = new ArrayList<>();
        output = bstInsert.inOrder(bstInsert.root,output);
        System.out.println("Output arraylist: "+output);
    }
}
