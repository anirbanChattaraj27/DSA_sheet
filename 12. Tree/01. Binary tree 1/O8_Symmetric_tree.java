// copy 27
class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSymmetric(Node root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(Node left, Node right) {
        // I can do any 1 forom bellow

        // if (left == null || right == null) {
        //     return left == right;
        // }
        // if (left.val != right.val) {
        //     return false;
        // }

        if (left == null && right == null) return true;  // Both subtrees are null
        if (left == null || right == null) return false; // One subtree is null
        if (left.val != right.val) return false;         // Values must match

        // Recursively check symmetry for left-right and right-left pairs
        return isSymmetricHelp(left.left, right.right) &&
               isSymmetricHelp(left.right, right.left);
    }
}

public class O8_Symmetric_tree {
    public static void main(String[] args) {
        // Create a sample symmetric tree
/*
                    1  
                   / \  
                  2   2  
                 / \ / \  
                3  4 4  3  
*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        Solution solution = new Solution();
        boolean result = solution.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}