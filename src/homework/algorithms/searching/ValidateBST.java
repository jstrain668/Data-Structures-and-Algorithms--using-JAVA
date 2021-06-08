package homework.algorithms.searching;

import java.util.ArrayList;
import java.util.Stack;

public class ValidateBST {

    Node root;

    class Node {
        int value;
        Node left, right;

        Node (int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node createBST(){
        this.root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        return root;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (this.root == null) {
            this.root = newNode;
        } else {
            Node current = this.root;
            while (true) {
                // right
                if (current.value < value) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                    // left
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                }
            }
        }
    }

    private ArrayList<Integer> dfsInOrder(Node root, ArrayList<Integer> resultArray){

        Node current = root;

        if (current == null)
            return resultArray;

        if (current.left != null){
            dfsInOrder(current.left,resultArray);
        }
        resultArray.add(current.value);
        if (current.right != null){
            dfsInOrder(current.right,resultArray);
        }

        return resultArray;
    }

    public boolean isSorted(ArrayList<Integer> resultArray){

        for (int i =0; i < resultArray.size()-1; i++){
            if (resultArray.get(i) >=  resultArray.get(i+1)){
                return false;
            }
        }

        return true;
    }

    public boolean isValid(Node root){

        ArrayList<Integer> resultArray = new ArrayList<>();
        resultArray = dfsInOrder(root, resultArray);

        return isSorted(resultArray);
    }

    public boolean isValidBST(Node root, long min, long max){

        if (root == null)
            return true;

        if (root.value >= max || root.value <= min)
            return false;

        return isValidBST(root.left,min,root.value) && isValidBST(root.right, root.value, max);

    }

    public boolean isValidBST(Node root) {

        Stack<Node> stack = new Stack<>();
        Node pre = null;

        if(root == null)
            return true;

        while (root != null || !stack.isEmpty()){
            // left
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // do
            if (pre!= null && pre.value >= root.value)
                return false;
            // record predecessor
            pre = root;
            // right
            root = root.right;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        //Node root = validateBST.createBST();
        validateBST.insert(9);
        validateBST.insert(4);
        validateBST.insert(6);
        validateBST.insert(20);
        validateBST.insert(170);
        validateBST.insert(15);
        validateBST.insert(1);

        if (validateBST.isValid(validateBST.root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");

        if (validateBST.isValidBST(validateBST.root, Long.MIN_VALUE, Long.MAX_VALUE))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");

        if (validateBST.isValidBST(validateBST.root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }
}
