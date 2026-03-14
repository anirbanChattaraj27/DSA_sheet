/*
    Class Name: O4_2_Count_subsets_with_sum_K_Memoization

    This program counts the number of subsets
    whose sum equals K using Recursion + Memoization.
*/

import java.util.Arrays;

public class O4_2_Count_subsets_with_sum_K_Memoization {

    /*
        Recursive Function with Memoization

        ind -> current index
        sum -> remaining target sum
        num -> input array
        dp  -> memoization table  (NEW)
    */
    public static int f(int ind, int sum, int[] num, int[][] dp) {

        // Base Case 1
        if (sum == 0)
            return 1;

        // Base Case 2
        if (ind == 0)
            return (num[0] == sum) ? 1 : 0;

        // ------------------ NEW LINE (Memoization Check) ------------------
        if (dp[ind][sum] != -1)
            return dp[ind][sum];
        // -------------------------------------------------------------------

        // Not Take
        int notTake = f(ind - 1, sum, num, dp);

        // Take
        int take = 0;
        if (num[ind] <= sum)
            take = f(ind - 1, sum - num[ind], num, dp);

        // ------------------ NEW LINE (Store result in dp) ------------------
        dp[ind][sum] = notTake + take;
        return dp[ind][sum];
        // -------------------------------------------------------------------
    }


    // Function called from main
    public static int findWays(int[] num, int tar) {

        int n = num.length;

        // ------------------ NEW LINE (Create DP table) ------------------
        int[][] dp = new int[n][tar + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        // ---------------------------------------------------------------

        return f(n - 1, tar, num, dp);
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] num = {1, 2, 2, 3};
        int target = 3;

        int result = findWays(num, target);

        System.out.println("Number of subsets with sum " + target + " : " + result);
    }
}