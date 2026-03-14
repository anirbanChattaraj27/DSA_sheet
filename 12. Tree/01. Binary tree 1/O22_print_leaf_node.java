// I did this
// print leaf nodes means nodes having 0 child

import java.util.ArrayList;

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O22_print_leaf_node {

    public static void fun(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            list.add(node.data);
        }

        fun(node.left);
        fun(node.right);

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String args[]) {

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

        System.out.println("tree leaf nodes are: ");

        fun(root);
    }
}
