// Copy 9
// NOTE: without creating object of a class; check main function
// leetcode: 938
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
        if (node == null) {
            return;
        }
 
        sum += node.data;
        path += node.data + " ";

        if (node.left == null && node.right == null) { // Leaf node
            if (sum >= low && sum <= high) {
                System.out.println(path);
            }
        } else {
            pathToLeafFromRoot(node.left, path, sum, low, high);
            pathToLeafFromRoot(node.right, path, sum, low, high);
        }
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
