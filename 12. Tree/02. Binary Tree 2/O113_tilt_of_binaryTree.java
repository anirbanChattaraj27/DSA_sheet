// copy 15
// understand code and watch vdo

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O113_tilt_of_binaryTree {

    static int tilt = 0; // declare globally

    public static int tilt(Node node){

        if(node == null){
            return 0;
        }        

        int leftSide = tilt(node.left);
        int rightSide = tilt(node.right);

        int ltilt = Math.abs(leftSide - rightSide);
        tilt += ltilt;

        int ts = leftSide + rightSide + node.data;

        return ts;        
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

        // Call the tilt function and print the result
        tilt(root);
        
        // Print the accumulated tilt value
        System.out.println("Tree tilt: ");
        System.out.println(tilt);
    }
}
