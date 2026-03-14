
import java.util.*;

// User function Template for Java
class Solution {

    private boolean dfsCheck(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        
        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check) == true) {
                    check[node] = 0; // if there is a cycle it can't add 1 // though not required to write this line as i have already initialized this in above
                    return true;
                }
            } 
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                check[node] = 0; // if there is a cycle it can't add 1 // though not required to write this line as i have already initialized this in above
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> safeNodes = new ArrayList<>();
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}

public class O17_find_eventual_safe_NODE {

    public static void main(String[] args) {
        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        Solution obj = new Solution();
        List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
