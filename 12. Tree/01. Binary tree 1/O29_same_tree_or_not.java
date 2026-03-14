// https://leetcode.com/problems/same-tree/description/
// copy: 22

class Node {

    int val; // int data
    Node left;
    Node right;

    Node(int data) {
        val = data;
        left = right = null;
    }
}

public class O29_same_tree_or_not {
    public boolean isSameTree(Node p, Node q){
        if(p == null || q == null){
            return p == q;
        } 
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        
    }
}
