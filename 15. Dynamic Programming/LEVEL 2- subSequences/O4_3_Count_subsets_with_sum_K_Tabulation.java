/*
    Class Name: O4_3_Count_subsets_with_sum_K_Tabulation

    This program counts the number of subsets
    whose sum equals K using Tabulation (Bottom-Up DP).
*/

public class O4_3_Count_subsets_with_sum_K_Tabulation {

    public static int findWays(int[] num, int tar) {

        int n = num.length;

        // Step 1: Create DP table
        // dp[i][sum] = number of ways to form sum using first i elements
        int[][] dp = new int[n][tar + 1];

        // Step 2: Base Case
        // Sum 0 can always be formed by empty subset
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // First element initialization
        if (num[0] <= tar)
            dp[0][num[0]] = 1;

        // Step 3: Fill DP table
        for (int ind = 1; ind < n; ind++) {

            for (int sum = 0; sum <= tar; sum++) {

                // Not Take
                int notTake = dp[ind - 1][sum];

                // Take
                int take = 0;
                if (num[ind] <= sum)
                    take = dp[ind - 1][sum - num[ind]];

                dp[ind][sum] = notTake + take;
            }
        }

        return dp[n - 1][tar];
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] num = {1, 2, 2, 3};
        int target = 3;

        int result = findWays(num, target);

        System.out.println("Number of subsets with sum " + target + " : " + result);
    }
}