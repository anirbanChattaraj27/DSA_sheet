
import java.util.*;

public class O14_Bipartite_BFS {

    private boolean checkBFS(int start, int V, ArrayList<ArrayList<Integer>> adj, int color[]) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start); // adding 1st node into Q
        color[start] = 0; // make sure to color intial idx with color 0

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node 
                if (color[it] == -1) {

                    color[it] = 1 - color[node];
                    q.add(it);
                } 
                // HEY! is the adjacent guy having the same color ?
                // that means someone did color it on some other path 
                else if (color[it] == color[node]) {
                    return false; // not a bipartite graph
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1; // make all idx of color arr as -1 // color[] arr is nothing bt vist[] arr
        }

        // if there are multiple components in the graph then i have to do this
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (checkBFS(i, V, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList< ArrayList< Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        O14_Bipartite_BFS obj = new O14_Bipartite_BFS();
        boolean ans = obj.isBipartite(4, adj);
        if (ans) {
            System.out.println("1"); 
        }else {
            System.out.println("0");
        }
    }
}
/*
 * T.C and S.C is same as BFS algorithm
 */