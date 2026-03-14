
// leetcode 547: https://leetcode.com/problems/number-of-provinces/description/

// if input given in matrix form then convert in adjList is important to reduce time complexity

// i/p: [[1,0,1], [0,1,0], [1,0,1]] ---> adj is actually an adjacency matrix (even though it's in ArrayList<ArrayList<Integer>> form) [✅ Convert]
// i/p: [ [2], [], [0] ] ------> adj is already an adjacency list  [❌ No conversion]
import java.util.*;

public class O4_Count_noOf_provinces {
    
    /* FUNCTION 1 */
    // when input given as INTEGER maatrix // leetcode
    public int numProvinces1(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>()); // AdjucencyList
        }
        
        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) { // if[i][j] finds 1 then adjLs will add i and j // i!=j means dont include self nodes
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        // it is the main code // if in input adjList will be given then just perform bellow code no need to wwrite above code
        int[] vis = new int[V];
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjLs, vis);
            }
        }      
        return count;
    }

    /* FUNCTION 2 */
    // when parameter given as arrayList of matrix // GFG
    public static int numProvinces2(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>(); 

        for(int i = 0;i<V;i++) {
            adjLs.add(new ArrayList<Integer>()); 
        }
        
        // to change adjacency matrix to list 
        for(int i = 0;i<V;i++) {
            for(int j = 0;j<V;j++) {
                // self nodes are not considered 
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j); 
                    adjLs.get(j).add(i); 
                }
            }
        }

        // it is the main code // if in input adjList will be given then just perform bellow code no need to wwrite above code
        int vis[] = new int[V]; 
        int cnt = 0; 
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
               cnt++;
               dfs(i, adjLs, vis); 
            }
        }
        return cnt; 
    }

    /* FUNCTION 3 */
    // here directly adjList is given so no need to convert
    public int numProvinces3(ArrayList<ArrayList<Integer>> adjLs) {
        int V = adjLs.size();
        int[] vis = new int[V];
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjLs, vis);
            }
        }      
        return count;
    }

    // dfs traversal function 
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs , int vis[]) {
        vis[node] = 1; 
        for(Integer it: adjLs.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adjLs, vis); 
            }
        }
    }

    public static void main(String[] args)
    {
        O4_Count_noOf_provinces obj = new O4_Count_noOf_provinces();

        /* FUNCTION 1 */
        // adjacency matrix of integer arr
        int[][] isConnected = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };
        
        System.out.println(obj.numProvinces1(isConnected));

        /* FUNCTION 2 */
        // adjacency matrix of ArrayList
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        System.out.println(obj.numProvinces2(adj,3));

        /* FUNCTION 3 */
        // adjacency list representation
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        adjLs.add(new ArrayList<>(Arrays.asList(2))); // Node 0 -> 2
        adjLs.add(new ArrayList<>());                 // Node 1 -> (isolated)
        adjLs.add(new ArrayList<>(Arrays.asList(0))); // Node 2 -> 0

        System.out.println(obj.numProvinces3(adjLs)); // Output: 2
    }
}

/*
 * S.C = O(V + E) || O(N)
 * T.C = O(V + 2E)
 * 
 * S.C using matrix form O(V^2)
 * T.C using matrix form O(V^2)
 * 
 * / bellow 2 lines from chatGPT / 
 * Use an adjacency matrix if the graph is DENSE (E ≈ V²) or you frequently check for edges.
 * Use an adjacency list if the graph is SPARSE (E ≪ V²) or for efficient traversal.
*/

