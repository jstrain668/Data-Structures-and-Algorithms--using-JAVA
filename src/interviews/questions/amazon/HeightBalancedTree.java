package interviews.questions.amazon;

//Question: https://leetcode.com/problems/balanced-binary-tree/

//Reference: https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/

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

    /* Returns true if binary tree with root as root is height-balanced */
    public boolean isBalanced(TreeNode node)
    {
        if (node == null){
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
        {
            return true;
        }

        return false;
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int height(TreeNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left),height(node.right));
    }


    public TreeNode buildBinaryTree(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);

        return root;
    }

    public static void main(String[] args) {

        HeightBalancedTree hbt = new HeightBalancedTree();
        TreeNode root = hbt.buildBinaryTree();

        if (hbt.isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
