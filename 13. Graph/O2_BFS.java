/*
 * Level Order Traversal or BFS
*/
// copy 1

import java.util.*;

public class O2_BFS {

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // adding 0 in Q
        vis[0] = true; // 1st idx of vis set to true

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer x : adj.get(node)) { // running a loop in graph nodes
                if (vis[x] == false) { // if vis arr index is false means not yet visited
                    vis[x] = true; // mark it as true // x represents a node number // for-each gives node numbers, so vis[x] is valid.
                    q.add(x); // and add it into Q
                }
            }
        }
        return bfs;
    }

    public static void main(String args[]) {

        ArrayList< ArrayList< Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        O2_BFS sl = new O2_BFS();

        ArrayList< Integer> ans = sl.bfsOfGraph(5, adj);
        int n = ans.size();

        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
