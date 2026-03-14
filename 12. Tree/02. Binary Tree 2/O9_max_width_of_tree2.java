// check tis code with differnt trees 
// copy 32
import java.util.*;

// Tree node definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

// Simple Pair class (node + index)
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode _node, int _num) {
        node = _node;
        num = _num;
    }
}

public class O9_max_width_of_tree2 {

    // Function to find maximum width of binary tree
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num; // to make id start from 0
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int cur_id = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0) 
                    first = cur_id;
                
                if (i == size - 1) 
                    last = cur_id;

                if (node.left != null) {
                    q.offer(new Pair(node.left, cur_id * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, cur_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1); // i have to take max of all width 
        }

        return ans;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
                 1
               /   \
              3     2
             / \     \
            5   3     9

           Width = 4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        O9_max_width_of_tree2 sol = new O9_max_width_of_tree2();
        int width = sol.widthOfBinaryTree(root);

        System.out.println("Maximum Width of Binary Tree: " + width);
    }
}


/*
                 1
               /   \
              3     2
             / \     \
            5   3     9
                    /   \
                   10   11  -> i cant take this bcz this has width 2 but above node has width 4
           Width = 4
        */
