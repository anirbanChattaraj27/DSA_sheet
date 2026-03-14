// can be solved using DFS or BFS
// chatgpt converted the code bfs to DFS

import java.util.*;

class Pair {

    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class O5_number_of_ISLANDs {

    // Function to find the number of islands
    public int numIslands(char[][] grid) { 
        int n = grid.length; // row size
        int m = grid[0].length; // column size
        int[][] vis = new int[n][m]; // visited array of size grid
        int cnt = 0;

        for (int row = 0; row < n; row++) { // travarsing matrix in row
            for (int col = 0; col < m; col++) { // travarsing matrix in col
                
                if (vis[row][col] == 0 && grid[row][col] == '1') { // when i call DFS? ANS: if visited array is 0 means its not visited and if grid marsk as 1 means there is ISLAND
                    cnt++; // increase count
                    dfs(row, col, vis, grid); // call BFS/ DFS function. here BFS/ DFS will be count whenever in matrix 1s are not connected in any directions. like if 1s are connected with any 1s in 8 directions then cnt will not increase but if i do not find any 1s connected i will find water then i will call bfs fun again and count will increase
                }
            }
        }
        return cnt;
    }

    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1; // initialize with 1
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(ro, co)); // inside Q make sure to put row and col value but  directly i cant put 2 values but using pair class i can put 2 values inside Q
        int n = grid.length; // size of row
        int m = grid[0].length; // size of col

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove(); // first element will be removed FIFO

            // Traverse the neighbors and mark them if it's a land
            for (int delRow = -1; delRow <= 1; delRow++) { // deltaRow going -1 to +1
                for (int delCol = -1; delCol <= 1; delCol++) { // deltaCol going -1 ro +1

                    int nrow = row + delRow;// neighbour row // row means middle (r,c) 
                    int ncol = col + delCol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m // checking for validity
                            && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) { // checking for land
                        vis[nrow][ncol] = 1; // mark as visited
                        q.add(new Pair(nrow, ncol)); // storing neighbourROW, neighbourCol in Queue
                    }
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1; // mark as visited
        int n = grid.length; // row size
        int m = grid[0].length; // col size

        // Traverse all 8 directions
        for (int delRow = -1; delRow <= 1; delRow++) {
            for (int delCol = -1; delCol <= 1; delCol++) {
                int nrow = row + delRow; // neighboring row
                int ncol = col + delCol; // neighboring col

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m // checking for validity
                        && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) { // checking for land
                    dfs(nrow, ncol, vis, grid); // recursive DFS call
                }
            }
        }
    }
/*
    \ | /     // these are neighbours
   - r,c -    // these are Row, Col
    / | \     // these are neighbours
    there are 8 directions in which row,col can search for its neighbours if any one of its neighbours is 1 connect that island

    R-1,C-1   R-1,C   R-1,C+1     
           \    |    /
     R,C-1  - [R,C] -  R,C+1
           /    |    \
    R+1,C-1   R+1,C   R+1,C+1

    Above is the formula for all directions. 

    how is the formula varrying?

    ROW: 1st row r-1 3rd row r+1 [look row wise]
    R-1, R-1, R-1

     R    R    R 

    R+1, R+1, R+1

    COL: 1st col C-1 & 3rd col C+1 [look col wise]
    C-1    C    C+1
    C-1    C    C+1
    C-1    C    C+1
*/
    public static void main(String[] args) {
        O5_number_of_ISLANDs obj = new O5_number_of_ISLANDs();
        char[][] grid = {
            {'1', '0', '0', '1', '1'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'1', '0', '0', '1', '1'}
        };
        System.out.println("Number of Islands: " + obj.numIslands(grid));
    }
}
// S.C = O(N^2) + O(N^2) matrix and queue space
// T.C = O(N^2)