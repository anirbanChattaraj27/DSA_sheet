    

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class O9_4_ROOT_to_NODE_path {
    // Helper function to find the path from root to a given node
    private boolean getPath(TreeNode root, ArrayList<Integer> list, int x) {
        if (root == null) {
            return false;
        }

        // Add the current node to the path
        list.add(root.val);

        // If the current node is the target, return true
        if (root.val == x) {
            return true;
        }

        // Recursively search in left and right subtrees
        if (getPath(root.left, list, x) || getPath(root.right, list, x)) {
            return true;
        }

        // If not found in this path, remove the current node and return false
        list.remove(list.size() - 1);
        return false;
    }

    // Function to return the path from root to a given node
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) return list; // If tree is empty, return an empty list
        getPath(A, list, B);
        return list;
    }

    // Main function to test the solution
    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
         */
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        O9_4_ROOT_to_NODE_path solution = new O9_4_ROOT_to_NODE_path();

        // Finding the path to node 5
        int target = 7;
        ArrayList<Integer> path = solution.solve(root, target);
        
        // Printing the path
        System.out.println("Path from root to node " + target + ": " + path);
    }
}
