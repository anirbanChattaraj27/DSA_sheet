import java.util.*;

class O21_Course_schedule_II {
    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // Create adjacency list for graph representation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph: prerequisites[i] = [a, b] means b → a
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        // Step 1: Compute in-degree of all nodes
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 2: Push nodes with in-degree 0 into the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: Perform Kahn’s Algorithm (BFS)
        int topo[] = new int[n];
        int ind = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[ind++] = node;

            // Reduce in-degree of adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If all courses can be completed, return the order
        if (ind == n) return topo;

        // Otherwise, return an empty array (cycle detected)
        return new int[0];
    }

    public static void main(String[] args) {
        int n = 4, m = 3; // Number of courses & prerequisites
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();

        // Adding prerequisites: [a, b] means to take a, you must first complete b
        prerequisites.add(new ArrayList<>(Arrays.asList(1, 0)));
        prerequisites.add(new ArrayList<>(Arrays.asList(2, 1)));
        prerequisites.add(new ArrayList<>(Arrays.asList(3, 2)));
        // prerequisites.add(new ArrayList<>(Arrays.asList(1, 3))); // Creates a cycle!

        int[] order = findOrder(n, m, prerequisites);

        if (order.length == 0) {
            System.out.println("No valid course order (Cycle detected)!");
        } else {
            System.out.println("Valid course order: " + Arrays.toString(order));
        }
    }
}
