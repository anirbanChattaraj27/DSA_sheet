// https://youtu.be/d97z0fGBjpE?si=YCxJXDzgA3Wd_2pV

import java.lang.*;
import java.util.*;
import javax.swing.RootPaneContainer;

class Node {

    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class O3_iterative_in_pre_post_order {

    Node root;

    public static ArrayList<Integer> preOrder(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(node == null){
            return list;
        }

        Stack<Node> st = new Stack<>();
        st.push(node);

        while(!st.isEmpty()){
            node = st.pop();
            list.add(node.data);

            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return list;
    }

    public static ArrayList<Integer> inOrder(Node root) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }

    public static void main(String args[]) {
        O2_level_order_traversal tree = new O2_level_order_traversal();

        tree.root = new Node(20);
        tree.root.left = new Node(70);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.right.right = new Node(70);

        tree.preOrder(tree.root);
    }
}
