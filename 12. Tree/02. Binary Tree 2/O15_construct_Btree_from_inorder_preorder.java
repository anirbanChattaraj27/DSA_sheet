// copy: 37
// // revise done


import java.util.*;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left, right;

    // Constructor
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

// Solution class
class Solution {
    // Public method to start the building process
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store value -> index from inorder
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Start the recursive construction
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    // Helper method
    private TreeNode build(int[] preorder, int preorderStart, int preorderEnd,
                           int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> inMap) {
        // Base condition
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) return null;

        // First element of preorder is the root
        TreeNode root = new TreeNode(preorder[preorderStart]);

        // Get inorder index of root
        int inRoot = inMap.get(root.val); // using the map to get the index of root in inorder.
        int numsLeft = inRoot - inorderStart; // number of nodes in the left subtree, which is the distance between the start of inorder and the root index in inorder.

        // Build left and right subtrees
        root.left = build(preorder, preorderStart + 1, preorderStart + numsLeft,
                          inorder, inorderStart, inRoot - 1, inMap);
        root.right = build(preorder, preorderStart + numsLeft + 1, preorderEnd,
                           inorder, inRoot + 1, inorderEnd, inMap);

        return root;
    }
}

// Main class
public class O15_construct_Btree_from_inorder_preorder {
    // Method to print inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        Solution sol = new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
    }
}
