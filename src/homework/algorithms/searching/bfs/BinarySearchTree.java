package homework.algorithms.searching.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    }
}
