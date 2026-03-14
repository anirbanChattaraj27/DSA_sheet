// Ceil: value >= Key. 
//       if Key is given, u have to find a value that is >= key. the nearest value will be the answer

// Floor: value <= Key
//        if Key is given, u have to find a value that is <= Key. the nearest value will be the answer
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {

    public int findCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) { // Traverse the BST until reaching the end or finding the key

            // If the key is found, assign it as the ceiling and return
            if (root.val == key) {
                ceil = root.val;
                return ceil;
            }

            // If the key is greater, move to the right subtree
            if (key > root.val) {
                root = root.right;
            } 

            else { 
                // If the key is smaller, update ceil and move to the left subtree
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    
    public int floorInBST(TreeNode root, int key) {
    
        int floor = -1;

        while (root != null) {

            // If the key is found, assign it  as the floor value and return
            if (root.val == key) {
                floor = root.val;
                return floor;
            }

            // If the key is greater than the current node's value, move to the right subtree
            if (key > root.val) {
                // Update the floor with the current node's value and move to the right subtree
                floor = root.val;
                root = root.right;
            } else {
                // If the key is smaller than the current node's value, move to the left subtree
                root = root.left;
            }
        }
        // Return the computed floor value
        return floor;
    }
}

// Class containing the main function
public class O2_floor_ceil {
    
    public static void printInOrder(TreeNode root) {
        
        if (root == null) return;

        printInOrder(root.left);

        System.out.print(root.val + " ");

        printInOrder(root.right);
    }

    // Main method
    public static void main(String[] args) {
        // Creating a BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        System.out.println("Binary Search Tree: ");
        printInOrder(root);
        System.out.println();

        Solution solution = new Solution();

        // Searching for a value in the BST
        int target = 8;
        int ceil = solution.findCeil(root, target);

        if (ceil != -1) {
            System.out.println("Ceiling of " + target + " is: " + ceil);
        } else {
            System.out.println("No ceiling found!");
        }
    }
}