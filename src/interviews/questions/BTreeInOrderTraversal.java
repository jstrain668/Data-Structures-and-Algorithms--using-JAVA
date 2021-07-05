package interviews.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Reference: https://leetcode.com/problems/binary-tree-inorder-traversal/

public class BTreeInOrderTraversal {

    TreeNode root = null;
    /** Definition for a binary tree node. **/
    public class TreeNode {
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

    public TreeNode createNode(int val){

        TreeNode newNode = new TreeNode(val);

        if (this.root == null){
            this.root = newNode;
        }

        return newNode;
    }

    //Description: Inorder recursive traversal of the tree.
    //Time complexity : O(n). The time complexity is O(n) because the recursive function is
    // T(n) = 2⋅T(n/2)+1.
    // Space Complexity = O(n)
    public List<Integer> inOrder(TreeNode root, List<Integer> resultArray){

        if (root == null){
            return resultArray;
        }

        inOrder(root.left,resultArray);

        resultArray.add(root.val);

        inOrder(root.right,resultArray);

        return resultArray;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultArray = new ArrayList<>();

        return resultArray = inOrder(root,resultArray);
    }

    public static void main(String[] args) {
        BTreeInOrderTraversal btInOrderTraversal = new BTreeInOrderTraversal();
        btInOrderTraversal.createNode(1);
        btInOrderTraversal.root.right = btInOrderTraversal.createNode(2);
        btInOrderTraversal.root.right.left = btInOrderTraversal.createNode(3);
        List<Integer> output = btInOrderTraversal.inorderTraversal(btInOrderTraversal.root);

        Iterator itr = output.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
