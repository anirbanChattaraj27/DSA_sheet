// using DP array
// TC will reduce
// Recursion + Memoization
// TC: O(N X 4)X3 // row column 
// SC: O(N) + O(N X 4) // O(N) is for extra dp array that i have taken

import java.util.*;

public class O1_2_ninja_training_memoization {

    /*
     * DIFFERENCE FROM EARLIER VERSION:
     * --------------------------------
     * Earlier: Only recursive function f(day, last, points)
     * Now: Added one extra parameter -> dp[][] (memoization table)
     * This avoids recomputing same states again and again.
     */

    // Recursive function with DP (Memoization added)
    public static int f(int day, int last, int[][] points, int[][] dp) {

        // 🔵 NEW ADDITION:
        // If value already computed, return it directly
        // This prevents repeated calculations
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        // Base case (Same as earlier version)
        if (day == 0) {
            int maxi = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }

            // 🔵 Store result in DP before returning
            // Earlier version returned directly without storing
            return dp[day][last] = maxi;
        }

        int maxi = 0;

        // Same logic as earlier version
        for (int task = 0; task < 3; task++) {
            if (task != last) {

                // Recursive call remains same
                int point = points[day][task] + f(day - 1, task, points, dp);

                maxi = Math.max(maxi, point);
            }
        }

        // 🔵 Store computed result in DP table
        return dp[day][last] = maxi;
    }

    public static int ninjaTraining(int n, int[][] points) {

        // 🔵 NEW ADDITION
        // Create DP table of size n x 4  // 4 because last can be 0,1,2,3
        int[][] dp = new int[n][4];

        // 🔵 Initialize DP table with -1 // Earlier version had no DP array at all
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Initial call remains same
        return f(n - 1, 3, points, dp);
    }

    public static void main(String[] args) {

        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;

        System.out.println("Maximum Points: " + ninjaTraining(n, points));
    }
}
