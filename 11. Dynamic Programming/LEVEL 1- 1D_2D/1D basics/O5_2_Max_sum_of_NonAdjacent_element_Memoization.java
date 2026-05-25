
// MEMOIZATION
// TC: O(N)
// SC: O(N) + O(N)

import java.util.*;

public class O5_2_Max_sum_of_NonAdjacent_element_Memoization {

    private static int fun(int idx, int[] nums, int[] dp) {
        if (idx == 0) return nums[idx];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + fun(idx - 2, nums, dp);
        int notPick = 0 + fun(idx - 1, nums, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return fun(n - 1, nums, dp);
    }

    // Optional main method for testing
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 9};
        System.out.println(maximumNonAdjacentSum(nums)); // Output: 11
    }
}
