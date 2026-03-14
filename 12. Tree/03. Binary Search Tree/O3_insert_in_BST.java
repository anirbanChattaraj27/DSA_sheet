
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

class Solution {
    // Recursive function to insert a value into the BST
    private TreeNode solve(TreeNode node, int val) {
        // If the current node is NULL, create a new TreeNode with the given value
        if (node == null) {
            return new TreeNode(val);
        }
        
        // Traverse the tree to find the correct insertion point
        if (val < node.data) {
            // Move to the left subtree
            node.left = solve(node.left, val);
        } else if (val > node.data) {
            // Move to the right subtree
            node.right = solve(node.right, val);
        }
        
        // Return the (potentially modified) node
        return node;
    }
    
    // Public method to start the insertion process
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return solve(root, val);
    }
}

// Helper function to print the tree in-order
public class O3_insert_in_BST {
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Create a sample BST: [4, 2, 7, 1, 3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        
        int val = 5;
        // Insert the value into the BST
        TreeNode newRoot = solution.insertIntoBST(root, val);
        
        // Print the BST in-order to verify the insertion
        printInOrder(newRoot);
    }
}
