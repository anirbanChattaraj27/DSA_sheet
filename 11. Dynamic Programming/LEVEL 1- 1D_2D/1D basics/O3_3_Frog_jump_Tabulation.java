/*
    Class Name: O3_3_Frog_jump_Tabulation

    This program solves the Frog Jump problem
    using Tabulation (Bottom-Up Dynamic Programming).
*/

public class O3_3_Frog_jump_Tabulation {

    public static int frogJump(int n, int[] heights) {

        // DP array
        int[] dp = new int[n];

        // Base Case
        dp[0] = 0;

        // Build solution from bottom to top
        for (int i = 1; i < n; i++) {

            // Jump from i-1
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            // Jump from i-2
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            // Store minimum energy
            dp[i] = Math.min(fs, ss);
        }

        return dp[n - 1];
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;

        int result = frogJump(n, heights);

        System.out.println("Minimum Energy Required: " + result);
    }
}