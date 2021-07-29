package interviews.questions;

import java.util.LinkedList;
import java.util.Queue;

// Reference: https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfTree {

    private TreeNode root = null;

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public void insert(int value){

        TreeNode newNode = new TreeNode(value);

        if (root == null){
            root = newNode;
            return;
        }

        TreeNode current = root;
        while (true){

            if (value < current.val){ // Go left as value is less than current value

                if (current.left != null){ // Go further down the tree to the left
                    current = current.left;
                } else { // Insert node
                    current.left = newNode;
                    break;
                }
            } else if (value > current.val){ // Go right as value is greater than current value

                if (current.right != null){ // Go further down the tree to the right
                    current = current.right;
                } else { // Insert node
                    current.right = newNode;
                    break;
                }
            } else { // Duplicate values not allowed in binary tree
                break;
            }
        }
    }

    // Description: The idea is to traverse the tree in a postorder fashion and calculate the height of the left and
    // right subtree. The height of a subtree rooted at any node will be one more than the maximum height of its left
    // and right subtree. Recursively apply this property to all tree nodes in a bottom-up manner (postorder fashion)
    // and return the subtree max height rooted at that node.
    // Time Complexity: O(n) - traverse all nodes to find the deepest path
    // Space Complexity: O(n) - the space cost incurred on the stack size because of recursion calls.
    // https://www.educative.io/edpresso/finding-the-maximum-depth-of-a-binary-tree

    public int maxDepth(TreeNode root){

        //Exit condition
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // choose the deeper path and add root to it
        if (leftDepth < rightDepth)
            return rightDepth + 1;
        else
            return  leftDepth + 1;
    }

    public int maxDepthIterative(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depthLevel = 0;

        while (!queue.isEmpty()){

            depthLevel++;
            for (int i=0; i < queue.size(); i++){
                TreeNode node = queue.peek();

                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }

                queue.poll();
            }

        }

        return depthLevel;
    }


    // Description: Using BFS (iterative) to perform level order traversal of the tree. At the end of the
    // traversal both left and right pointers are null return depth value
    // Use Queue, each level node(s) are added and previous removed. With each iteration the depth level
    // is incremented until no more nodes, the queue is empty.
    // Time Complexity: O(n) Visit each node to reach the bottom (leaf nodes)
    // Space Complexity: O(n) for the queue
    // Reference: https://medium.com/@harycane/maximum-depth-of-a-binary-tree-609d129fa571
    public int maxDepthBFS(TreeNode root){

        if (root == null){
            return 0;
        }

        int depthLevel = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int level = queue.size();
            depthLevel++;
            for (int i=0; i < level; i++){
                if (queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                queue.poll();
            }
        }
        return depthLevel;
    }

    public static void main(String[] args) {
        MaxDepthOfTree mdt = new MaxDepthOfTree();
        mdt.insert(3);
        mdt.insert(9);
        mdt.insert(20);
        mdt.insert(15);
        mdt.insert(7);
        System.out.println("Max depth of tree is: "+mdt.maxDepth(mdt.root));
        System.out.println("Max depth of tree is: "+mdt.maxDepthBFS(mdt.root));
    }
}
