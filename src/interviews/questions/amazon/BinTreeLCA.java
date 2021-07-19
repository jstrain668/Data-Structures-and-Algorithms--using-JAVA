package interviews.questions.amazon;

// Reference: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class BinTreeLCA {

    TreeNode head;
    /**
      Definition for a binary tree node.
     */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public void setHead(int val){

        if (this.head == null){
            TreeNode newNode = new TreeNode(val);
            this.head = newNode;
        } else {
            this.head.val = val;
        }
    }

    public TreeNode append(int val){
        return new TreeNode(val);
    }

    public TreeNode recurLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) {
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null){
            return root;
        }
        return (left != null) ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root,p.val,q.val);
    }


    // Alg: The idea is to traverse the tree starting from the root. If any of the given keys (n1 and n2) matches with
    // the root, then the root is LCA (assuming that both keys are present). If the root doesn’t match with any of the
    // keys, we recur for the left and right subtree. The node which has one key present in its left subtree and the
    // other key present in the right subtree is the LCA. If both keys lie in the left subtree, then the left subtree
    // has LCA also, otherwise, LCA lies in the right subtree.
    // Time Complexity: The time complexity of the above solution is O(n) as the method does a simple tree traversal
    // in a bottom-up fashion.
    // Space Complexity: O(n). This is because the maximum amount of space utilized by the recursion stack
    // would be N since the height of a skewed binary tree could be N.
    // Assumption: This function assumes that n1 and n2 are present in Binary Tree
    TreeNode findLCA(TreeNode node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.val == n1 || node.val == n2)
            return node;

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCA(node.left, n1, n2);
        TreeNode right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    public static void main(String[] args) {
        BinTreeLCA bt = new BinTreeLCA();
        bt.setHead(3);
        bt.head.left = bt.append(5);
        bt.head.left.left = bt.append(6);
        bt.head.left.right = bt.append(2);
        bt.head.left.right.left = bt.append(7);
        bt.head.left.right.right = bt.append(4);
        bt.head.right = bt.append(1);
        bt.head.right.left = bt.append(0);
        bt.head.right.right = bt.append(8);
        System.out.println("LCA for "+bt.head.left.right.left.val+ " and "+bt.head.left.right.right.val+ " = "+bt.lowestCommonAncestor(bt.head,
                bt.head.left.right.left,bt.head.left.right.right).val);

    }
}
