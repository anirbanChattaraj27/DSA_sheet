// copy: 4 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class O7_InOrder_Successor_in_BST {

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {

            // if given val > root's val; go to right
            if (p.val >= root.val) {
                root = root.right;
            } 
            
            // if given value < root's val; go to left
            else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    // Home WOrk
    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        return root;
    }

    public static void main(String[] args) {

        /*
                6
               / \
              2   8
             / \   \
            0   4   9
               /
              3
        */

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);

        root.right.right = new TreeNode(9);

        TreeNode p = root.left.right; // Node with value 4

        TreeNode successor = inorderSuccessor(root, p);

        if (successor != null) {
            System.out.println("Inorder Successor of " + p.val + " is: " + successor.val);
        } else {
            System.out.println("Inorder Successor does not exist");
        }
    }
}
