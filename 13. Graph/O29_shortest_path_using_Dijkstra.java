
import java.util.*;

// Helper class to store pairs (node, distance)
class Pair {
    int first, second;
    
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class O29_shortest_path_using_Dijkstra {

    // Function to find the shortest path using Dijkstra's algorithm
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Building the adjacency list with given edges
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        // Priority queue for Dijkstra's algorithm (min-heap based on distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.first));
        int[] dist = new int[n];
        int[] parent = new int[n];

        // Initialize distances with a large value
        Arrays.fill(dist, (int) 1e9);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Start from node 0
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.second;
            int dis = it.first;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        // Retrieve the shortest path
        List<Integer> path = new ArrayList<>();
        if (dist[n - 1] == (int) 1e9) {
            path.add(-1); // No path found
            return path;
        }

        int node = n - 1;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(0);
        Collections.reverse(path);
        return path;
    }

    // Main function to test the shortest path algorithm
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        int[][] edges = {{0, 1, 2}, {1, 2, 4}, {0, 3, 1}, {3, 4, 3}, {4, 2, 1}, {1, 4, 7}};

        List<Integer> path = shortestPath(n, m, edges);
        System.out.println("Shortest Path: " + path);
    }
}
