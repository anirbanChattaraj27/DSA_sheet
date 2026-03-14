// copy: 17
// For all the nodes from leftSubtree and rightSubtree  height must be <= 1;
class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O5_Balanced_BTree_or_NOT {

    public static boolean bruteForceApproch(Node node){
        if(node == null){
            return true;
        }

        int left_height = heightFun(node.left);
        int right_height = heightFun(node.right);

        if(Math.abs(left_height - right_height) > 1){
            return false;
        }

        return bruteForceApproch(node.left) && bruteForceApproch(node.right);
    }

    public static int heightFun(Node node){

        if(node == null) return 0;

        int lh = heightFun(node.left);
        int rh = heightFun(node.right);

        return 1+ Math.max(lh, rh);
    }


    // same code as of height of Btree and 2 extra line    
    public static boolean printOptimizedApproch(Node node){
        return OptimizedApproch(node) != -1;
    }
    
    public static int OptimizedApproch(Node node){
        if(node == null){
            return 0;
        }

        int lh = OptimizedApproch(node.left);
        int rh = OptimizedApproch(node.right);

        /* extra line (2 if block) */
        if(lh == -1 || rh == -1){
            return -1;
        }
        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    
    public static void main(String args[]) {

        // Original Tree:
        //         50
        //       /    \
        //      10    40
        //     / \ 
        //    30 20

        Node root = new Node(50);
        root.left = new Node(10);
        root.right = new Node(40);
        root.left.left = new Node(30);
        root.left.right = new Node(20);
        

        System.out.println("Tree is BTree or NOT: ");
        System.out.println(bruteForceApproch(root));
        System.out.println(printOptimizedApproch(root));
    }
}
