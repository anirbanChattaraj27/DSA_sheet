// check if a tree is a BST or not 
// validate a BST



import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class O5_validate_BST {
    public boolean isBST(TreeNode root) {

        return validate1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // return validate2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate1(TreeNode node, int min, int max) {
        // Base case: if the node is null, return true
        if (node == null)
            return true;

        // Check if the node's value falls within the valid range
        if (node.data <= min || node.data >= max)
            return false;

        // Recursively validate the left subtree Update the max value to the current node's value
        boolean leftIsValid = validate1(node.left, min, node.data);

        // Recursively validate the right subtree Update the min value to the current node's value
        boolean rightIsValid = validate1(node.right, node.data, max);

        // Both subtrees must be valid for the tree to be a BST
        return leftIsValid && rightIsValid;
    }

    //another method of solving
    private boolean validate2(TreeNode node, int min, int max) {
        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return validate2(node.left, min, node.data) && validate2(node.right, node.data, max);
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(15);

        O5_validate_BST solution = new O5_validate_BST();
        System.out.println(solution.isBST(root)); // Output: false
    }
}