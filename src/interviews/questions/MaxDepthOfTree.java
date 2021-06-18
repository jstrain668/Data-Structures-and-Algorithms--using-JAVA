package interviews.questions;

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

    // Description: Recursively traverse left and right tree to record depth level. Traverse subtrees until leaf
    // node (null) is reached. Repeat until all subtrees are traversed the depth of left and right subtrees
    // from root.
    // Time Complexity: O(n) - traverse all nodes to find the deepest path
    // Space Complexity: O(1) - variables to record left and right depths
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

    public static void main(String[] args) {
        MaxDepthOfTree mdt = new MaxDepthOfTree();
        mdt.insert(3);
        mdt.insert(9);
        mdt.insert(20);
        mdt.insert(15);
        mdt.insert(7);
        System.out.println("Max depth of tree is: "+mdt.maxDepth(mdt.root));
    }
}
