
import java.util.*;

class Node {

    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class O8_detect_cycle_in_BFS {

    // function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        int parent[] = new int[V]; // i think there is no use of parent array
        Arrays.fill(parent, -1);

        // if there are components in graph then this step is must
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(adj, i, vis, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent[]) { 
        Queue<Node> q = new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] = true;

        // until the queue is empty
        while (!q.isEmpty()) {
            // source node and its parent node
            int node = q.peek().first; // here in node varibale I am taking 
            int par = q.peek().second; // par = parent
            q.remove();

            // go to all the adjacent nodes
            for (Integer it : adj.get(node)) { // it will check for all adjacent nodes
                if (vis[it] == false) { // if adjacent node is not yet visited then then only add in Q
                    q.add(new Node(it, node)); // it= nodeItself and node= parent node which i initialized above
                    vis[it] = true; // and mark as visited in vis arr
                } 
                // if adjacent node is visited and is not its own parent node
                else if (par != it) { // when cycle will be formed then it means someone else already visited that node earlier in that case it make cycle obviously so return true
                    return true;
                }
            }
        }
        return false; // if no such cycle forms then return false
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        O8_detect_cycle_in_BFS obj = new O8_detect_cycle_in_BFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans) {
            System.out.println("1"); 
        }else {
            System.out.println("0");
        }
    }
}
