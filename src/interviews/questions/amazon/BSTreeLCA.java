package interviews.questions.amazon;


public class BSTreeLCA {

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

    //Same rules applied to go left (n1 & n2 < node.val) or right subtree (n1 & n2 > node.val)
    // or current node is LCA.
    // Time Complexity: O(h)
    // Space Complexity: O(1)
    public TreeNode iterativeLCA(TreeNode node,int n1, int n2){

        while (node != null)
        {
            // If both n1 and n2 are smaller
            // than root, then LCA lies in left
            if (node.val > n1 && node.val > n2) {
                node = node.left;
            }
                // If both n1 and n2 are greater
                // than root, then LCA lies in right
            else if (node.val < n1 && node.val < n2) {
                node = node.right;
            }
            else break;
        }
        return node;
    }
    // For Binary search tree, while traversing the tree from top to bottom the first node which lies
    // in between the two numbers n1 and n2 is the LCA of the nodes, i.e. the first node n with the
    // lowest depth which lies in between n1 and n2 (n1<=n<=n2) n1 < n2. So just recursively traverse
    // the BST in, if node’s value is greater than both n1 and n2 then our LCA lies in the left side of
    // the node, if it’s is smaller than both n1 and n2, then LCA lies on the right side.
    // Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST).
    // Time Complexity: The time Complexity of the above solution is O(h), where h is the height of
    // the tree.
    // Space Complexity: O(h) recursive calls made to the system stack

    private TreeNode findLCA(TreeNode node, int n1, int n2){
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.val > n1 && node.val > n2)
            return findLCA(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.val < n1 && node.val < n2)
            return findLCA(node.right, n1, n2);

        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root,p.val,q.val);
    }
    public static void main(String[] args) {
        BSTreeLCA bt = new BSTreeLCA();
        bt.setHead(5);
        bt.head.left = bt.append(3);
        bt.head.left.left = bt.append(2);
        bt.head.left.right = bt.append(4);
        bt.head.right = bt.append(7);
        bt.head.right.left = bt.append(6);
        bt.head.right.right = bt.append(9);
        System.out.println("LCA for "+bt.head.left.left.val+ " and "+bt.head.right.right.val+ " = "+bt.lowestCommonAncestor(bt.head,
                bt.head.left.left,bt.head.right.right).val);

    }
}
