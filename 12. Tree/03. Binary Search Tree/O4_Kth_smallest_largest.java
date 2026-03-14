
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

class Solution {
    // Helper function to perform an in-order traversal of the BST
    private void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node != null) {
            inorderTraversal(node.left, values);
            values.add(node.data);
            inorderTraversal(node.right, values);
        }
    }

    public List<Integer> kLargesSmall(TreeNode root, int k) {
        // List to store the node values
        List<Integer> values = new ArrayList<>();
        // Perform in-order traversal and collect values
        inorderTraversal(root, values);

        // Find the kth smallest and kth largest values
        int kth_smallest = values.get(k - 1);
        int kth_largest = values.get(values.size() - k);

        List<Integer> result = new ArrayList<>();
        result.add(kth_smallest);
        result.add(kth_largest);

        return result;
    }
}

public class O4_Kth_smallest_largest {
    // Main method to demonstrate the function
    public static void main(String[] args) {
        // Constructing the tree: [3, 1, 4, null, 2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Solution solution = new Solution();
        int k = 1;
        List<Integer> result = solution.kLargesSmall(root, k);

        System.out.println(result); // Output: [1, 4]
    }
}
