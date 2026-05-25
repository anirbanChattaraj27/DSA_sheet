import java.util.Arrays;

public class O5_2_Triangle_Memoization {

    /*
     * 🔹 Memoization Version
     *
     * Difference from Recursion:
     * 1. We add a dp[][] array.
     * 2. We check if result already exists.
     * 3. We store result before returning.
     */

    public static int f(int i, int j, int[][] triangle, int n, int[][] dp) {

        // Base Case (same as recursion)
        if (i == n - 1) {
            return triangle[i][j];
        }

        // 🔥 EXTRA LINE ADDED (Memoization Step)
        // If already computed, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Same recursion logic
        int down = triangle[i][j] + f(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + f(i + 1, j + 1, triangle, n, dp);

        // 🔥 EXTRA LINE ADDED
        // Store result before returning
        dp[i][j] = Math.min(down, diagonal);

        return dp[i][j];
    }

    /*
     * Function to initialize dp array
     */
    public static int minimumPathSum(int[][] triangle, int n) {

        // 🔥 EXTRA STEP compared to recursion
        // Create DP array and initialize with -1
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, triangle, n, dp);
    }

    // Main function to test
    public static void main(String[] args) {

        int[][] triangle = {
                {1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}
        };

        int n = triangle.length;

        int result = minimumPathSum(triangle, n);

        System.out.println("Minimum Path Sum (Memoization): " + result);
    }
}
/*
| Version     | Time Complexity | Space Complexity | Why               |
| ----------- | --------------- | ---------------- | ----------------- |
| Recursion   | O(2^n)          | O(n)             | Recomputes states |
| Memoization | O(n²)           | O(n²)            | Stores states     |
| Tabulation  | O(n²)           | O(n²)            | Iterative DP      |
*/