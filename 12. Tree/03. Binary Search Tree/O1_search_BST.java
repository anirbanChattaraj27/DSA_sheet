// leetcode 700
// copy explanation

// i/p: root = [4 2 7 1 3], val = 2 
// o/p: 2 1 3

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

class O1_search_BST {

    Node root;

    public static Node searchBST(Node node, int val){ // Node root also can be there in Qs.
        if(node == null){
            return null;
        }

        if(node.data == val){
            return node;
        }

        else if(val > node.data){
            return searchBST(node.right, val);
        }
        else{
            return searchBST(node.left, val);
        }
    }

    // striver
    public static Node searchBST2(Node node, int val){ // Node root also can be there in Qs.
        while(node != null && node.data != val){
            node = val < node.data ? node.left : node.right;
        }
        return node;
    }    


    public static void main(String args[]) {
        O1_search_BST tree = new O1_search_BST();

        tree.root = new Node(20);
        tree.root.left = new Node(70);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        System.out.print("The size is :" + tree.searchBST(tree.root, 40));
    }
}
