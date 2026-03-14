public class O4_3_min_path_sum_Grid_Tabulation {

    /*
     * Tabulation (Bottom-Up DP)
     * dp[i][j] stores minimum path sum to reach cell (i, j)
     */
    public static int minSumPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // 🔹 DP TABLE
        int[][] dp = new int[n][m];

        // Traverse row by row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Base case: Starting cell
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else {

                    int up = grid[i][j];
                    int left = grid[i][j];

                    // 🔹 Take value from top cell (if exists)
                    if (i > 0)
                        up += dp[i - 1][j];   // DP used here
                    else
                        up += (int) 1e9;      // Out of boundary

                    // 🔹 Take value from left cell (if exists)
                    if (j > 0)
                        left += dp[i][j - 1]; // DP used here
                    else
                        left += (int) 1e9;    // Out of boundary

                    // Store minimum of both
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        // Final answer at bottom-right
        return dp[n - 1][m - 1];
    }

    // Main method to test
    public static void main(String[] args) {

        int[][] grid = {{5, 9, 6},
                        {11, 5, 2}};

        int result = minSumPath(grid);

        System.out.println("Minimum Path Sum (Tabulation): " + result);
    }
}
