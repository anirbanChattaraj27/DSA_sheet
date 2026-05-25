import java.util.Arrays;

public class O7_2_cherry_pickUp_II_Memoization {

    /*
     * 🔁 HOW WE CONVERT RECURSION → MEMOIZATION
     *
     * In recursion:
     *    f(i, j1, j2) calculates result again and again
     *    for same (i, j1, j2).
     *
     * In memoization:
     *    We store answer of each state (i, j1, j2)
     *    inside a 3D DP array.
     *
     * Since state depends on:
     *    i  → row
     *    j1 → Alice column
     *    j2 → Bob column
     *
     * DP size becomes:
     *    dp[r][c][c]
     */

    // Recursive function with DP array added
    public static int f(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {

        // ❌ Out of boundary check
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return (int) -1e8;
        }

        // ✅ Base Case: Last row
        if (i == r - 1) {

            if (j1 == j2)
                return grid[i][j1];     // count once
            else
                return grid[i][j1] + grid[i][j2]; // count both
        }

        /*
         * 🔥 MEMOIZATION STEP
         * Before calculating, check:
         * Have we already solved this state?
         */
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = (int) -1e8;

        // Explore all 9 possible move combinations
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int value = 0;

                // If both robots on same cell
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                // Recursive call
                value += f(i + 1,
                           j1 + dj1,
                           j2 + dj2,
                           r, c, grid, dp);

                maxi = Math.max(maxi, value);
            }
        }

        /*
         * 🧠 Store the result before returning
         * So next time we don’t recompute it
         */
        return dp[i][j1][j2] = maxi;
    }

    public static int maximumChocolates(int r, int c, int[][] grid) {

        /*
         * Create 3D DP array
         * dp[i][j1][j2]
         * Initialize with -1 (means not computed yet)
         */
        int[][][] dp = new int[r][c][c];

        for (int i = 0; i < r; i++) {
            for (int j1 = 0; j1 < c; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }

        // Start recursion from row 0
        return f(0, 0, c - 1, r, c, grid, dp);
    }

    // Driver
    public static void main(String[] args) {

        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int r = grid.length;
        int c = grid[0].length;

        System.out.println("Maximum Chocolates: " + maximumChocolates(r, c, grid));
    }
}

/*
🔹 Max Falling Path Sum
    State → (i, j)
    So DP → dp[i][j] (2D DP)

🔹 Cherry Pickup II
    State → (i, j1, j2)
    So DP → dp[i][j1][j2] (3D DP)
*/

/*
| Version     | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(9^r)          | O(r)             |
| Memoization | O(r × c²)       | O(r × c²)        |
*/