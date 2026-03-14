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

public class O5_vertical_travarsal {

    class Pair {

        TreeNode node;
        int vertical;
        int level;

        Pair(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); //this treemap is to store the vertical order and corresponding to that there will be multiple level so to store level and elements at that particular vertical and level, we are taking a new treemap, & since at one vertical and one level multiple nodes can be present to keep them in sorted order we're taking them in priorityqueue to keep them in the natural order (i.e. sorted)

        Queue<Pair> q = new LinkedList<>(); //queue to perform level order traversal, the queue will store the node with the vertical pos and level pos, initially it starts at (0,0);

        q.add(new Pair(root, 0, 0)); //pushing the root at 0th vertical and 0th level

        // Now traverse using the level order traversal
        while (!q.isEmpty()) {
            int size = q.size();
            // remove
            Pair pair = q.poll(); //q will give an object of Pair type containing node, vertical and level and storing it in pair
            TreeNode node = pair.node; // taking the node only from pair and store it in TreeNode type
            int v = pair.vertical;
            int l = pair.level;

            // print
            if (!map.containsKey(v)) {
                map.put(v, new TreeMap<>());  //checking if we have already met this vertical position or not, in case if not then add a new vertical position corresponding to this vertical, and for this vertical we will need to store multiple level, so another treemap is needed which will store the level and elements
            }
            if (!map.get(v).containsKey(l)) {
                map.get(v).put(l, new PriorityQueue<>());  //checking if the level exist or not for any particular v, if not then create that level and corresponding to that we may need a priority queue to store the elements as multiple elements can be present
            }

            map.get(v).get(l).add(node.data); //previously we have created the space to update the map if the space was not available, and now we're adding the node data, vertical and level positions

            // add
            if (node.left != null) {
                q.add(new Pair(node.left, v - 1, l + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, v + 1, l + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {  //here we are traversing the map, and since it was treemap the verticals are sorted in the natural order that is ascending so we directly starts to travel on its values and its value is levels
            ans.add(new ArrayList<>()); // for each vertical we're adding an empty arraylist
            for (PriorityQueue<Integer> pqs : levels.values()) {  // for each level we're traversing into the priority queue (may contain single element or may contain multiple elements), the levels are also sorted since it is also treemap
                while (!pqs.isEmpty()) {
                    ans.get(ans.size() - 1).add(pqs.poll()); //adding those elements into the last created arraylist as per the vertical
                }
            }
        }

        return ans;
    }

    // ================= MAIN FUNCTION FOR TESTING =================
    public static void main(String[] args) {

        /*
                3
              /   \
             9     20
                  /  \
                 15   7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        O5_vertical_travarsal obj = new O5_vertical_travarsal();
        List<List<Integer>> result = obj.verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");
        System.out.println(result);
    }
}
