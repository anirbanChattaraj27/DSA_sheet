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
     public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        // The current node's value must fit strictly within the low and high bounds
        if ((low != null && node.data <= low) || (high != null && node.data >= high)) {
            return false;
        }

        // Recursively validate left and right subtrees with updated bounds
        return validate(node.left, low, node.data) && validate(node.right, node.data, high);
    }


    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(16);

        O5_validate_BST solution = new O5_validate_BST();
        System.out.println(solution.isValidBST(root)); // Output: true
    }
}