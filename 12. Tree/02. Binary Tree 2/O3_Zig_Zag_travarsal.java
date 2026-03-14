// copy 23
// zig Zag travarsal
// Sprial travarsal
// 1st print root then right to left then left to right then right to left and so on

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class O3_Zig_Zag_travarsal {
     
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listOfList = new ArrayList<>();
        if (root == null) {
            return listOfList;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            // Traverse each level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // remove
                list.add(node.val); // print

                // Add left and right children to the queue
                if (node.left != null) { // add
                    q.offer(node.left);
                }
                if (node.right != null) { // add
                    q.offer(node.right);
                }
            }

            // Reverse the list if the current level is right-to-left
            if (!leftToRight) {
                Collections.reverse(list);
            }

            listOfList.add(list);

            leftToRight = !leftToRight;  // Alternate the direction for next level
            
        }
        return listOfList;
    }

    public static void main(String[] args) {
        O3_Zig_Zag_travarsal solution = new O3_Zig_Zag_travarsal();

        // Creating a sample tree: 
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> listOfList = solution.zigzagLevelOrder(root);
        
        System.out.println(listOfList);  // Output the zigzag level order traversal
    }
}
