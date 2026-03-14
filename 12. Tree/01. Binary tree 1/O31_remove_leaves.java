// copy 13
// reamove leaves means last nodes of trees

import java.util.*;

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O31_remove_leaves {

    
    public static ArrayList<Integer> fun2(Node node, ArrayList<Integer> list){

        if(node == null){
            return null;
        }

        if (node.left != null || node.right != null) {
            list.add(node.data); // Only add non-leaf nodes
        }
        
        fun2(node.left, list);
        fun2(node.right, list);

        return list;
    }

    public static Node fun(Node node){
        
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = fun(node.left);
        node.right = fun(node.right);

        return node;
    }

    public static void printTreePreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " "); // Visit root first
        printTreePreOrder(node.left);  // Then left subtree
        printTreePreOrder(node.right); // Finally, right subtree
    }

    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<>();
        // Original Tree:
        //         10
        //       /    \
        //      8      2
        //     / \    /
        //    3   5  2      
        
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        
        fun(root);
        // System.out.println(); // when print this comment bellow print

        // System.out.println(fun2(root, list));

    }
}
