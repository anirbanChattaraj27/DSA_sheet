// copy 29

import java.util.*;

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

public class O6_top_view_of_tree {

    // Nested generic Pair class
    static class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // Function to return the top view of the binary tree
    public List< Integer> topView(TreeNode root) {
        // List to store the result
        List< Integer> list = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return list;
        }

        // Map to store the top view nodes based on their vertical positions
        Map< Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each element is a pair containing node and its vertical position
        Queue< Pair<TreeNode, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            // Retrieve the node and its vertical position from the front of the queue
            Pair< TreeNode, Integer> it = q.poll();
            TreeNode node = it.getKey();
            int line = it.getValue();

            // If the vertical position is not already in the map, add the node's data to the map
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // Process left child
            if (node.left != null) {
                // Push the left child with a decreased vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                // Push the right child with an increased vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Trlistfer values from the map to the result list
        for (Integer value : mpp.values()) {
            list.add(value);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        /*
                1
              /    \
             2      3
           /   \   / \
          4     5 6   7

         */
        O6_top_view_of_tree solution = new O6_top_view_of_tree();
        List result = solution.topView(root);

        System.out.println("Top View: " + result);
    }
}
