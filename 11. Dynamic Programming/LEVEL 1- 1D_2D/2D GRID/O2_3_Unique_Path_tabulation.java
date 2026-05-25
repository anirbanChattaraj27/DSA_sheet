public class O2_3_Unique_Path_tabulation {

    public static int uniquePaths(int m, int n) {

        /*
         * ================================
         * TABULATION VERSION (Bottom-Up DP)
         * ================================
         *
         * CHANGES FROM MEMOIZATION:
         *
         * 1. Removed recursive function f(i, j, dp)
         * 2. Removed memoization check (dp[i][j] != -1)
         * 3. Removed out-of-bound base case (i < 0 || j < 0)
         * 4. Replaced recursive calls with dp table lookups
         * 5. Fill table iteratively using loops
         *
         * SAME LOGIC:
         * dp[i][j] = number of ways to reach cell (i, j)
         * dp[i][j] = dp[i-1][j] + dp[i][j-1]
         */

        // Step 1: Create DP table
        int[][] dp = new int[m][n];

        // Step 2: Fill table row by row (Bottom-Up)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Base Case (Same as memoization but assigned instead of returned)
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;  // Starting cell has 1 way
                } else {

                    int up = 0;
                    int left = 0;

                    // Instead of recursive call f(i-1, j)
                    if (i > 0)
                        up = dp[i - 1][j];

                    // Instead of recursive call f(i, j-1)
                    if (j > 0)
                        left = dp[i][j - 1];

                    // Same transition formula as memoization
                    dp[i][j] = up + left;
                }
            }
        }

        /*
         * In memoization:
         * return f(m-1, n-1, dp);
         *
         * In tabulation:
         * answer is already stored in dp[m-1][n-1]
         */
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        System.out.println("Number of Unique Paths: " + uniquePaths(m, n));
    }
}
