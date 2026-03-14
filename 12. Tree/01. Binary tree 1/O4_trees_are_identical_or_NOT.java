// copy 22 || striver Lec: 18
// 2 strees are same or not
// run loop over 2 trees and compare them if they are not similar return false;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class O4_trees_are_identical_or_NOT {

    // Function to check if two trees are identical
    public static boolean fun(Node p, Node q) {

        // If both are null → identical
        if (p == null && q == null) {
            return true;
        }

        // If one is null and other is not → not identical
        if (p == null || q == null) {
            return false;
        }
        

        // Check current node value and subtrees
        return (p.val == q.val)
                && fun(p.left, q.left)
                && fun(p.right, q.right);

        /*
        boolean isValueSame = (p.val == q.val);
        boolean isLeftSame = fun(p.left, q.left);
        boolean isRightSame = fun(p.right, q.right);

        return isValueSame && isLeftSame && isRightSame;

        */
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        /*
            Tree 1:
                  1
                 / \
                2   3
        */

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        /*
            Tree 2:
                  1
                 / \
                2   3
        */

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        boolean result = fun(root1, root2);
        System.out.println("Trees are identical: " + result);
    }
}
