public class O2_2_partition_equalTO_subset_sum_Memoization {

    /*
        Recursive function with Memoization

        ind    -> current index
        target -> remaining target sum
        arr    -> input array
        dp     -> memoization table
    */

   // copy paste the code from subsetSum function
    public static boolean f(int ind, int target, int[] arr, int[][] dp) {

        // ✅ Base Case 1: If target becomes 0 → subset found
        if (target == 0)
            return true;

        // ✅ Base Case 2: If we are at first element
        if (ind == 0)
            return arr[0] == target;

        // ✅ Check DP table
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        // 🔹 Choice 1: Not Take
        boolean notTake = f(ind - 1, target, arr, dp);

        // 🔹 Choice 2: Take (if possible)
        boolean take = false;
        if (arr[ind] <= target)
            take = f(ind - 1, target - arr[ind], arr, dp);

        // Store result in DP
        dp[ind][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }


    /*
        bellow func is differnt, but above function is sae as subset sub equal to target
    */
    public static boolean canPartition(int[] arr, int n) {

        int totSum = 0;

        // Calculate total sum
        for (int i = 0; i < n; i++)
            totSum += arr[i];

        // If sum is odd → cannot divide equally
        if (totSum % 2 != 0)
            return false;

        int target = totSum / 2;

        // 🔹 Create DP table
        int[][] dp = new int[n][target + 1];

        // Initialize with -1 (means not computed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return f(n - 1, target, arr, dp);
    }


    // 🔹 Main Function
    public static void main(String[] args) {

        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        boolean result = canPartition(arr, n);

        System.out.println(result);   // Expected Output: true
    }
}

/*
| Approach    | Time Complexity | Space Complexity | Stack Used? |
| ----------- | --------------- | ---------------- | ----------- |
| Recursion   | O(2^n)          | O(n)             | ✅ Yes       |
| Memoization | O(n × target)   | O(n × target)    | ✅ Yes       |
| Tabulation  | O(n × target)   | O(n × target)    | ❌ No        |
*/