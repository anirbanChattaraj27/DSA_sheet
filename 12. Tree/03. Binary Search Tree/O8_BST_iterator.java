// copy: 5

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BSTiterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTiterator(TreeNode root) {
        pushAll(root);
    }

    /* @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /* @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}

public class O8_BST_iterator {
    public static void main(String[] args) {

        /*
              7
             / \
            3   15
               / \
              9  20
        */

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTiterator iterator = new BSTiterator(root);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}


