/*
// TC will reduce
// Recursion + Memoization
// TC: O(N × 4 × 3) ≈ O(N) // row column 
// SC: O(N X 4)

/* “Memoization solves overlapping subproblems using recursion.
Tabulation removes recursion and builds the solution bottom-up.
This eliminates stack space and is generally preferred in interviews.” */


import java.util.*;

public class O1_3_ninja_training_tabulation {

    public static int ninjaTraining(int n, int[][] points) {

        /*
         * SAME AS MEMOIZATION:
         * --------------------
         * - We still use a 2D dp array of size n x 4
         * - dp[day][last] means:
         *   Maximum points till 'day' if last task done was 'last'
         *
         * WHAT CHANGED:
         * -------------
         * - No recursion
         * - No function f()
         * - No stack calls
         * - We build answer from bottom (day 0) to top (day n-1)
         */

        int[][] dp = new int[n][4];

        // 🔵 BASE CASE INITIALIZATION (Day 0)
        // This was inside recursive base case earlier
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0],
                        Math.max(points[0][1], points[0][2]));

        /*
         * Above means:
         * If last task was 0 → we choose max of 1 & 2
         * If last task was 1 → choose max of 0 & 2
         * If last task was 2 → choose max of 0 & 1
         * If last task was 3 → no restriction, take max of all
         */

        // 🔵 Fill DP table from day 1 to n-1
        for (int day = 1; day < n; day++) {

            for (int last = 0; last < 4; last++) {

                dp[day][last] = 0;  // initialize

                for (int task = 0; task < 3; task++) {

                    // We cannot perform same task as previous day
                    if (task != last) {

                        int point = points[day][task] + dp[day - 1][task];  // DP used here

                        // Take maximum
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        // Final answer
        return dp[n - 1][3];
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


/*
Feature	    Memoization	    Tabulation
Approach	Top-Down	    Bottom-Up
Recursion	✅ Yes	        ❌ No
DP Array	✅ Yes	        ✅ Yes
Stack Space	O(N)	        ❌ No recursion stack
Base Case	Inside recursion	Initialized manually
Order of Solving	From n → 0	From 0 → n

*/

/* COMPARISON */
/*
RECURSION:
f(day,last)
    → calls f(day-1,task)

MEMOIZATION:
f(day,last)
    → calls f(day-1,task)

TABULATION:
store f(day,last) in dp
avoid recomputation

NOTE:
    If recursion moves from n → 0
    Tabulation builds from 0 → n


*/