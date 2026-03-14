/*COPY 17 */

/*BFS APPROCH */
import java.util.*;

class O19_Detect_cycle_in_Directed_graph {
    // Function to detect a cycle in a directed graph using Kahn's Algorithm (BFS)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];

        // Compute in-degree of each node
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue to store nodes with in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0; // Counter to count the number of nodes in topological order

        // Process nodes in BFS manner
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If count of nodes in topological order is equal to total nodes, no cycle
        return cnt != V;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example 1: Graph with a cycle
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Cycle present

        O19_Detect_cycle_in_Directed_graph obj = new O19_Detect_cycle_in_Directed_graph();
        System.out.println("Does the 1st graph have a cycle? " + obj.isCyclic(V, adj)); // Output: true

        // Example 2: Graph without a cycle
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj2.add(new ArrayList<>());
        }

        adj2.get(0).add(1);
        adj2.get(1).add(2);
        adj2.get(2).add(3); // No cycle

        System.out.println("Does the 2nd graph have a cycle? " + obj.isCyclic(V, adj2)); // Output: false
    }
}
