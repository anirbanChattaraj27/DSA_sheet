
// this is same as 1st one, here i only use generic type node, if in interfiew they will give this tree this is the way of solving, i do not have to do anything i only have to write func
public class O10_2_children_sum_property {

    // Binary Tree Node definition
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to enforce Children Sum Property
    public static void changeTree(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null) root.left.data = root.data;
            else if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null) tot += root.left.data;
        if (root.right != null) tot += root.right.data;
        if (root.left != null || root.right != null) root.data = tot;
    }

    // Inorder traversal for testing
    public static void inorder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Main method
    public static void main(String[] args) {

        /*
              50
             /  \
           7     2
          / \   /
         3   5 1
        */

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(50);
        root.left = new BinaryTreeNode<>(7);
        root.right = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(1);

        System.out.println("Inorder before enforcing Children Sum Property:");
        inorder(root);

        changeTree(root);

        System.out.println("\nInorder after enforcing Children Sum Property:");
        inorder(root);
    }
}

