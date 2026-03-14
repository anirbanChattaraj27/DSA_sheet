// https://youtu.be/1Kyc-zQS7eQ?si=Ihm1UZrgsMM7pHgo
// copy explanation NO. 7

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O9_1_search_given_node {

    Node root;

    public static boolean searchGivenData(Node node, int data) {

        // case 1: base case
        if (node == null) {
            return false;
        }

        // case 2: self case
        if (node.data == data) {
            return true;
        }

        // case 3: left child
        boolean findLeftChild = searchGivenData(node.left, data);
        if (findLeftChild) {
            return true;
        }

        // case 4: right child;
        boolean findRightChild = searchGivenData(node.right, data);
        if(findRightChild){
            return true;
        }

        // case 5: if above case doesn't matches return false
        return false;
    }
 
    // declare ArrayList globally
    static ArrayList<Integer> path; // ⭐ArrayList should be declared as static then only i can use its reference

    public static boolean NodeToPath(Node node, int data){
        // same code as per above just need to add 1 extra line

        // case 1: base case
        if (node == null) {
            return false;
        }

        // case 2: self case
        if (node.data == data) {
            path.add(node.data);
            return true;
        }

        // case 3: left child
        boolean findLeftChild = NodeToPath(node.left, data);
        if (findLeftChild) {
            path.add(node.data);
            return true;
        }

        // case 4: right child;
        boolean findRightChild = NodeToPath(node.right, data);
        if(findRightChild){
            path.add(node.data);
            return true;
        }

        // case 5: if above case doesn't matches return false
        return false;
    }

    public static void main(String args[]) {

        O9_1_search_given_node tree = new O9_1_search_given_node();

        tree.root = new Node(20);
        tree.root.left = new Node(50);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        path = new ArrayList<>(); // Initialize the static path ArrayList
        
        boolean found = NodeToPath(tree.root, 40);
        System.out.println("Path exists: " + found);
        System.out.println("Node to Root Path: " + path);
    }
}
