/* Lec: 30 striver */
/* another version for this code in above folder */
// O11_1_K_level_far above folder code
// nodes at a distance K
//copy 35
// remaining for 2nd revision // // revise needs to be done next phase


import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

public class O11_2_K_level_far_from_target {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Create a map to store the parent of each node
        /*
        What it does: It starts at the root and traverses the entire tree level-by-level using a standard queue.
        The Magic: Every time it encounters a child (node.left or node.right), it creates a mapping in 
        parentMap linking that child to its parent node.
        Result: You can now move upwards from any node by querying parentMap.get(node).
        */
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // remove
            // If the left child exists, map its parent and push it into the queue
            if (node.left != null) {
                parentMap.put(node.left, node); // print
                queue.add(node.left); // add
            }
            // If the right child exists, map its parent and push it into the queue
            if (node.right != null) {
                parentMap.put(node.right, node); // print
                queue.add(node.right); // add
            }
        }

        // Step 2: Use BFS to find all nodes at distance k from the target
        /*
        What it does: It clears the queue and inserts the target node to begin a fresh, concentric traversal.
        The visited Set: This is critical. Since you can now move in 3 directions (left, right, up), you would 
        get stuck in an infinite loop moving back and forth without tracking where you have already been.        
        */
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int currentDistance = 0;

        // Continue BFS until the desired distance is reached
        /*
        The Distance Check: Before expanding a level, it checks if currentDistance == k. If it does, 
        the queue holds exactly the nodes located at distance \(K\). It drains the queue into the 
        result list and immediately returns.
         */
        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                // Collect all nodes at distance k
                while (!queue.isEmpty()) {
                    result.add(queue.poll().data);
                }
                return result;
            }

            /*
            The Concentric Ripple: For every node at the current distance layer, it attempts to 
            branch out in 3 directions (Left child, Right child, Parent). If a neighbor exists and 
            hasn't been visited, it gets added to the queue for the next distance layer.
             */
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Check left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }

                // Check right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                // Check parent
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currentDistance++;
        }

        return result;
    }

    // Helper function to create a binary tree from a list
    public static TreeNode createTree(List<Integer> nodes, int index) {
        if (index < nodes.size() && nodes.get(index) != null) {
            TreeNode root = new TreeNode(nodes.get(index));
            root.left = createTree(nodes, 2 * index + 1);
            root.right = createTree(nodes, 2 * index + 2);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        O11_2_K_level_far_from_target sol = new O11_2_K_level_far_from_target();

        List<Integer> nodes = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);

        TreeNode root = createTree(nodes, 0);
        TreeNode target = root.left;  // Node with value 5
        int k = 2; 

        List<Integer> result = sol.distanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from target node are: " + result);
    }
}

