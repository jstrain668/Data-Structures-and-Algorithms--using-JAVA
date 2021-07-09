package interviews.questions;


import java.util.LinkedList;
import java.util.Queue;

//Reference: https://leetcode.com/problems/symmetric-tree/

public class BSTSymmetric {

    /**
     * Definition for a binary tree node.
     **/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
        }
    }

    // Function to check if subtree rooted at `t1` and `t2` mirror each other
    public boolean isMirror(TreeNode t1, TreeNode t2)
    {
        // base case: if both trees are empty
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        // return true if
        // 1. Both nodes have same value
        // 2. The left subtree is the mirror of the right subtree, and
        // 3. The right subtree is the mirror of the left subtree
        return (t1.val == t2.val) &&
                isMirror(t1.left, t2.right) &&
                isMirror(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root){

        if (root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    //Description: with the aid of a queue. Each two consecutive nodes in the queue should be equal,
    // and their subtrees a mirror of each other. Initially, the queue contains root.left and root.right
    // Then the algorithm works similarly to BFS, with some key differences. Each time, two nodes are
    // extracted and their values compared. Then, the right and left children of the two nodes are
    // inserted in the queue in opposite order. The algorithm is done when either the queue is empty,
    // or we detect that the tree is not symmetric (i.e. we pull out two consecutive nodes from the
    // queue that are unequal).
    // Time Complexity: O(n). Because we traverse the entire input tree once, the total run time is
    // O(n), where n is the total number of nodes in the tree.
    // Space Complexity: O(n). There is additional space required for the search queue. In the worst case,
    // we have to insert O(n)O(n) nodes in the queue. Therefore, space complexity is O(n)O(n).
    public boolean isSymmetricWithQueue(TreeNode root){

        if (root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null){
                continue;
            }

            if (t1 == null || t2 == null){
                return false;
            }

            if (t1.val != t2.val){
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        BSTSymmetric bstSymmetric = new BSTSymmetric();

        if (bstSymmetric.isSymmetric(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }

        if (bstSymmetric.isSymmetricWithQueue(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }
    }
}
