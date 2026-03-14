
// print the nodes which have single child

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O27_print_single_child_node {

    public static void fun(Node node, Node parent){

        if(node == null) return;

        if(parent != null && parent.left == node && parent.right == null){
            System.out.println(node.data);
        }
        else if(parent != null && parent.right == node && parent.left == null){
            System.out.println(node.data);
        }

        fun(node.left, node);
        fun(node.right, node);
    }

    public static void main(String args[]) {

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);  // Node 2 has a single child (6)
        root.left.right.left = new Node(7);  // Node 5 has a single child (7)

        fun(root, null);
    }
}
