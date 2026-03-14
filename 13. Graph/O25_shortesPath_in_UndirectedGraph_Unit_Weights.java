
import java.util.*;

class O25_shortesPath_in_UndirectedGraph_Unit_Weights {

    // Method to find the shortest path in an undirected graph with unit weights
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list for all nodes
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list from the given edges
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // Distance array to store shortest distance from source to each node
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9); // Initialize distances to a large value

        // Distance of source node to itself is always 0
        dist[src] = 0;

        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        // BFS to find shortest paths
        while (!q.isEmpty()) {
            int node = q.poll(); // Dequeue the front node

            // Traverse all adjacent nodes
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) { // If a shorter path is found
                    dist[it] = 1 + dist[node]; // Update distance
                    q.add(it); // Enqueue the neighbor
                }
            }
        }

        // Replace unreachable nodes' distance with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist; // Return the shortest distance array
    }

    // Main method to test the shortestPath function
    public static void main(String[] args) {
        O25_shortesPath_in_UndirectedGraph_Unit_Weights obj = new O25_shortesPath_in_UndirectedGraph_Unit_Weights();

        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}
        };
        int n = 5; // Number of nodes
        int m = edges.length; // Number of edges
        int src = 0; // Source node

        int[] result = obj.shortestPath(edges, n, m, src);

        System.out.println("Shortest distances from source node " + src + " are:");
        System.out.println(Arrays.toString(result));
    }
}
