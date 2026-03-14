//  copy: 35
// need to understand the explanation || solution is not from STRIVER
// problem with this code
// this question same as O11_2_print_nodes_K_level_far_from_target bUT, code logic here is different
// nodes at k distance

import java.lang.*;
import java.util.ArrayList;

class Node {

    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O11_3_K_level_far_from_target {

    Node root;

    public static void printKNodesFar(Node node, int data, int k){
        path = new ArrayList<>();
        NodeToPath(node, data);

        for(int i=0; i<path.size(); i++){
            printKLevelDown(path.get(i), k-i, i==0? null : path.get(i-1));
        }
    } 

    static ArrayList<Node> path; // ⭐ArrayList should be declared as static then only i can use its reference

    public static boolean NodeToPath(Node node, int data){

        // case 1: base case
        if (node == null) {
            return false;
        }

        // case 2: self case
        if (node.data == data) {
            path.add(node);
            return true;
        }

        // case 3: left child
        boolean findLeftChild = NodeToPath(node.left, data);
        if (findLeftChild) {
            path.add(node);
            return true;
        }

        // case 4: right child;
        boolean findRightChild = NodeToPath(node.right, data);
        if(findRightChild){
            path.add(node);
            return true;
        }

        return false;
    }

    public static void printKLevelDown(Node node, int K, Node blocker) {

        // case 1: base case
        if(node == null || K < 0 || node == blocker) return;

        // case 2: self case
        if(K == 0){
            System.out.print(node.data + " ");
        }

        // case 3: check for left and right
        printKLevelDown(node.left, K-1, blocker);
        printKLevelDown(node.right, K-1, blocker);

    }

    public static void main(String args[]) {
        O11_3_print_nodes_K_level_far tree = new O11_3_print_nodes_K_level_far();

        tree.root = new Node(20);
        tree.root.left = new Node(50);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        // printKNodesFar(tree.root, 2);
    }
}
