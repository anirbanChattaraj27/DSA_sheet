public class O6_3_Max_falling_path_sum_Tabulation {

    /*
     * TABULATION (Bottom-Up DP)
     *
     * dp[i][j] = maximum falling path sum ending at cell (i, j)
     *
     * We build from top row to bottom row.
     */

    public static int getMaxPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // 🔹 DP table
        int[][] dp = new int[n][m];

        // 🔹 Step 1: Initialize first row (Base Case of recursion)
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // 🔹 Step 2: Fill DP table row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Move Up
                int up = matrix[i][j] + dp[i - 1][j];

                // Move Left Diagonal
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0)
                    leftDiagonal += dp[i - 1][j - 1];
                else
                    leftDiagonal += (int) -1e8;  // Out of boundary

                // Move Right Diagonal
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m)
                    rightDiagonal += dp[i - 1][j + 1];
                else
                    rightDiagonal += (int) -1e8;  // Out of boundary

                // Store maximum of three
                dp[i][j] = Math.max(up,
                                Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // 🔹 Step 3: Answer is max value in last row
        int maxi = (int) -1e8;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }

    // Main method for testing
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };

        int result = getMaxPathSum(matrix);

        System.out.println("Maximum Falling Path Sum (Tabulation): " + result);
    }
}

/*
| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(m × 3^n)  | O(n)         |
| Memoization | O(n × m)    | O(n × m)     |
| Tabulation  | O(n × m)    | O(n × m)     |
*/
