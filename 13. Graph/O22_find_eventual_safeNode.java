// Java implementation of the above code

import java.util.*;

public class O22_find_eventual_safeNode {

    // To find safe states
    static ArrayList<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> al) {

        // Your code here
        int[] visit = new int[V];
        int[] path = new int[V];
        for (int i = 0; i < V; i++) {
            if (visit[i] == 0) {
                dfs(al, visit, path, i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (visit[i] == 1 && path[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    // Function to traverse over the nodes
    static boolean dfs(ArrayList<ArrayList<Integer>> al,
            int[] visit, int[] path, int sr) {
        visit[sr] = 1;
        path[sr] = 1;
        for (int i : al.get(sr)) {
            if (visit[i] == 0) {
                if (dfs(al, visit, path, i) == true) {
                    return true;
                }
            } else if (path[i] == 1) {
                return true;
            }
        }
        path[sr] = 0;
        return false;
    }

    // using BFS
    public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> al) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : al.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    // Driver code
    public static void main(String[] args) {

        int v = 6;
        ArrayList<ArrayList<Integer>> al
                = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<Integer>());
        }
        al.get(5).add(0);
        al.get(5).add(2);
        al.get(4).add(0);
        al.get(2).add(3);
        al.get(3).add(1);
        al.get(4).add(1);

        // Function call
        ArrayList<Integer> res = eventualSafeNodes(v, al);

        // Output
        System.out.println(res);
    }
}
