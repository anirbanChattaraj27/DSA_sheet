/* copy 18 */

import java.util.*;

public class O20_Course_schedule_I {
    public boolean isPossible(int V, int[][] prerequisites) {
        // Step 1: Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build graph (prerequisites[i] = {a, b} means b → a)
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Step 3: Compute in-degree for each course
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 4: Push nodes with in-degree 0 into queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 5: Perform BFS (Kahn’s Algorithm)
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            // Reduce in-degree for adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Step 6: If we processed all courses, return true (No cycle detected)
        return topo.size() == V;
    }

    public static void main(String[] args) {
        O20_Course_schedule_I obj = new O20_Course_schedule_I();

        int V1 = 4;
        int[][] prerequisites1 = { {1, 0}, {2, 1}, {3, 2} };
        System.out.println("Can finish all courses? " + obj.isPossible(V1, prerequisites1)); // true

        int V2 = 4;
        int[][] prerequisites2 = { {1, 0}, {2, 1}, {3, 2}, {1, 3} }; // Cycle exists!
        System.out.println("Can finish all courses? " + obj.isPossible(V2, prerequisites2)); // false
    }
}
