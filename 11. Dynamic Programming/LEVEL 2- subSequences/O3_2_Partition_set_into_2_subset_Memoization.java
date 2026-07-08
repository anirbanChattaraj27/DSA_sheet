import java.util.*;

class Solution {

    public boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // Base case: If the target sum is 0, subset is always possible
        if (target == 0) {
            return true; // No need to store in DP; target 0 is always true
        }

        // Base case: If only first element is considered, check if it equals target
        if (ind == 0) {
            dp[ind][target] = (arr[0] == target) ? 1 : 0;
            return arr[0] == target;
        }

        // Return previously computed result to avoid recomputation
        if (dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }

        // Recursive case: Exclude current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Recursive case: Include current element if it does not exceed target
        boolean taken = false;
        if (arr[ind] <= target) {
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        }

        // Store the result in dp (1 for true, 0 for false) and return
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }

    // Function to find minimum absolute difference between two subsets
    public int minSubsetSumDifference(int[] arr, int n) {
        int totSum = 0;
        for (int val : arr) {
            totSum += val;
        }

        // Initialize dp table with -1 indicating uncalculated states
        int[][] dp = new int[n][totSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Compute subset sums for all targets from 0 to total sum
        // This populates the dp table for the entire last row (n-1)
        for (int i = 0; i <= totSum; i++) {
            subsetSumUtil(n - 1, i, arr, dp);
        }

        int mini = Integer.MAX_VALUE;

        // Check all possible subset sums in last row of dp table
        // Optimization: We only need to check up to totSum / 2
        for (int s1 = 0; s1 <= totSum / 2; s1++) {
            // Check if s1 is a valid subset sum (either via DP table or target 0)
            if (s1 == 0 || dp[n - 1][s1] == 1) {
                int s2 = totSum - s1;
                int diff = Math.abs(s1 - s2);
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}

public class O3_2_Partition_set_into_2_subset_Memoization {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        Solution solver = new Solution();
        int ans = solver.minSubsetSumDifference(arr, n);
        System.out.println("The minimum absolute difference is: " + ans);
    }
}
