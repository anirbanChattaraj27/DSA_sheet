// copy 21
// maximum path from 1 node to another

class Node {

    int data; // int val
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class O7_max_path_sum {
 

    public static int mainFunc(Node node){
        
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE; 

        maxPathDown(node, arr); // Here, arr is passed by reference, meaning maxPathDown() can modify arr[0] directly.

        return arr[0];       
    }
    
    /* helper funC */
    private static int maxPathDown(Node node, int maxValArr[]){

        if(node == null){
            return 0;
        }

        /* extra line */
        int left = Math.max(0, maxPathDown(node.left, maxValArr));
        int right = Math.max(0, maxPathDown(node.right, maxValArr));

        maxValArr[0] = Math.max(maxValArr[0], (left + right + node.data));

        // It returns the maximum sum path from the current node down to one of its subtrees (either left or right).
        // This is why we return Math.max(left, right) + node.data;, because at each node, we can either take the left path or the right path, but not both in the returned value.
        return Math.max(left, right) + node.data; 
    }
    /*
     * Why don’t we return maxValArr[0] instead?
           * If we return maxValArr[0], it would not correctly propagate the downward path sum for recursive calls.
           * The function is recursive, and each call needs to return a meaningful value to its parent node.
           * The parent node needs the maximum single path sum (either from left or right) to continue calculating its own path sum.
           * maxValArr[0] stores the global maximum and does not represent a valid sum that can be extended upwards.
     */

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
        System.out.println(mainFunc(root));
    }
}
