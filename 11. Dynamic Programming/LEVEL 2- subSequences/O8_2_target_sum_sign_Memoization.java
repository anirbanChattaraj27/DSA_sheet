
import java.util.*;

class Solution {
    // Function to count number of ways to assign '+' or '-' to reach target
    public int findTargetSumWays(int[] nums, int target) {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Step 2: Check feasibility
        // (totalSum - target) must be >= 0 and even, otherwise no valid partition exists
        if ((totalSum - target) < 0 || (totalSum - target) % 2 != 0)
            return 0;

        // Step 3: Transform problem into subset sum
        // We need to count subsets with sum = (totalSum - target) / 2
        int subsetSum = (totalSum - target) / 2;

        // Step 4: Create memoization table with default -1 (uncomputed)
        int[][] dp = new int[nums.length][subsetSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Step 5: Call helper recursive function
        return countSubsets(nums, nums.length - 1, subsetSum, dp);
    }

    // Recursive helper function with memoization
    private int countSubsets(int[] nums, int ind, int target, int[][] dp) {
        // Base case: when we are at the first element
        if (ind == 0) {
            // If both target and nums[0] are zero → we have two choices: pick or not pick
            if (target == 0 && nums[0] == 0) return 2;

            // If target is zero → one way (exclude this element)
            // Or if nums[0] equals target → one way (include this element)
            if (target == 0 || target == nums[0]) return 1;

            // Otherwise → no valid subset
            return 0;
        }

        // If value already computed, return it
        if (dp[ind][target] != -1) return dp[ind][target];

        // Option 1: Do not include current element
        int notPick = countSubsets(nums, ind - 1, target, dp);

        // Option 2: Include current element if it does not exceed target
        int pick = 0;
        if (nums[ind] <= target)
            pick = countSubsets(nums, ind - 1, target - nums[ind], dp);

        // Store result in memo table and return
        return dp[ind][target] = pick + notPick;
    }
}

// Driver code
public class O8_2_target_sum_sign_Memoization {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        // Expected output: 5
        System.out.println(sol.findTargetSumWays(nums, target));
    }
}
