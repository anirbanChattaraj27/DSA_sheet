
// copy 31
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the node with a value
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class O8_right_left_view_tree {
    // Function to return the Right view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // Get the level order traversal of the tree
        List<List<Integer>> levelTraversal = levelOrder(root);

        // Iterate through each level and add the last element to the result
        for (List<Integer> level : levelTraversal) {
            res.add(level.get(level.size() - 1));
        }

        return res;
    }

    // Function to return the Left view of the binary tree
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // Get the level order traversal of the tree
        List<List<Integer>> levelTraversal = levelOrder(root);

        // Iterate through each level and add the first element to the result
        for (List<Integer> level : levelTraversal) {
            res.add(level.get(0));
        }

        return res;
    }

    // Function that returns the level order traversal of a Binary tree 
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        // Return an empty list if the tree is empty
        if (root == null) {
            return ans;
        }

        // Use a queue to perform level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            // Process each node in the current level
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                level.add(top.data);

                // Enqueue the left child if it exists
                if (top.left != null) {
                    q.add(top.left);
                }

                // Enqueue the right child if it exists
                if (top.right != null) {
                    q.add(top.right);
                }
            }

            // Add the current level to the result
            ans.add(level);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        /*
            1
          /   \
         2     3
        / \   / \
       4  10 9  10
        \
         5
          \
           6

        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        O8_right_left_view_tree solution = new O8_right_left_view_tree();

        // Get the Right View traversal
        List<Integer> rightView = solution.rightSideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Get the Left View traversal
        List<Integer> leftView = solution.leftSideView(root);

        // Print the result for Left View
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
