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

public class O6_top_view_of_tree2 {

    class Pair {

        TreeNode node;
        int vertical;

        Pair(TreeNode node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list; // if root is null then returning empty list
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(); // using treemap to store the vertical and the topmost node
        // data in the vertical as from top view only top most elements
        // in each vertical will be visible
        Queue<Pair> q = new LinkedList<>(); // queue for level order traversal
        
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.poll(); // getting the element out of queue of Pair type
                TreeNode node = pair.node; // getting node from pair
                int v = pair.vertical; // getting vertical line from pair

                if (!map.containsKey(v)) { // if we're visiting the vertical line for the first time then update in the
                                           // map
                    map.put(v, node.data);
                }
                // here not updating the map everytime as we are concerned only about the top
                // element in the vertical (to avoid confusion with vertical traversal)

                if (node.left != null) {
                    q.add(new Pair(node.left, v - 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, v + 1));
                }
            }
        }

        for (int topElement : map.values()) { // traversing through map values, and since it was treemap so the keys are
                                              // in sorted order so we can traverse directly through values
            list.add(topElement);
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
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         */
        O6_top_view_of_tree2 solution = new O6_top_view_of_tree2();
        List result = solution.topView(root);

        System.out.println("Top View: " + result);
    }
}
