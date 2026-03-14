/*
    Class Name: O3_3_Partition_set_into_2_subset_Tabulation

    This program finds the Minimum Subset Sum Difference
    using Tabulation (Bottom-Up Dynamic Programming).
*/

// this qs is similar to qs copy 14: subset sum equal to target
public class O3_3_Partition_set_into_2_subset_Tabulation {

    public static int minSubsetSumDifference(int[] arr, int n) {

        // Step 1: Calculate total sum of array
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // We only need to check till totalSum
        int k = totSum;

        // Step 2: Create DP table
        boolean[][] dp = new boolean[n][k + 1];

        // Base Case:
        // Target 0 is always possible (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // First element initialization
        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        // Step 3: Fill DP table
        for (int ind = 1; ind < n; ind++) {

            for (int target = 1; target <= k; target++) {

                // Not Take
                boolean notTake = dp[ind - 1][target];

                // Take
                boolean take = false;
                if (arr[ind] <= target)
                    take = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = take || notTake;
            }
        }

        // Step 4: Find minimum difference
        int mini = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= totSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totSum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }

        return mini;
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        int result = minSubsetSumDifference(arr, n);

        System.out.println("Minimum Subset Sum Difference: " + result);
    }
}