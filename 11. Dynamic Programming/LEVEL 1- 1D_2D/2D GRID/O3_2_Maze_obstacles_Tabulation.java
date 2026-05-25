public class O3_2_Maze_obstacles_Tabulation {

    // Constant for modulo operation
    static int mod = (int) (1e9 + 7);

    /*
     * This function calculates number of unique paths in a maze
     * with obstacles using TABULATION (Bottom-Up DP).
     *
     * n = number of rows
     * m = number of columns
     * mat = maze matrix (-1 represents obstacle)
     */
    public static int mazeObstacles(int n, int m, int[][] mat) {

        // dp[i][j] will store number of ways to reach cell (i,j)
        int[][] dp = new int[n][m];

        // Traverse the matrix row by row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If current cell is an obstacle, no path is possible
                if (mat[i][j] == -1) {
                    dp[i][j] = 0;
                }

                // Base Case: Starting cell
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                else {
                    int up = 0, left = 0;

                    // If coming from top is possible
                    if (i > 0) {
                        up = dp[i - 1][j];   // DP used here (previous row)
                    }

                    // If coming from left is possible
                    if (j > 0) {
                        left = dp[i][j - 1]; // DP used here (previous column)
                    }

                    // Total ways = ways from top + ways from left
                    dp[i][j] = (up + left) % mod;  // Store in DP table
                }
            }
        }

        // Final answer stored in bottom-right cell
        return dp[n - 1][m - 1];
    }

    // Main function to test the code
    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = mat.length;
        int m = mat[0].length;

        int result = mazeObstacles(n, m, mat);

        System.out.println("Number of unique paths: " + result);
    }
}
