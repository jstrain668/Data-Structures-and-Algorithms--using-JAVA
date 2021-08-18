package interviews.questions.amazon;

//Question: https://leetcode.com/problems/binary-tree-maximum-path-sum/

//Reference: https://github.com/awangdev/LintCode/blob/master/Java/124.%20Binary%20Tree%20Maximum%20Path%20Sum.java
//Reference: https://www.educative.io/edpresso/the-algorithm-for-the-maximum-sum-in-a-binary-tree

//The maximum sum in a binary tree is the largest sum that can be found in a path which may start and end at any node
// in the tree.

public class MaxSumPathInBT {

    TreeNode head;
    int globalMax = Integer.MIN_VALUE;

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


    //1. Use recursion to find the maximum sum in the left and right sub-trees.
    //2. Compute the maximum of the following four cases:
    //   - Value of root
    //   - Value of root + left sub-tree
    //   - Value of root + right sub-tree
    //   - Value of root + left + right sub-trees
    //3. If the maximum value (found in step 2) is greater than the global max variable, update the global maximum.
    //4. Return the maximum of the first three cases.
    //The value returned in the last step of the algorithm is the maximum value of only the first three cases
    // (mentioned in step 2). If the fourth case has the maximum value, then the root and its sub-trees are the top of
    // our max sum path (i.e., the root cannot be connected to its parent caller; otherwise, the path would start or end
    // at more than one node).
    public int maxPathSumHelper(TreeNode root) {
        if (root == null)
            return 0;

        // recursive calls:
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        // Max of first three cases:
        int returnMax = Math.max(Math.max(left, right) + root.val, root.val);

        // Max of all four cases:
        int max = Math.max(returnMax, root.val + left + right);

        // Update globalMax:
        if (max > globalMax)
            globalMax = max;

        // Return value to parent caller:
        return returnMax;
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return globalMax;
    }

    public static void main(String[] args) {
        MaxSumPathInBT m = new MaxSumPathInBT();
        m.maxPathSum(m.createBT2());

        System.out.println("Maximum possible sum in a path: " + m.globalMax);
    }
}
