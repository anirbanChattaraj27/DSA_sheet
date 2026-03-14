/* copy 7
modified version, here not using global arraylist useing another function to resolve that 
preffered way to solve
*/
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

public class O9_2_find_path_NODE_to_ROOT {
    
    Node root;

    // This function will be used to check if the key exists in the tree and build the path.
    public static boolean supportFun(Node node, int key, ArrayList<Integer> list) {
        if (node == null) {
            return false;
        } 

        // If the current node matches the key, add it to the list and return true
        if (node.data == key) {
            list.add(node.data);
            return true;
        }

        // Otherwise, search in left subtree
        if (supportFun(node.left, key, list)) {
            list.add(node.data); // add the current node to the path
            return true;
        }

        // Otherwise, search in right subtree
        if (supportFun(node.right, key, list)) {
            list.add(node.data); // add the current node to the path
            return true;
        }

        return false;
    }

    // This function will return the path from the given node to the root
    public static ArrayList<Integer> NodetoRoot(Node node, int key) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // If the key is found, the path will be populated
        if (supportFun(node, key, list)) {
            return list;
        }
        
        // If key is not found, return an empty list
        return new ArrayList<>();
    }

    public static void main(String args[]) {

        // Original Tree:
        //         50
        //       /    \
        //      40    60
        //     / \ 
        //    30 45

        Node root = new Node(50);
        root.left = new Node(40);
        root.right = new Node(60);
        root.left.left = new Node(30);
        root.left.right = new Node(45);

        int key = 45;

        // Calling NodetoRoot function to get the path
        ArrayList<Integer> path = NodetoRoot(root, key);
        System.out.println("Node to Root Path: " + path);
    }
}
