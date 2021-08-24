package interviews.questions.amazon;


//Reference: https://www.techiedelight.com/deletion-from-bst/

public class BSTOperations {

    TreeNode head;
    /**
     Definition for a binary tree node.
     */
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

    public void setHead(int val){

        if (this.head == null){
            TreeNode newNode = new TreeNode(val);
            this.head = newNode;
        } else {
            this.head.val = val;
        }
    }

    //Reference: https://leetcode.com/problems/insert-into-a-binary-search-tree/
    //Description: In a balanced search tree, insert a node as a left node, traversing through the tree (left or right)
    //depending on the value is less than or greater than the current node value.
    //Time Complexity: O(h) - Height of the tree to get to a leaf node
    //Space Complexity: O(1)
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);

        if (root == null){
            root = newNode;
            return root;
        }

        TreeNode current = root;
        while (true){

            if (val < current.val){
                if (current.left != null){
                    current = current.left;
                } else {
                    current.left = newNode;
                    return root;
                }
            } else if ( val > current.val){
                if (current.right != null){
                    current = current.right;
                } else{
                    current.right = newNode;
                    return root;
                }
            }
        }

    }

    private TreeNode getMinKey(TreeNode current){

        while (current.left != null){
            current = current.left;
        }
        return current;
    }

    //Reference: https://leetcode.com/problems/delete-node-in-a-bst/
    //Description: To delete a node, first you must find the key (traverse tree). After finding node there are 3 cases to
    //to handle when deleting.
    //Case 1: First the node is a leaf node, where the parent node reference (left or right) is set
    //to null. Also handle scenario where found node is the root node resulting root node becoming null.
    //Case 2: The node has two child nodes, in this case, the successor node (right node of current node is searched to
    //find min key) replaces the current node and the successor node is deleted via recursive call
    //Case 3; The node has one child node (either left or right). In this scenario set child node to be either left or
    //right node of current. Set the parent left node or right node to the child node to remove current node.
    //Time Complexity: O(n) to search for the value in the tree before deletion. Additional time complexity O(h) when
    //looking for successor node to replace current node.
    //Space Complexity: O(1)
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null){
            return null;
        }
        TreeNode current = root;
        TreeNode parent = null;

        //Find key in the BST
        while (current != null && current.val != key){
            parent = current;

            if (key < current.val){
                current = current.left;
            } else {
                current = current.right;
            }
        }

        //If current is null then key was not found. Return root node
        if (current == null){
            return root;
        }

        //If leaf node (no children) then delete (reset parent node left or right to null)
        if (current.left == null && current.right == null){

            //Not deleting root
            if (current != root){
                if (parent.left == current){
                    parent.left = null;
                } else{
                    parent.right = null;
                }
            } else {
                root = null;
            }
        }
        //If node has two children then replace current node with in order successor node
        else if (current.left != null && current.right != null){

            //Get replacement node
            TreeNode successor = getMinKey(current.right);

            //Store successor value
            int val = successor.val;

            deleteNode(root,successor.val);

            //Copy value of successor to current
            current.val = val;
        }
        //else current has one child
        else
        {

            TreeNode child = (current.left != null)? current.left: current.right;

            // if the node to be deleted is not a root node, set its parent
            // to its child
            if (current != root)
            {
                if (parent.left == current) {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }

            // if the node to be deleted is a root node, then set the root to the child
            else {
                root = child;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BSTOperations bsto = new BSTOperations();

        bsto.setHead(5);
        bsto.insertIntoBST(bsto.head,3);
        bsto.insertIntoBST(bsto.head,2);
        bsto.insertIntoBST(bsto.head,4);
        bsto.insertIntoBST(bsto.head,6);
        bsto.insertIntoBST(bsto.head,7);
        bsto.deleteNode(bsto.head, 3);
    }
}
