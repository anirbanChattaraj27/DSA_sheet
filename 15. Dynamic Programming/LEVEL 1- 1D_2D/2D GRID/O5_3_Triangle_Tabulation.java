public class O5_3_Triangle_Tabulation {

    /*
     * Tabulation (Bottom-Up DP)
     *
     * dp[i][j] = minimum path sum from (i,j) to bottom
     */

    public static int minimumPathSum(int[][] triangle, int n) {

        // 🔹 DP table
        int[][] dp = new int[n][n];

        // 🔹 Step 1: Copy last row (Base Case of recursion)
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        // 🔹 Step 2: Fill table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {

                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // Final answer stored at top
        return dp[0][0];
    }

    // Main method
    public static void main(String[] args) {

        int[][] triangle = {
                {1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}
        };

        int n = triangle.length;

        int result = minimumPathSum(triangle, n);

        System.out.println("Minimum Path Sum (Tabulation): " + result);
    }
}

/*
| Version     | Time Complexity | Space Complexity | Why               |
| ----------- | --------------- | ---------------- | ----------------- |
| Recursion   | O(2^n)          | O(n)             | Recomputes states |
| Memoization | O(n²)           | O(n²)            | Stores states     |
| Tabulation  | O(n²)           | O(n²)            | Iterative DP      |
*/