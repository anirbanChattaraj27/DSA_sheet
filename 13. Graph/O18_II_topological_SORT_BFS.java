
/* copy 16 */

import java.util.*;
 
class O18_II_topological_SORT_BFS {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];

        // Calculate in-degree of each node
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V]; // Array to store topological ordering
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.poll(); // Get front node
            topo[i++] = node; // Store it in result

            // Reduce in-degree of its neighbors
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo; // Return topological order
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph (Directed Acyclic Graph - DAG)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Get topological order
        int[] topoOrder = topoSort(V, adj);

        // Print topological order
        System.out.println("Topological Sorting of the given graph:");
        for (int node : topoOrder) {
            System.out.print(node + " ");
        }
    }
}
