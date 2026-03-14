import java.util.Arrays;

public class O4_2_min_path_sum_Grid_Memoization {

    /*
     * Recursive function with Memoization
     * dp[i][j] stores the minimum path sum to reach (i,j)
     */
    public static int f(int i, int j, int[][] grid, int[][] dp) {

        // Base Case: Starting cell
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        // Out of bounds case
        if (i < 0 || j < 0) {
            return (int) 1e9;  // Large value (acts like infinity)
        }

        // 🔹 DP USED HERE:
        // If already calculated, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move UP
        int up = grid[i][j] + f(i - 1, j, grid, dp);

        // Move LEFT
        int left = grid[i][j] + f(i, j - 1, grid, dp);

        // 🔹 Store result in DP before returning
        dp[i][j] = Math.min(up, left);

        return dp[i][j];
    }

    /*
     * Main function to initialize dp array
     */
    public static int minSumPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // DP array initialized with -1
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n - 1, m - 1, grid, dp);
    }

    // Main method to test
    public static void main(String[] args) {

        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int result = minSumPath(grid);

        System.out.println("Minimum Path Sum (Memoization): " + result);
    }
}
