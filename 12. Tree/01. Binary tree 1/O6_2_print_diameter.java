// Striver's solution (Recomended)
// diameter = no of edges between 2 farthest nodes in a tree 
class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O6_2_print_diameter {

    // O(n^2)
    // if i implement findHeightOfTree wala code i always have findLeftHeight & findRightheight code
    // O(n)
    // so if i have LH and RH (in heightFun) do we need to find height again? ans: NO
    // we will use same code LH and RH and use max variable and take maximum of them 
    /*
     *  Global static maxi allows the value of the maximum diameter to persist across all recursive calls, ensuring that the largest diameter is tracked throughout the traversal of the tree.
     *  Without it, the function would not retain the maximum diameter and would fail to give the correct result.
     */
    

    // O(n^2)
    static int maxi = 0; // declare globally
    public static int DiameterOfTree(Node node){

        if(node == null){
            return 0;
        }

        int lh = heightFun(node.left);
        int rh = heightFun(node.right);

        maxi = Math.max(maxi, (lh + rh));

        DiameterOfTree(node.left);
        DiameterOfTree(node.right);

        return maxi;
    }

    public static int heightFun(Node node){
        if(node == null){
            return 0;
        }

        int LH = heightFun(node.left);
        int RH = heightFun(node.right);

        return 1 + Math.max(LH, RH);
    }

    // O(n)
    // why i pass max[] arr not max variable? explained above
    public static int DiameterOfTree2(Node root){ 
        int newMax[] = new int [1];
        heightFun2(root, newMax);
        return newMax[0];
    }

    private static int heightFun2(Node node, int max[]){
        if(node == null){
            return 0;
        }

        int LH = heightFun2(node.left, max);
        int RH = heightFun2(node.right, max);

        max[0] = Math.max(max[0], LH + RH);

        return 1 + Math.max(LH, RH);
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
        System.out.println(DiameterOfTree2(root));
        System.out.println(DiameterOfTree(root));
    }
}

/*
            THIS CODE WILL NOT WORK bcz:
    // Java is strictly a pass-by-value language. When a method is 
    // called, a copy of the variable's value is passed to the 
    // method. This means that any changes made to the parameter
    // inside the method do not affect the original variable outside the method

    // Primitive types (e.g., int, float, boolean) are always passed by value.

    public static int DiameterOfTree2(Node root){
        int max = 0;
        heightFollowUPFun(root, max);
        return max;
    }
    
    private static int heightFollowUPFun(Node node, int max){
        if(node == null){
            return 0;
        }

        int LH = heightFollowUPFun(node.left, max);
        int RH = heightFollowUPFun(node.right, max);

        max = Math.max(max, LH + RH);

        return 1 + Math.max(LH, RH);
    }
*/ 