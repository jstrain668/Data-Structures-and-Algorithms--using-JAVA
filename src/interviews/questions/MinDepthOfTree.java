package interviews.questions;


//Reference: https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfTree {

    TreeNode root = null;
    /**
     * Definition for a binary tree node*/
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

    public class QueueNode{
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode createNode(int val){
         return new TreeNode(val);
    }

    //Description: Traverse the tree via left and right pointers tracking the number of left and right calls from root
    // to leaf node (bottom of the tree). Compare left to right selecting the min size and adding one to include root node.
    //Time Complexity: O(n) visiting all paths to determine min depth.
    //Space Complexity: O(n) for the recursive calls made onto the system stack.
    public int minDepth2(TreeNode root) {

         //Base condition to exit recursive loop
         if (root == null){
             return 0;
         }

         int leftDepth = minDepth2(root.left);
         int rightDepth = minDepth2(root.right);

        if(leftDepth == 0 || rightDepth == 0)
            return 1 + rightDepth + leftDepth;

        return Math.min(leftDepth, rightDepth) + 1;

    }

    //Description: Traverse the tree via left and right pointers tracking the number of left and right calls from root
    // to leaf node (bottom of the tree). Check the exit conditions root is null, root left and right is null and return
    // 0 and 1 respectively. Recursive call left only if the right path is null and right if left path is null, adding
    // one to the depth level. If both left and right are non-null then call call again adding one to depth level.
    // Choose the min size of left and right path.
    //Time Complexity: O(n) visiting all paths to determine min depth. The recursive solution is far from optimal as
    // we might end up traversing the whole tree to find a leaf closest to the root node
    //Space Complexity: O(n) for the recursive calls made onto the system stack.
    public int minDepth1(TreeNode root) {

        //Base condition to exit recursive loop
        if (root == null){
            return 0;
        }

        //No child nodes
        if (root.left == null && root.right == null){
            return 1;
        }

        //Right only path
        if (root.left == null){
            return minDepth1(root.right) + 1;
        }

        //Left only path
        if (root.right == null){
            return minDepth1(root.left) + 1;
        }

        //Left and Right path
        return Math.min(minDepth1(root.left),minDepth1(root.right)) + 1;
    }

    //Description: Instead of applying a a dfs approach which results in visiting all nodes, a better approach is to
    //traverse the tree using BFS instead of DFS. Then the procedure can be terminated upon encountering the first leaf
    //node closest to the root:
    // Time Complexity: O(n)
    // Space Complexity: O(n) for the Queue data structure

    public int minDepth(TreeNode root) {

         //Base case root is null so min depth = 0
         if (root == null){
             return 0;
         }

         // create an empty queue and push the root node with a depth of 1
         Queue<QueueNode> queue = new LinkedList<>();
         QueueNode qNode = new QueueNode(root,1);
         queue.add(qNode);

         while (!queue.isEmpty()){

             qNode = queue.peek();
             TreeNode node = qNode.node;
             queue.poll();

             //The node is a leaf, return the depth of the node
             if (node.left == null && node.right == null){
                 return qNode.depth;
             }

             //The node has left path, add queue node and increment depth
             if (node.left != null){
                 queue.add(new QueueNode(node.left,qNode.depth+1));
             }

             //The node has right path, add queue node and increment depth
             if (node.right != null){
                 queue.add(new QueueNode(node.right, qNode.depth+1));
             }

         }

         return 0;

    }

    public static void main(String[] args) {
        MinDepthOfTree mdot = new MinDepthOfTree();

        TreeNode n1 = mdot.createNode(3);
        TreeNode n2 = mdot.createNode(9);
        TreeNode n3 = mdot.createNode(20);
        TreeNode n4 = mdot.createNode(15);
        TreeNode n5 = mdot.createNode(7);

        mdot.root = n1;
        mdot.root.left = n2;
        mdot.root.right = n3;
        mdot.root.right.left = n4;
        mdot.root.right.right = n5;

        System.out.println("The min depth of tree is: "+mdot.minDepth(mdot.root));


    }
}
