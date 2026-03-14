// prepcoding (hard)
// copy 14
// print diamter of the tree.
// diameter is the no. of edges between 2 farthest nodes in the tree

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O6_1_print_diameter {

    public static int heightFun(Node node){
        if(node == null){
            return -1;
        }

        int LH = heightFun(node.left);
        int RH = heightFun(node.right);

        int totalheight = Math.max(LH, RH) + 1;

        return totalheight;
    }

    public static int DiameterOfTree(Node node){
        if(node == null){
            return 0;
        }    
            
        int factor = heightFun(node.left) + heightFun(node.right) + 2;

        int LD = DiameterOfTree(node.left); // left Dia
        int RD = DiameterOfTree(node.right); // right Dia

        int dia = Math.max(factor, Math.max(LD, RD));

        return dia;
    }

    static class DiaPair{
        int height;
        int dia;
    }
    public static DiaPair DiameterOfTree2 (Node node){

        DiaPair leftPair = DiameterOfTree2(node.left);
        DiaPair rightPair = DiameterOfTree2(node.right);

        DiaPair myPair = new DiaPair();
        myPair.height = Math.max(leftPair.height, rightPair.height) +1;

        int FES = leftPair.height + rightPair.height + 2; // FactorEachSide
        myPair.dia = Math.max(FES, Math.max(leftPair.dia, rightPair.dia));

        return myPair;
    }

    public static void main(String args[]) {

        // Original Tree:
        //         10
        //       /    \
        //      8      2
        //     / \    /
        //    3   5  2
        //         \
        //          6

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.left.right.right = new Node(6);

        System.out.println("tree diameter: ");
        System.out.println(DiameterOfTree(root));
        // System.out.println(DiameterOfTree2(root));
    }
}
