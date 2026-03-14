// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/

// Given a binary tree and a sum, return true if the tree has a root-to-leaf path such that adding 
// up all the values along the path equals the given sum. Return false if no such path can be found. 
// i/p:  10, 8, 2, 3, 5, 2
// 10 -> 8 -> 3  =  21
// 10 -> 8 -> 5  = 23
// 10 -> 2 -> 2 = 14
// So it is possible to get sum = 21

class Node {
    Node left, right;
    int data;

    Node(int key) {
        data = key;
        left = null;
        right = null;
    }
}

public class O24_Root_to_leaf_path_sum_equal_to_a_given_number {
  
    // Given a tree and a sum, return true if there is a path from
    // the root down to a leaf, such that adding up all the values
    // along the path equals the given sum.
    static boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;

        int subSum = sum - root.data;

        // If we reach a leaf node and sum becomes 0 then return true
        if (subSum == 0 && root.left == null 
            && root.right == null) return true;

        // Otherwise check both subtrees
        boolean left = false, right = false;

        if (root.left != null) left = hasPathSum(root.left, subSum);
        if (root.right != null) right = hasPathSum(root.right, subSum);

        return left || right;
    }

    public static void main(String[] args) {
        int sum = 21;

        // Constructed binary tree is
        //         10
        //       /    \
        //      8      2
        //     / \    /
        //    3   5  2

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        System.out.println(hasPathSum(root, sum));
    }
}
