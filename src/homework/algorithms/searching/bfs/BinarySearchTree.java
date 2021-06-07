package homework.algorithms.searching.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int value){

        Node newNode = new Node(value);

        if (this.root == null){
            this.root = newNode;
        } else {
            Node current = this.root;

            while (true){

                if (value < current.value){  // Go Left

                    if (current.left != null){
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {                     // Go right
                    if (current.right != null){
                        current = current.right;
                    } else{
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }

    public ArrayList<Integer> breadthFirstSearch() {
        Node current = this.root;
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> resultArray = new ArrayList<>();

        queue.add(current);

        while (!queue.isEmpty()){

            current = queue.poll();
            resultArray.add(current.value);

            if (current.left !=null){
                queue.add(current.left);
            }

            if (current.right !=null){
                queue.add(current.right);
            }
        }

        return resultArray;
    }

    public ArrayList<Integer> breadthFirstSearchRecursive(Queue<Node> queue, ArrayList<Integer> resultArray) {

        //Base case: Exit from recursive calls
        if (queue.isEmpty()){
            return resultArray;
        }

        Node current = queue.poll();
        resultArray.add(current.value);

        if (current.left !=null){
            queue.add(current.left);
        }

        if (current.right !=null){
            queue.add(current.right);
        }

        return breadthFirstSearchRecursive(queue,resultArray);
    }

    public boolean lookUp(int value){
        Node current = this.root;

        if (current == null)
            return false;

        while (current != null){

            if (value < current.value){ //Go left
                current = current.left;
            } else if (value > current.value){ //Go right
                current = current.right;
            } else { //Found
                return true;
            }
        }

        return false;
    }

    // DFS PreOrder traversal without recursion
    public ArrayList<Integer> DFSPreOrderTraversalWithoutRecursion(){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> resultArray = new ArrayList<>();
        Node current = this.root;

        stack.push(current);
        while (!stack.empty()){

            current = stack.pop();
            resultArray.add(current.value);

            if (current.right != null){
                stack.push(current.right);
            }

            if (current.left != null){
                stack.push(current.left);
            }
        }

        return resultArray;
    }

    // DFS InOrder traversal without recursion
    public ArrayList<Integer> DFSInOrderTraversalWithoutRecursion(){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> resultArray = new ArrayList<>();
        Node current = this.root;

        stack.push(current);
        while (!stack.empty()){

            while (current.left != null){
                current = current.left;
                stack.push(current);
            }

            current = stack.pop();
            resultArray.add(current.value);

            if (current.right != null){
                current = current.right;
                stack.push(current);
            }
        }
        return resultArray;
    }

    // DFS PostOrder traversal without recursion
    public ArrayList<Integer> DFSPostOrderTraversalWithoutRecursion() {

        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> resultArray = new ArrayList<>();
        Node current = this.root;
        Node prev = this.root;

        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right ||
                    (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                resultArray.add(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
        return resultArray;
    }

    // main method
    public static void main(String[] args) {
//                 9
//            4        20
//         1    6   15    170

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        System.out.println("bfs: " + bst.breadthFirstSearch());
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(bst.root);
        System.out.println("bfs recursive: " + bst.breadthFirstSearchRecursive(queue, new ArrayList<Integer>()));
        int lookUpValue = 50;
        System.out.println("Lookup of "+lookUpValue+" in BST: "+bst.lookUp(lookUpValue));
        System.out.println("dfs preorder without recursion: " + bst.DFSPreOrderTraversalWithoutRecursion());
        System.out.println("dfs inorder without recursion: " + bst.DFSInOrderTraversalWithoutRecursion());
        System.out.println("dfs postorder without recursion: " + bst.DFSPostOrderTraversalWithoutRecursion());
    }
}
