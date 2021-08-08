package interviews.questions.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidBST {

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

    public TreeNode getHead() {
        return head;
    }

    public TreeNode bstInsert(int val){

        TreeNode newNode = new TreeNode(val);

        if (this.head == null){
            this.head = newNode;
        } else{
            TreeNode current = getHead();

            while (true){

                if (val < current.val){ // Go left until left pointer is null

                    if (current.left != null){
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        break;
                    }

                } else if (val > current.val){ // go right until right pointer is null
                    if (current.right != null){
                        current = current.right;
                        continue;
                    } else{
                        current.right = newNode;
                        break;
                    }
                } else { // Node value all ready exists. No duplicates allowed
                    return null;
                }
            }
        }

        return newNode;
    }

    private TreeNode getMinVal(TreeNode node){

        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    private TreeNode deleteNode(TreeNode head, int val){

        TreeNode current = head;
        TreeNode parent = null;

        while (current != null && current.val != val){

            parent = current;
            if (val < current.val){
                current = current.left;
            } else {
                current = current.right;
            }
        }

        //Node not found
        if (current == null){
            return head;
        }

        //Is it a leaf node to be deleted
        if (current.left == null && current.right == null){

            if (current != head){
                if (parent.right == current){
                    parent.right = null;
                } else{
                    parent.left = null;
                }
            } else{ // Head node to be deleted
                head = null;
            }
        } // If node has two children then replace current node with in order successor node
        else if (current.left != null && current.right != null){
            TreeNode successor = getMinVal(current.right);
            int storeVal = successor.val;
            deleteNode(head,successor.val);
            current.val = storeVal;
        } // Node has one child then parent sets that child node (left or right to null)
        else {

            TreeNode child = (current.left != null)? current.left : current.right;

            if (current != head){
                if (parent.left == current){
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                head = child;
            }
        }

        return head;
    }

    public TreeNode deleteNode(int val){

        return deleteNode(getHead(),val);
    }

    private void inOrderTraversal(TreeNode node, List arrayList){

        if (node == null){
            return;
        }

        inOrderTraversal(node.left,arrayList);
        arrayList.add(node.val);
        inOrderTraversal(node.right,arrayList);
    }

    public int[] inOrderTraversal(TreeNode node){
        List<Integer> arrayList = new ArrayList<>();
        inOrderTraversal(node, arrayList);

        int[] result = new int[arrayList.size()];

        for (int i=0; i < result.length; i++){
            result[i] = arrayList.get(i);
        }

        return  result;
    }

    private boolean isSorted(int[] nums){

        for (int i=1; i < nums.length; i++){
            if (nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isBST(TreeNode root){
        int[] nums = inOrderTraversal(root);

        return isSorted(nums);
    }


    //Solution: Look at each node only once. Write a utility helper function isBSTUtil(TreeNode, int min, int max)
    //that traverses down the tree keeping track of the narrowing min and max allowed values as it goes, looking at
    //each node only once. The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there.
    //Note: This method is not applicable if there are duplicate elements with value INT_MIN or INT_MAX.
    //Time Complexity: O(n) - visit each node once
    //Space Complexity: O(n) - System stack for each recursive call
    private boolean isBSTUtil(TreeNode node,int min, int max){

        //Base case: Empty tree is a valid binary search tree
        if (node == null){
            return true;
        }

        //Check the node value is within the permitted range
        if (node.val < min || node.val > max){
            return false;
        }

        return (isBSTUtil(node.left,min,node.val-1) && isBSTUtil(node.right,node.val+1, max));

    }

    public boolean isBSTEfficient(TreeNode root){

        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    // Instead of relying Max and Min values in the above solution, use the left and right pointers of the root node
    // and so to recursively traverse the tree checking the values of each are with the allowed ranges.
    //Time Complexity: O(n) - visit each node once
    //Space Complexity: O(n) - System stack for each recursive call
    public boolean isBST(TreeNode node, TreeNode left, TreeNode right)
    {
        // Base condition
        if (node == null) {
            return true;
        }

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (left != null && node.val <= left.val){
            return false;
        }

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (right != null && node.val >= right.val){
           return false;
        }

        // check recursively for every node.
        return isBST(node.left,left,node)  && isBST(node.right,node,right);
    }

    public static void main(String[] args) {
        ValidBST vBST = new ValidBST();

        vBST.bstInsert(5);
        vBST.bstInsert(3);
        vBST.bstInsert(2);
        vBST.bstInsert(4);
        vBST.bstInsert(8);
        vBST.bstInsert(7);
        vBST.bstInsert(6);
        vBST.bstInsert(9);
        System.out.println("InOrder traversal: "+ Arrays.toString(vBST.inOrderTraversal(vBST.getHead())));

        vBST.deleteNode(4);
        vBST.deleteNode(7);
        vBST.deleteNode(8);


        System.out.println("InOrder traversal: "+ Arrays.toString(vBST.inOrderTraversal(vBST.getHead())));
        System.out.println("Is valid BST: "+vBST.isBST(vBST.getHead()));
        System.out.println("Is valid BST: "+vBST.isBSTEfficient(vBST.getHead()));
        System.out.println("Is valid BST: "+vBST.isBST(vBST.getHead(),null,null));

    }
}
