// copy 11 (prepCoding)

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O112_Left_Clone_tree_to_normal_tree {
 
    Node root;

    public static Node leftCloneTONormalTree(Node node) {
        if(node == null){
            return null;
        }

        // Ensure node.left exists before accessing node.left.left
        Node lnn = (node.left != null) ? leftCloneTONormalTree(node.left.left) : null;        
        Node rnn = leftCloneTONormalTree(node.right); // RightNormalizedNode

        node.left = lnn;
        node.right = rnn;

        return node;
    }

    // Helper function to print the tree (inorder traversal)
    public static void printTree(Node node) {
        
        if (node == null) return;

        printTree(node.left);
        System.out.print(node.data + " ");
        printTree(node.right);
    }

    public static void main(String args[]) {

        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(8);  // Clone of 8
        root.left.left.left = new Node(3);
        root.left.left.left.left = new Node(3);  // Clone of 3
        root.left.right = new Node(5);
        root.left.right.left = new Node(5);  // Clone of 5
        root.right = new Node(2);
        root.right.left = new Node(2);  // Clone of 2
        root.right.right = new Node(6);

        root = leftCloneTONormalTree(root);

        System.out.println("Tree after conversion:");
        printTree(root);
    }
}
