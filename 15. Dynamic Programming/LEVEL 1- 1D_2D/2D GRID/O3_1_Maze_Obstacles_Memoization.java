// this code is exactly same as per bellow code just need to write 1 base case

import java.util.Arrays;

public class O3_1_Maze_Obstacles_Memoization {

    // Mod value to prevent overflow
    static int mod = (int) (1e9 + 7);

    /*
     * Recursive function with Memoization
     *
     * i, j  -> current cell
     * mat   -> obstacle grid
     * dp    -> memoization table
     */
    public static int f(int i, int j, int[][] mat, int[][] dp) {

        // 🔴 If cell is obstacle, no path possible
        if (i >= 0 && j >= 0 && mat[i][j] == -1)
            return 0;

        // 🔵 Base case: reached starting cell
        if (i == 0 && j == 0)
            return 1;

        // 🔴 Out of bounds
        if (i < 0 || j < 0)
            return 0;

        // 🔵 DP CHECK (Memoization used here)
        // If already computed, return stored value
        if (dp[i][j] != -1)
            return dp[i][j];

        // Recursive calls (Top-Down approach)
        int up = f(i - 1, j, mat, dp);
        int left = f(i, j - 1, mat, dp);

        // 🔵 Store result in DP before returning
        // This prevents recomputation
        return dp[i][j] = (up + left) % mod;
    }

    public static int mazeObstacles(int n, int m, int[][] mat) {

        // 🔵 DP array creation
        int[][] dp = new int[n][m];

        // Initialize with -1 (important for memoization check)
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start from bottom-right cell
        return f(n - 1, m - 1, mat, dp);
    }

    public static void main(String[] args) {

        // 0 -> free cell
        // -1 -> obstacle
        int[][] mat = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = mat.length;
        int m = mat[0].length;

        System.out.println("Number of Paths (with obstacles): "
                + mazeObstacles(n, m, mat));
    }
}
