package interviews.questions;

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
    }
}
