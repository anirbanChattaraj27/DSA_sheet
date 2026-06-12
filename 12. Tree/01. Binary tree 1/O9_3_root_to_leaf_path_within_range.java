// Copy 9
// NOTE: without creating object of a class; check main function

/*
       5  <-- Root
      / \
     4   8
    /   / \
   11  13  5
low = 10 | high = 20
There are three possible root-to-leaf paths in this tree:
Path 1: 5 -> 4 -> 11 (Leaf node 11) Sum: (5 + 4 + 11 = 20)Result: print (20 is higher than 20)
Path 2: 5 -> 8 -> 13 (Leaf node 13) Sum: (5 + 8 + 13 = 26)Result: Ignored (26 is higher than 20)
Path 3: 5 -> 8 -> 4 (Leaf node 4)   Sum: (5 + 8 + 4 = 17)Result: print (17 is higher than 20)
'
*/
class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O9_3_root_to_leaf_path_within_range {
 
    Node root;

    public static void pathToLeafFromRoot(Node node, String path, int sum, int low, int high) {
    // case 1: base case
    if (node == null) {
        return;
    }

    // case 2: self work (Update sum and path string)
    sum += node.data;
    path += node.data + " ";  

    // case 3: leaf node validation (Print if valid)
    if (node.left == null && node.right == null) {
        if (sum >= low && sum <= high) {
            System.out.println(path);
        }
        return; // Done with this leaf, go back up
    }

    // case 4: explore left child
    pathToLeafFromRoot(node.left, path, sum, low, high);

    // case 5: explore right child
    pathToLeafFromRoot(node.right, path, sum, low, high);
}

    public static void main(String args[]) {
/*
             10
           /    \
          8      2
         / \    / \
        3   5  2   6
*/
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(6); // Added a right child to the right node

        int low = 12;
        int high = 18;
        // it will not print 10 8 as path it will print upto last node so "10 2 2" && "10 2 6"

        System.out.println("Paths with sum between " + low + " and " + high + ":");
        pathToLeafFromRoot(root, "", 0, low, high);

/*
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
*/
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        int low2 = 7;
        int high2 = 15;


        System.out.println("\nPaths with sum between " + low2 + " and " + high2 + ":");
        pathToLeafFromRoot(root2, "", 0, low2, high2);
    }
}
