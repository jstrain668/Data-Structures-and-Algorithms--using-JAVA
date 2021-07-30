package interviews.questions;

//Reference https://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not-iterative-approach/?ref=rp
//Reference: https://leetcode.com/problems/check-completeness-of-a-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class FullBinaryTree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createNode(int val){
        return new TreeNode(val);
    }

    //Full binary tree, a node has no child nodes or 2 child nodes.
    //Time Complexity: O(n)
    //Space Complexity: O(max) where max is the max number of nodes at a particular level.
    public boolean isFullBinaryTree(TreeNode root) {
        // if tree is empty
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.peek();
            queue.poll();

            if (current.left == null && current.right == null){
                continue;
            }

            if (current.left == null || current.right == null){
                return false;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return true;
    }

    public static void main(String[] args) {
        FullBinaryTree fbt = new FullBinaryTree();

        TreeNode root = fbt.createNode(1);
        root.left = fbt.createNode(2);
        root.right = fbt.createNode(3);
        root.left.left = fbt.createNode(4);
        root.left.right = fbt.createNode(5);

        if (fbt.isFullBinaryTree(root))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

}
