
import java.util.*;

class Pair {

    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class O13_Num_of_Distinct_Island {

    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> list, int row0, int col0) {
        vis[row][col] = 1;
        list.add(toString(row - row0, col - col0));

        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, -1, 0, +1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, list, row0, col0);
            }
        }
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) { // start travarsing matrix
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {  
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, list, i, j);
                    st.add(list);
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };

        O13_Num_of_Distinct_Island obj = new O13_Num_of_Distinct_Island();
        int result = obj.countDistinctIslands(grid);
        System.out.println("Number of distinct islands: " + result);
    }
}
