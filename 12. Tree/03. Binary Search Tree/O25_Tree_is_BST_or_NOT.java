// copy: 16
// tree is BST or not

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O25_Tree_is_BST_or_NOT {
    
    static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node){
        if (node == null){
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;

            bp.isBST = true;
            return bp;
        }

        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair mp = new BSTPair();

        mp.isBST =  leftPair.isBST && rightPair.isBST && 
                    (node.data >= leftPair.max && 
                    node.data <= rightPair.min);

        mp.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        mp.max = Math.max(node.data, Math.max(leftPair.max, rightPair.max));

        return mp;
    }

    public static void main(String args[]) {

        // Original Tree:
        //         50
        //       /    \
        //      30    60
        //     / \ 
        //    20 40

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        System.out.println("tree diameter: ");
        System.out.println(isBST(root));
    }
}
