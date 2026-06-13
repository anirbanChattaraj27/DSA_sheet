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

public class O6_II_top_view_of_tree {

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

                if (!map.containsKey(v)) { // if we're visiting the vertical line for the first time then update in the map
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
                /*
                * Moving Left (v - 1): Going to a left child moves you one step to the left on the grid.
                * Moving Right (v + 1): Going to a right child moves you one step to the right on the grid.
                 */
            }
        }

        for (int topElement : map.values()) { // traversing through map values, and since it was treemap so the keys are
                                              // in sorted order so we can traverse directly through values
            list.add(topElement);
        }

        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        /*
         *                         4 
                                 (v=0)
                                /     \
                               2       6
                            (v=-1)   (v=1)
                           /    \    /    \
                         1      3   5     7
                      (v=-2)  (v=0) (v=0) (v=2)

         * 
         */
        O6_II_top_view_of_tree solution = new O6_II_top_view_of_tree();
        List result = solution.topView(root);

        System.out.println("Top View: " + result);
    }
}
