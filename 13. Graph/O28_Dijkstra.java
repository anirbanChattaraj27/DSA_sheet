
import java.util.*;

// Class to implement Dijkstra's Algorithm
class O28_Dijkstra {

    // Function to find the shortest distances from the source vertex S to all vertices
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Min-heap priority queue to store (distance, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        // Distance array initialized to a large value (infinity)
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        // Distance to the source is always 0
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Traverse all adjacent nodes
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // Relaxation step: update the shortest distance if a shorter path is found
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist; // Return the shortest distance array
    }

    // Pair class to store distance and node
    static class Pair {

        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    // Main method to test Dijkstra's Algorithm
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int S = 0; // Source vertex

        // Adjacency list representation of graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph edges: {source, destination, weight}
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        // Running Dijkstra's Algorithm
        int[] shortestDistances = dijkstra(V, adj, S);

        // Printing shortest distances from source
        System.out.println("Shortest distances from source vertex " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> " + shortestDistances[i]);
        }
    }
}
