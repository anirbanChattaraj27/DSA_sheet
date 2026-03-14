// 2 qs are there

/* 1. Lowest Common Ancestor of two nodes of a tree (in O(N)) */
/* 2. Finding LCA of any two nodes of a tree (in O(logN)) */

// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
// copy 28

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

public class O10_LCA {
    // Function to find the Lowest Common Ancestor (LCA) of two nodes
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If one node is found on the left and another on the right, root is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null node
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        
        /*
                1
               / \
              2   3
             / \  / \
            4   5 6  7
         */
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        O10_LCA solution = new O10_LCA();
        
        TreeNode p = root.left;  // Node with value 2
        TreeNode q = root.right.right;  // Node with value 7

        // Finding LCA of nodes 5 and 4
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        
        // Printing the result
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
