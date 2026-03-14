// sum of all nodes

class Node {

    int val; // int data
    Node left;
    Node right;

    Node(int data) {
        val = data;
        left = right = null;
    }
}

public class O30_sum_of_nodes {
    public static int SumFun(Node node){
        if(node == null) return 0;

        int left = SumFun(node.left);
        int right = SumFun(node.right);

        return node.val + left + right;
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
        
        // Print the accumulated tilt value
        System.out.println("Tree sum: ");
        System.out.println(SumFun(root));
    }
}
