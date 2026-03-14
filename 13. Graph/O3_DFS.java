import java.util.*;

public class O3_DFS {
    // Helper function for DFS traversal
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        // Mark the current node as visited
        vis[node] = true;
        ls.add(node);

        // get all neighbour nodes
        for (Integer x : adj.get(node)) {
            if (!vis[x]) {
                dfs(x, vis, adj, ls);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V]; // Boolean array to track visited nodes
        ArrayList<Integer> ls = new ArrayList<>(); // List to store DFS traversal
        
        // Performing DFS from node 0 (assuming 0-based index)
        dfs(0, vis, adj, ls);
        
        return ls;
    }

    // Main function to test DFS traversal
    public static void main(String[] args) {
    ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }

        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        
        O3_DFS sl = new O3_DFS(); 

        ArrayList < Integer > ans = sl.dfsOfGraph(5, adj);
        int n = ans.size(); 

        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }
}
