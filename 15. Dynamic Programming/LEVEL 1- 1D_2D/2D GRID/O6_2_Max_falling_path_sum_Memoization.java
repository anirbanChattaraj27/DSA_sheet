import java.util.Arrays;

public class O6_2_Max_falling_path_sum_Memoization {

    /*
     * Memoization Version
     *
     * Changes from Recursion:
     * 1️⃣ Added dp[][] array
     * 2️⃣ Added dp check before computing
     * 3️⃣ Store result before returning
     */

    public static int f(int i, int j, int[][] matrix, int[][] dp) {

        // 🔹 Boundary check (same as recursion)
        if (j < 0 || j >= matrix[0].length)
            return (int) -1e8;

        // 🔹 Base case (same as recursion)
        if (i == 0)
            return matrix[0][j];

        // 🔥 EXTRA LINE ADDED (Memoization Step)
        // If value already computed, return stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Same recursive transitions
        int up = matrix[i][j] + f(i - 1, j, matrix, dp);
        int leftDiagonal = matrix[i][j] + f(i - 1, j - 1, matrix, dp);
        int rightDiagonal = matrix[i][j] + f(i - 1, j + 1, matrix, dp);

        // 🔥 EXTRA LINE ADDED
        // Store computed result before returning
        dp[i][j] = Math.max(up,
                        Math.max(leftDiagonal, rightDiagonal));

        return dp[i][j];
    }

    public static int getMaxPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // 🔥 EXTRA STEP compared to recursion
        // Create dp array initialized with -1
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxi = (int) -1e8;

        // Try starting from every column in last row
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, f(n - 1, j, matrix, dp));
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

        System.out.println("Maximum Falling Path Sum (Memoization): " + result);
    }
}


/*
| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(m × 3^n)  | O(n)         |
| Memoization | O(n × m)    | O(n × m)     |
| Tabulation  | O(n × m)    | O(n × m)     |
*/
