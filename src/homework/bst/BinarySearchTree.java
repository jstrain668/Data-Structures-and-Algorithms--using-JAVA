package homework.bst;

import java.util.ArrayList;

public class BinarySearchTree {

    Node root;
    HelperFunctions hlp = new HelperFunctions();

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        Node newNode = new Node(value);

        if (this.root == null){
            this.root = newNode;
            return;
        }

        Node current = this.root;
        while(true){
            if (current.value < value) { // go right
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = newNode;
                    break;
                }
            }
            else{ // go left
                if (current.left != null){
                    current = current.left;
                } else{
                    current.left = newNode;
                    break;
                }
            }
        }
    }

    public boolean lookUp(int value){
        Node current = this.root;

        while (current != null){
            if (current.value < value){ //Go right
                current = current.right;
            } else if (current.value > value) { //Go left
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public void remove(int value){

       if (this.root == null){
           System.out.println("Cannot remove from an empty tree");
           return;
       }

       Node current = this.root;
       Node parentNode = null;

       while (current != null){

           if (value < current.value){ // Go Left
               parentNode = current;
               current = current.left;
           } else if (value > current.value){ // Go Right
               parentNode = current;
               current = current.right;
           } else { // Found node to delete

               // Scenario 1: No right child
               if (current.right == null) {

                   if (parentNode == null) {
                       this.root = current.left;
                   } else if (current.value < parentNode.value){
                       parentNode.left = current.left;
                   } else if (current.value > parentNode.value){
                       parentNode.right = current.left;
                   }
               } // Scenario 2: Right child with no left child
               else if (current.right.left == null){

                   if (parentNode == null){
                       this.root = current.right;
                   } // if current < parent, make current's right child a left child of parent
                   else if (current.value < parentNode.value){
                       parentNode.left = current.right;
                   } // if current > parent, make current's right child a right child of parent
                   else if (current.value > parentNode.value){
                       parentNode.right = current.right;
                   }
               }
               else {
                   // Scenario 3: Right child with left child
                   if (parentNode == null){
                       Node leftNode = this.root.left;
                       Node rightNode = this.root.right;
                       this.root = current.right.left;
                       rightNode.left = rightNode.left.right;
                       this.root.left = leftNode;
                       this.root.right = rightNode;
                   } else if (current.value < parentNode.value){
                       parentNode.left = current.right.left;
                   } else if (current.value > parentNode.value){
                       parentNode.right = current.right.left;
                   }
               }

               return;
           }
       }
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> answer = new ArrayList<>();
        return hlp.traverseInOrder(this.root, answer);
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> answer = new ArrayList<>();
        return hlp.traversePreOrder(this.root, answer);
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> answer = new ArrayList<>();
        return hlp.traversePostOrder(this.root, answer);
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

        System.out.println("look for 20: " + bst.lookUp(20));

        System.out.println("dfs inOrder: " + bst.DFSInOrder());
        System.out.println("dfs preOrder: " + bst.DFSPreOrder());
        System.out.println("dfs postOrder: " + bst.DFSPostOrder());

        bst.remove(20);
        System.out.println("look for 20 after removing 20: " + bst.lookUp(20));
        System.out.println("dfs inOrder: " + bst.DFSInOrder());

    }
}
