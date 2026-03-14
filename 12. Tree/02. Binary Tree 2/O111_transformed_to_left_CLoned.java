
// copy 10 (prepCoding)
class Node {

    Node left, right;
    int data;

    Node(int key) {
        data = key;
        left = null;
        right = null;
    }

    Node(int key, Node left, Node right) {
        data = key;
        this.left = left;
        this.right = right;
    }
}

public class O111_transformed_to_left_CLoned {

    public static Node leftCloneTree(Node node) {
        if (node == null) {
            return null;
        }
        Node leftCloneRoot = leftCloneTree(node.left);
        Node rightCloneRoot = leftCloneTree(node.right);

        Node newNode = new Node(node.data, leftCloneRoot, null);

        node.left = newNode;
        node.right = rightCloneRoot;

        return node;
    }

    public static void printTreePreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " "); // Visit root first
        printTreePreOrder(node.left);  // Then left subtree
        printTreePreOrder(node.right); // Finally, right subtree
    }

    // Function to print the tree in inorder traversal
    public static void printTreeInOrder(Node node) {
        if (node == null) {
            return;
        }
        printTreeInOrder(node.left);
        System.out.print(node.data + " ");
        printTreeInOrder(node.right);
    }

    public static void printTreePostOrder(Node node) {
        if (node == null) return;
        printTreePostOrder(node.left);  // Visit left subtree first
        printTreePostOrder(node.right); // Then right subtree
        System.out.print(node.data + " "); // Finally, root node
    }

    public static void main(String[] args) {
        // Original Tree:
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

        root = leftCloneTree(root);

        System.out.println("Transformed Tree (Inorder Traversal):");

        printTreePreOrder(root);
        System.out.println();

        printTreeInOrder(root);
        System.out.println();
        
        printTreePostOrder(root);
    }
}
