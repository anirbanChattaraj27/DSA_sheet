
// maximum from all nodes


class Node {

    int val; // int data
    Node left;
    Node right;

    Node(int data) {
        val = data;
        left = right = null;
    }
}

public class O0_basic_methods_of_tree {

    // print maximumm node from all node
    public static int maxNodeOfTree(Node node){
        if(node == null) return 0;

        int left = maxNodeOfTree(node.left);
        int right = maxNodeOfTree(node.right);

        return Math.max(node.val, Math.max(left, right));
    }

    // copy 7
    public static int heightOfTree(Node node){
        if(node == null) return 0;

        int left = heightOfTree(node.left);
        int right = heightOfTree(node.right);

        return 1 + Math.max(left, right);
    }

    public static boolean searchInTree(Node node, int key){
        if(node == null) return false;

        if(node.val == key){
            return true;
        }

        boolean left = searchInTree(node.left, key);
        boolean right = searchInTree(node.right, key);

        if (left) {
            return true;
        } 
        
        if(right){
            return true;
        }
        return false;
    }

    //public static Node reverseTree(Node node){
        
    //}
    
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
        System.out.println(maxNodeOfTree(root));
    }
}
