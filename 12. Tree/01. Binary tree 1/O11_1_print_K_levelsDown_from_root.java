// video 22 https://www.youtube.com/watch?v=KvcfuGcdDMg&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=22
// https://www.geeksforgeeks.org/dsa/print-nodes-at-k-distance-from-root/
// copy 8


// print Nodes at K distance
// i/p: [], K=2
// o/p: K level elements from left and right child
// explain: print k level elements
// pre-order

import java.lang.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class O11_1_print_K_levelsDown_from_root {

    Node root;

    public static void printKLevelDown(Node node, int K) {

        // case 1: base case
        if(node == null) return;

        // Even it can be written case 3 first then case 2; doesn't matter which I write first
        // case 2: self case
        if(K == 0){
            System.out.print(node.data + " ");
        }

        // case 3: check for left and right
        printKLevelDown(node.left, K-1); // it will print left child data
        printKLevelDown(node.right, K-1); // it will print right child data 

    }

    // explain: 
    /*
      20         = level 0
      50, 90     = level 1
      30, 40, 70 = level 2

    ASSUME, K=2 then case 1, 2 are not acceptable only case 3 is acceptable and go to left child and k= k-1 = 1
            still, case 1, 2 are not acceptable go for case 3 and now k = k-1 = 1-1 = 0
            now k = 0; now it is acceptable and it will print left and right child element

    ASSUME, K=0 then case 1 is not satisfying and case 2 is acceptable so it will print root node data
    
    
     */

    public static void main(String args[]) {
        O11_1_print_K_levelsDown_from_root tree = new O11_1_print_K_levelsDown_from_root();

        tree.root = new Node(20);
        tree.root.left = new Node(50);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        printKLevelDown(tree.root, 2);
    }
}
