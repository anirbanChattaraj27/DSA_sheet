/*
GFG: https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
copy: 10

You are given an undirected graph consisting of v vertices and a list of edges, along with an integer m. 
Your task is to determine whether it is possible to color the graph using at most m different colors such that 
no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, 
otherwise return false.

Note: The graph is indexed with 0-based indexing.

Input: v = 3, edges[] = [(0,1),(1,2),(0,2)], m = 2
Output: false
Explanation: It is not possible to color the given graph using only 2 colors because vertices 0, 1, and 2 form a triangle.

Input: v = 4, edges[] = [(0,1),(1,2),(2,3),(3,0),(0,2)], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:
Vertex 0: Color 3
Vertex 1: Color 2
Vertex 2: Color 1
Vertex 3: Color 2
*/

import java.util.*;

class O3_M_Coloring_graph {

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        for (int it : G[node]) { // in graph chapter i will understand this so no need to worry
            if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(List<Integer>[] G, int[] color, int m) {
        int n = G.length;
        return solve(0, G, color, n, m);
    }

    public static void main(String[] args) {
        int n = 4; // Number of vertices
        int m = 3; // Number of colors

        List<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }

        // Defining the graph (Undirected)
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);

        int[] color = new int[n]; // Coloring array

        if (graphColoring(G, color, m)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
