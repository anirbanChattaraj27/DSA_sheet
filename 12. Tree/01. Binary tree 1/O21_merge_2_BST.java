// leetcode 617
// copy explanation

// i/p: root1= [1,3,2,5], root2= [2,1,3,null, 4,null,7]
// o/p: 3, 4, 5, 5, 4, null, 7

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class O21_merge_2_BST {

    Node root;
    Node root2;

    public static Node merge(Node node1, Node node2){ 

        if((node1 == null) &&( node2 == null)) return null;

        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }

        node1.data = node1.data + node2.data;
        node1.left = merge(node1.left, node2.left);
        node1.right = merge(node1.right, node2.right);

        return node1;
    }

    public static void main(String args[]) {
        O21_merge_2_BST tree = new O21_merge_2_BST();

        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(5);
        // tree.root.left.right = new Node(40);
        // tree.root.right.right = new Node(70);

        tree.root2 = new Node(2);
        tree.root2.left = new Node(1);
        tree.root2.right = new Node(3);
        // tree.root2.left.left = new Node(30);
        tree.root2.left.right = new Node(4);
        tree.root2.right.right = new Node(7);

        System.out.print(merge(tree.root, tree.root2));
    }
}

// code is not working bt leetcode code is working