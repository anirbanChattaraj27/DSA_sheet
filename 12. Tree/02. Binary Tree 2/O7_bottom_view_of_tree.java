// copy 30
import java.util.*;

// revision DONE


class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Pair {
    Node node;
    int vertical;

    Pair(Node node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}

public class O7_bottom_view_of_tree {

    public List<Integer> bottomView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        // Map to store the bottom view nodes automatically sorted by vertical column keys
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.node;
            int line = pair.vertical;
            
            // Always overwrite the map with the node's data for Bottom View
            mpp.put(line, node.data);
            
            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }
            
            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree using the unified 'Node' class
        //        20
        //       /  \
        //     8     22
        //    / \     \
        //   5   3     25
        //  /   / \    /
        // 4   10 14  28
        
        Node root = new Node(20);
        root.left = new Node(8); 
        root.right = new Node(22);
        
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        
        root.left.left.left = new Node(4);        
        root.left.right.left = new Node(10);      
        root.left.right.right = new Node(14);     
        root.right.right.left = new Node(28);     

        O7_bottom_view_of_tree solution = new O7_bottom_view_of_tree();

        // Get the Bottom View traversal
        List<Integer> bottomView = solution.bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for (int val : bottomView) {
            System.out.print(val + " ");
        }
    }
}


/*
When two or more nodes share the exact same vertical column, a Bottom View algorithm only cares about the lowest, last-seen node. 
Any node above it in the same column gets completely hidden from view.
*/


/*
Your Code: 
Time Complexity: 𝑂(𝑁log𝑁) | 
Space Complexity: 𝑂(𝑁)
*/