
import java.util.*;

public class O9_detect_cycle_in_DFS {

    // if components are there in graph then NEED to run loop in every components then return function
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    // if components are NOT there in graph then do NOT need to run loop directly return function
    public boolean isCycle2(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        return dfs(1, -1, vis, adj);
    }

    // dfs algo
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;

        // go to all adjacent nodes
        for (int adjacentNode : adj.get(node)) {

            if (vis[adjacentNode] == 0) {
                if (dfs(adjacentNode, node, vis, adj) == true) {
                    return true;
                }
            } 

            // if adjacent node is visited and is not its own parent node
            else if (adjacentNode != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        O9_detect_cycle_in_DFS obj = new O9_detect_cycle_in_DFS();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = obj.isCycle(4, adj);

        if (ans) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
// o/p: 0
