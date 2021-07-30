package interviews.questions;

import java.util.ArrayList;
import java.util.List;

//Reference: https://leetcode.com/problems/validate-binary-search-tree/

public class ValidBinarySearchTree {

    TreeNode prev;
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

    public void inOrderBST(TreeNode root,List<Integer> values){

        if (root == null){
            return;
        }

        inOrderBST(root.left,values);

        values.add(root.val);

        inOrderBST(root.right,values);

    }

    public boolean isSorted(List<Integer> values){

        for (int i=1; i < values.size(); i++){
            if (values.get(i-1) >= values.get(i)){
                return false;
            }
        }
        return true;
    }


    //Description: A way to determine a BST is valid is if an inorder traversal of the BST produces a sorted array in
    //ascending order. If its sorted correctly then valid BST
    //Time Complexity: O(n) where n is all the nodes in the BST
    //Space Complexity: O(n) for the ArrayList plus O(n) for the system calls (recursive calls) equals O(2n) but drop
    // the constant to give O(n)
    public boolean isValidBST(TreeNode root) {

        if (root == null){
            return true;
        }

        List<Integer> values = new ArrayList<>();

        inOrderBST(root,values);

        return isSorted(values);
    }


    //Description: In order traversal using a prev pointer to track parent node to compare current value is less than
    // or equal to parent node value (prev)
    //Time Complexity: O(n)
    // Space Complexity: O(n) for the recursive calls
    /* Returns true if given search tree is binary
      search tree (efficient version) */
    public boolean isBST(TreeNode node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.val <= prev.val ){
                return false;
            }

            prev = node;
            return isBST(node.right);
        }

        return true;
    }

    public static void main(String[] args) {
        ValidBinarySearchTree vbst = new ValidBinarySearchTree();

        TreeNode root = vbst.createNode(5);
        root.left = vbst.createNode(1);
        root.right = vbst.createNode(4);

        if (vbst.isValidBST(root)){
            System.out.println("BST is valid");
        } else {
            System.out.println("BST is not valid");
        }

        if (vbst.isBST(root)){
            System.out.println("BST is valid");
        } else {
            System.out.println("BST is not valid");
        }

    }
}
