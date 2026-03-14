// Here, i am checking every node is sum of its left and right child or not.
// https://www.geeksforgeeks.org/problems/children-sum-parent/1

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class O10_3_childrean_sum_property {

    public static boolean isSumProperty(TreeNode root) {
        if (root == null)
            return true;

        // leaf node
        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.val;
        if (root.right != null)
            sum += root.right.val;

        if (root.val != sum)
            return false;

        return isSumProperty(root.left) && isSumProperty(root.right);
    }

    // to print the o/p in terminal i need this, apart from this i dont need this in
    // leetocde
    static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(35);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.print(isSumProperty(root));
        // inorder(root);
    }
}
