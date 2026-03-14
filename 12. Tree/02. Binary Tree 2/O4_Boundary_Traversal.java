import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}


public class O4_Boundary_Traversal {

    // Helper function to check if a node is a leaf node
    public static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // Function to add the left boundary to the result list (excluding leaf nodes)
    public static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) {
                res.add(cur.val);  // Use val instead of data
            }
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    // Function to add the right boundary to the result list in reverse (excluding leaf nodes)
    public static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (cur != null) {
            if (!isLeaf(cur)) {
                tmp.add(cur.val);  // Use val instead of data
            }
            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        // Add the right boundary in reverse order
        for (int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i));
        }
    }

    // Function to add all the leaf nodes to the result list
    public static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);  // Use val instead of data
            return;
        }
        // Recurse for both left and right children
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    // Function to perform the boundary traversal of the tree
    public static ArrayList<Integer> printBoundary(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }

        // Add only root node
        if (!isLeaf(node)) {
            ans.add(node.val);  // Use val instead of data
        }

        // Add the left boundary (excluding leaf nodes)
        addLeftBoundary(node, ans);

        // Add the leaves (all leaf nodes in the tree)
        addLeaves(node, ans);

        // Add the right boundary (excluding leaf nodes)
        addRightBoundary(node, ans);

        return ans;
    }

    // Main function to test the boundary traversal
    public static void main(String[] args) {
        // Creating a sample tree:
        //         1
        //        / \
        //       2   5
        //      / \   / 
        //     4   6 7
        //        /  \
        //       9   8

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        ArrayList<Integer> boundary = printBoundary(root);

        // Output the boundary traversal result
        System.out.println(boundary);
    }
}
