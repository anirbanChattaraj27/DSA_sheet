
// LeetCode 938: Range Sum of BST
// copy 4

class TreeNode {
    int val;
    O5_vertical_travarsal left;
    O5_vertical_travarsal right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class O104_range_sum_BST {

    public static int rangeSumBST(O5_vertical_travarsal root, int low, int high) {
        int sum = 0;
        if (root == null) return 0;
        
        if (root.val >= low && root.val <= high)
            sum += root.val;
         
        if (root.val > low)
            sum += rangeSumBST(root.left, low, high);

        if (root.val < high) 
            sum += rangeSumBST(root.right, low, high);

        return sum;
    }


    public static int rangeSumBST2(O5_vertical_travarsal root, int low, int high) {

        // Base case
        if (root == null) {
            return 0;
        }

        // If node value is smaller than range, skip left subtree
        if (root.val < low) {
            return rangeSumBST2(root.right, low, high);
        }

        // If node value is greater than range, skip right subtree
        if (root.val > high) {
            return rangeSumBST2(root.left, low, high);
        }

        // Node is within range
        return root.val
                + rangeSumBST2(root.left, low, high)
                + rangeSumBST2(root.right, low, high);
    } 

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        /*
                 10
               /    \
              5      15
             / \       \
            3   7       18
        */

        O5_vertical_travarsal root = new O5_vertical_travarsal(10);
        root.left = new O5_vertical_travarsal(5);
        root.right = new O5_vertical_travarsal(15);
        root.left.left = new O5_vertical_travarsal(3);
        root.left.right = new O5_vertical_travarsal(7);
        root.right.right = new O5_vertical_travarsal(18);

        int low = 7;
        int high = 15;

        int result = rangeSumBST(root, low, high);
        int result2 = rangeSumBST2(root, low, high);
        System.out.println("Range Sum BST = " + result);
        System.out.println("Range Sum BST = " + result2);
    }
}
