package interviews.questions.amazon;


//Reference: https://www.techiedelight.com/boundary-traversal-binary-tree/

public class BoundedBinaryTree {

    public class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.data=data;
        }
    }

    public TreeNode createBinaryTree()
    {

        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        TreeNode node5=new TreeNode(5);
        TreeNode node45=new TreeNode(45);
        TreeNode node55=new TreeNode(55);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        node10.right=node5;
        node5.right=node45;

        node50.right=node55;
        return rootNode;
    }

    public void printRightBottomUp(TreeNode node){

        if(node == null) {
            return;
        }

        // if leaf node, ignore while printing edges
        if(node.left==null && node.right==null)
        {
            return;
        }

        if(node.right!=null)
        {
            printRightBottomUp(node.right);
        }
        else if(node.left!=null)
        {
            printRightBottomUp(node.left);
        }

        System.out.print(node.data+" ");
    }

    public void printLeafNodes(TreeNode node){

        if(node == null) {
            return;
        }

        if(node.left==null && node.right==null)
        {
            System.out.print(node.data+" ");
            return;
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    public void printLeftEdgeNodes(TreeNode node){

        if (node == null){
            return;
        }

        // if leaf node, ignore while printing edges
        if(node.left==null && node.right==null)
            return;

        System.out.print(node.data+" ");

        if (node.left == null){
            printLeftEdgeNodes(node.right);
        } else {
            printLeftEdgeNodes(node.left);
        }
    }


    //We break the problem in 3 parts:
    //1. Print the left boundary in top-down manner.
    //2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
    //…..2.1 Print all leaf nodes of left sub-tree from left to right.
    //…..2.2 Print all leaf nodes of right subtree from left to right.
    //3. Print the right boundary in bottom-up manner.
    //We need to take care of one thing that nodes are not printed again. e.g. The left most node is also the leaf node of the tree.
    //Based on the above cases, below is the implementation:
    // Time Complexity: O(n) where n is the number of nodes in binary tree.
    // The auxiliary space required by the program is O(h) for the call stack where h is the height of the tree
    public void boundaryLevelTraversal(TreeNode rootNode){
        System.out.print(rootNode.data+" ");
        printLeftEdgeNodes(rootNode.left);
        printLeafNodes(rootNode);
        printRightBottomUp(rootNode.right);
    }

    public static void main(String[] args)
    {
        BoundedBinaryTree bbt = new BoundedBinaryTree();
        // Creating a binary tree
        TreeNode rootNode=bbt.createBinaryTree();
        System.out.println("Boundary traversal of binary tree will be:");
        bbt.boundaryLevelTraversal(rootNode);
    }


}
