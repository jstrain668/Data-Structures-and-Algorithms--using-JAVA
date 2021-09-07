package interviews.questions.amazon;

//Question: https://leetcode.com/problems/balanced-binary-tree/

//Reference: https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
//Reference: https://www.techiedelight.com/check-given-binary-tree-is-height-balanced-not/
//Book Ref: Cracking Coding Interview - Chapter 4

import java.util.concurrent.atomic.AtomicBoolean;

public class HeightBalancedTree {

    public class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Propagate error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Propagate error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //Solution uses the Integer.MIN_VALUE to flag between recursive calls that the tree is unbalanced when a height
    //difference > 1 is found during processing
    //Time Complexity: O(n)
    //Space Complexity: O(n) recursive calls
    public boolean isHeightBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkHeight(root) != Integer.MIN_VALUE;
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int getHeight(TreeNode root)
    {
        /* base case tree is empty */
        if (root == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    /* Returns true if binary tree with root as root is height-balanced */
    //Time Complexity: Time Complexity: O(n^2) in case of full binary tree.
    //Space Complexity: Same O(n^2) due to the stack space usage for recursive calls.
    public boolean isBalanced(TreeNode node)
    {
        if (node == null){
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
        {
            return true;
        }

        return false;
    }


    public TreeNode buildBinaryTree(){

         /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     /
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        return root;
    }
    public TreeNode addNode(int val){
        return new TreeNode(val);
    }

    public static void main(String[] args) {

        HeightBalancedTree hbt = new HeightBalancedTree();
        TreeNode root = hbt.buildBinaryTree();

        if (hbt.isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

        TreeNode root2 = hbt.buildBinaryTree();

        if (hbt.isHeightBalanced(root2))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

        root2.right.left.right = hbt.addNode(8);

        if (hbt.isHeightBalanced(root2))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
