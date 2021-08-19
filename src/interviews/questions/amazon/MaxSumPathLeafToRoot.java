package interviews.questions.amazon;

//Question: Given a binary tree, write an efficient algorithm to find the maximum sum root-to-leaf path, i.e.,
// the maximum sum path from the root node to any leaf node in it.

//The problem can be divided further into two sub problems
//1. Calculate the maximum sum from the root node to any leaf node in a binary tree
//2. Print root-to-leaf path having maximum sum in a binary tree
//solve both problems in linear time by traversing the tree in a bottom-up manner - postorder traversal

//Reference: https://www.techiedelight.com/find-maximum-sum-root-to-leaf-path-binary-tree/
//Reference: https://tutorialspoint.dev/data-structure/binary-tree-data-structure/find-the-maximum-sum-path-in-a-binary-tree


public class MaxSumPathLeafToRoot {

    TreeNode head;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode createBT2(){
        this.head = new TreeNode(-3);

        return this.head;
    }

    public TreeNode createBT(){
		/*
		        3
		       / \
		      2   20
		     /   /  \
		    7   5   -8

		*/
        this.head = new TreeNode(3);

        // Creating 2nd level:
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(20);
        this.head.left = one;
        this.head.right = two;

        // Creating 3rd level:
        TreeNode three = new TreeNode(7);
        TreeNode four = new TreeNode(5);
        TreeNode five = new TreeNode(-8);
        one.left = three;
        two.left = four;
        two.right = five;

        return this.head;
    }

    public TreeNode createBT4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(10);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);
        root.right.right.right = new TreeNode(5);

        return this.head = root;
    }

    public TreeNode createBT3(){
        this.head = new TreeNode(-5);

        // Creating 2nd level:
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(3);

        this.head.left = one;
        this.head.right = two;
        return this.head;
    }

    // Function to print the root-to-leaf path with a given sum in a binary tree
    public boolean printPath (TreeNode root, int sum)
    {
        // base case
        if (sum == 0) {
            return true;
        }

        // base case
        if (root == null) {
            return false;
        }

        // recur for the left and right subtree with reduced sum
        boolean left = printPath(root.left, sum - root.val);
        boolean right = printPath(root.right, sum - root.val);

        // print the current node if it lies on a path with a given sum
        if (left || right) {
            System.out.print(root.val + " ");
        }

        return left || right;
    }

    // Function to calculate the maximum root-to-leaf sum in a binary tree
    public int getRootToLeafSum(TreeNode root)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }

        // calculate the maximum node-to-leaf sum for the left child
        int left = getRootToLeafSum(root.left);

        // calculate the maximum node-to-leaf sum for the right child
        int right = getRootToLeafSum(root.right);

        // consider the maximum sum child
        return (left > right? left : right) + root.val;
    }


    //The time complexity of the above solution is O(n) and requires O(n) extra space (system stack - recursive calls)
    // where n is the number of nodes in the binary tree
    // Function to print maximum sum root-to-leaf path in a given binary tree
    public void findMaxSumPath(TreeNode root)
    {
        int sum = getRootToLeafSum(root);
        System.out.println("The maximum sum is " + sum);
        System.out.print("The maximum sum path is ");

        printPath(root, sum);
    }

    public static void main(String[] args) {

        MaxSumPathLeafToRoot m = new MaxSumPathLeafToRoot();
        m.findMaxSumPath(m.createBT3());
    }
}
