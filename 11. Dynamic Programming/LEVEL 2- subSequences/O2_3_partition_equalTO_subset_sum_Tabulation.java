public class O2_3_partition_equalTO_subset_sum_Tabulation {

    /*
        This function checks whether a subset
        with sum = k exists using Tabulation
    */
    public static boolean subsetSumToK(int n, int k, int[] arr) {

        // STEP 1: Create DP table
        boolean[][] dp = new boolean[n][k + 1];

        // STEP 2: Base Case Initialization

        // Target 0 is always possible (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // If first element <= k, mark it
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // STEP 3: Fill DP table (Bottom-Up)
        for (int ind = 1; ind < n; ind++) {

            for (int target = 1; target <= k; target++) {

                boolean notTake = dp[ind - 1][target];

                boolean take = false;
                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }


    /*
        Partition Equal Subset Sum
        1) Find total sum
        2) If odd → return false
        3) Else check subset sum = total/2
    */
    public static boolean canPartition(int[] arr, int n) {

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        // If sum is odd, cannot partition equally
        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        return subsetSumToK(n, target, arr);
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        boolean result = canPartition(arr, n);

        System.out.println(result);   // Output: true
    }
}

/*
| Approach    | Time Complexity | Space Complexity | Stack Used? |
| ----------- | --------------- | ---------------- | ----------- |
| Recursion   | O(2^n)          | O(n)             | ✅ Yes       |
| Memoization | O(n × target)   | O(n × target)    | ✅ Yes       |
| Tabulation  | O(n × target)   | O(n × target)    | ❌ No        |
 */