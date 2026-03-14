/*
    Class Name: O1_2_Subset_sum_equalTO_target_Memoization

    This program solves the Subset Sum Equal To Target problem
    using Recursion + Memoization (Top-Down DP).

    TC: n X target
    SC: n X target + n
*/

import java.util.Arrays;

public class O1_2_Subset_sum_equalTO_target_Memoization {

    /*
        Recursive Function with Memoization

        Parameters:
        ind    -> current index
        target -> remaining target sum
        arr    -> input array
        dp     -> memoization table

        Returns true if subset exists, otherwise false
    */
    public static boolean f(int ind, int target, int[] arr, int[][] dp) {

        // ✅ Base Case 1:
        // If target becomes 0, subset is found
        if (target == 0)
            return true;

        // ✅ Base Case 2:
        // If we are at first element
        if (ind == 0)
            return arr[0] == target;

        // ✅ Memoization Check:
        // If already computed, return stored result
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        /*
            Two Choices:
            1) Not Take current element
            2) Take current element (if <= target)
        */

        // Case 1: Not Take
        boolean notTake = f(ind - 1, target, arr, dp);

        // Case 2: Take
        boolean take = false;
        if (arr[ind] <= target)
            take = f(ind - 1, target - arr[ind], arr, dp);

        // Store result in DP table
        dp[ind][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }


    // Function called from main
    public static boolean subsetSumToK(int n, int k, int[] arr) {

        /*
            DP table:
            dp[ind][target]

            ind ranges from 0 to n-1
            target ranges from 0 to k

            -1 means not yet computed
            1 means true
            0 means false
        */
        int[][] dp = new int[n][k + 1];

        // Initialize with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n - 1, k, arr, dp);
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int k = 5;

        boolean result = subsetSumToK(n, k, arr);

        if (result)
            System.out.println("Subset with given target exists.");
        else
            System.out.println("Subset with given target does NOT exist.");
    }
}

/*
| Approach    | Time Complexity | Space Complexity | Recursion Stack |
| ----------- | --------------- | ---------------- | --------------- |
| Recursion   | O(2ⁿ)           | O(n)             | Yes             |
| Memoization | O(n × k)        | O(n × k)         | Yes             |
| Tabulation  | O(n × k)        | O(n × k)         | No              |
*/