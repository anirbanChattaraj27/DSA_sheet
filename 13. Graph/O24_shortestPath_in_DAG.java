
import java.util.*;

// Class to represent a directed edge with a weight
class Pair {

    int first, second;

    Pair(int _first, int _second) {
        this.first = _first; // Destination node
        this.second = _second; // Weight of the edge
    }
}

class O24_shortestPath_in_DAG {

    // Function to perform topological sorting using DFS
    private void dfs(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1; // Mark the node as visited

        // Traverse all adjacent nodes
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first; // Get the adjacent node
            if (vis[v] == 0) { // If not visited, call DFS
                dfs(v, adj, vis, st);
            }
        }

        st.add(node); // Push the node to the stack after visiting all adjacent nodes
    }

    // Function to find the shortest path in a Directed Acyclic Graph (DAG)
    public int[] shortestPath(int N, int M, int[][] edges) {
        // Create an adjacency list for the graph bcz i/p is in matrix form 
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // Source node
            int v = edges[i][1]; // Destination node
            int wt = edges[i][2]; // Weight of the edge
            adj.get(u).add(new Pair(v, wt));
        }

        // topoSort starts here
        int vis[] = new int[N]; // Visited array for topological sorting
        Stack<Integer> st = new Stack<>(); // Stack to store topological order

        // Perform topological sorting for all unvisited nodes
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, st);
            }
        }

        // Initialize distance array with a large value (infinity equivalent)
        int dist[] = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0; // Assuming the source node is 0

        // Process nodes in topological order
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            // Relax edges from the current node
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first; // Destination node
                int wt = adj.get(node).get(i).second; // Edge weight

                // Update the shortest distance if a shorter path is found
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

    /* Replace unreachable nodes' distances with -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }   from chatGPT */
        return dist; // Return the shortest path distances
    }

    public static void main(String[] args) {
        O24_shortestPath_in_DAG obj = new O24_shortestPath_in_DAG();
        int N = 6, M = 7;
        int[][] edges = {
            {0, 1, 2}, {0, 4, 1}, {1, 2, 3}, {2, 3, 6},
            {4, 2, 2}, {4, 5, 4}, {5, 3, 1}
        };

        // Compute shortest paths from source node 0
        int[] result = obj.shortestPath(N, M, edges);

        // Print the shortest distances from source node 0
        System.out.println("Shortest distances from source node 0:");
        System.out.println(Arrays.toString(result));
    }
}
