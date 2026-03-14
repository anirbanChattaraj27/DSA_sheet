// copy 33
// here i am just creating a treeNode which is not generic type
// remember: in interview they can give like a generic tree or like a normal node so u have structire fuinction based on that

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class O10_1_children_sum_property {

    public static void changeTree(TreeNode root) {
        if (root == null)
            return;

        int child = 0;
        if (root.left != null)
            child += root.left.val;
        if (root.right != null)
            child += root.right.val;

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null)
                root.left.val = root.val;
            else if (root.right != null)
                root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null)
            tot += root.left.val;
        if (root.right != null)
            tot += root.right.val;
        if (root.left != null || root.right != null)
            root.val = tot;
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

        /*
         *     50
         *    / \
         *   7   2
         *  / \ / \
         * 3  5 1  2
         */

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        changeTree(root);
        inorder(root);
        /*
                  58
                 /  \
               55    3
              /  \  / \
            50    5 1  2

        */
    }

}
