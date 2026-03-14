// if not understand then watch the video only code part
// https://youtu.be/yf3oUhkvqA0?si=wVH9P4YrWB2r5zzl&t=782
import java.util.*;

class Pair {
    int row;
    int col;
    int tm;

    Pair(int _row, int _col, int _tm) {
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}

class O7_rotten_oranges {

    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid) {
        // figure out the grid size
        int n = grid.length;
        int m = grid[0].length;
        // n x m 
        Queue<Pair> q = new LinkedList<>(); // row, col, time store in Q
        // n x m 
        int[][] vis = new int[n][m]; // copyArr created of size n and m
        int cntFresh = 0;

        // travarsing grid and count number of fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) { // if cell contains rotten orange
                    q.add(new Pair(i, j, 0)); // inside queue i pushed i, j, 0. 0 means time and i,j is the value of matrix
                    // mark as visited (rotten) in visited array
                    vis[i][j] = 2; // mark vis arr with 2 as it is rotten 
                } 
                else { // if not rotten
                    vis[i][j] = 0;
                }

                // count fresh oranges
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        // BFS
        int tm = 0;
        // delta row and delta column
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int cnt = 0;

        // until the queue becomes empty
        while (!q.isEmpty()) {
            int r = q.peek().row; // Q is contains 3 obj R, C, tm and when i a calling peek.row means from peek of Q give me only row value
            int c = q.peek().col; // from peek of Q give me only col
            int t = q.peek().tm; // from peek of Q give me only tm
            tm = Math.max(tm, t);
            q.remove();
            // exactly 4 neighbours
            for (int i = 0; i < 4; i++) { // there are exactly 4 neighbours right left up down
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                // check for valid coordinates and 
                // then for unvisited fresh orange
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m // validity check
                        && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {

                    q.add(new Pair(nrow, ncol, t + 1)); // nRow and nCol pushed in Q with increasing time
                    // mark as rotten
                    vis[nrow][ncol] = 2;
                    cnt++; // number oranges that rott (here i am not counting oranges which are already rotten before starting algortithm)
                }
            }
        }

        // if all oranges are not rotten
        if (cnt != cntFresh) { // if rotten oranges and fresh oranges are not same return -1
            return -1;
        }
        return tm; // here i am returing time how much time it take to rotten all oranges
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, 
                        {0, 1, 2}, 
                        {2, 1, 1}};

        O7_rotten_oranges obj = new O7_rotten_oranges();
        int ans = obj.orangesRotting(grid);
        System.out.println(ans);
    }

}
