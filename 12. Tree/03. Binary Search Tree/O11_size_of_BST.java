// cross-check the code and answer and understand approch or try new approch

import java.lang.*;


class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class O11_size_of_BST {

    Node root;

    public static int sizeBST(Node node){ // Node root also can be there in Qs.
        if(node == null){
            return 0;
        }

        return 1 + sizeBST(node.left) + sizeBST(node.right);
    }

    public static void main(String args[]) {
        O11_size_of_BST tree = new O11_size_of_BST();

        tree.root = new Node(20);
        tree.root.left = new Node(70);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        System.out.print("The size is :" + tree.sizeBST(tree.root));
    }
}
