// https://youtu.be/U7rLw0jXI0E?si=U9ILBO8jFGxoXxGr
// copy explaination NO. 6

import java.lang.*;
import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class O2_level_order_traversal {

    Node root;

    public static void levelOrder(Node node) {

        // use RPA (remove, print add) remove from queue 
        Queue<Node> q = new ArrayDeque<>();
        q.add(node); // add 1st element in the queue

        while(q.size() > 0){
            for(int i=0; i<q.size(); i++){
                node = q.remove(); // Remove
                System.out.print(node.data + " "); // PRINT

                if(node.left != null){
                    q.add(node.left);  // ADD
                }
                if(node.right != null){
                    q.add(node.right); // ADD
                }
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        O2_level_order_traversal tree = new O2_level_order_traversal();

        tree.root = new Node(20);
        tree.root.left = new Node(70);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        tree.levelOrder(tree.root);
    }
}
