//  LC 45: https://leetcode.com/problems/jump-game-ii/description/
/*
Example 1:
    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
    Input: nums = [2,3,0,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

public class O22_Jump_game_2 {

    // BETTER APPROACH || TC: O(n^2) SC: O(n)
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Fill dp array with max value
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Start index requires 0 jumps
        dp[0] = 0;

        // Traverse all indices
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        // Return min jumps to reach end
        return dp[n - 1];
    }

    // OPTIMAL APPROACH || TC: O(n) SC: O(1)
    public int jump(int[] nums) {
        // Initialize jumps and range trackers
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Loop through array up to second last index
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If current index reaches the end of current range
            if (i == currentEnd) {
                // Increment jump count
                jumps++;

                // Update range to the farthest index
                currentEnd = farthest;
            }
        }

        // Return the total number of jumps
        return jumps;
    }
}

// Driver Code
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println("Minimum jumps required: " + sol.jump(nums));
    }
}
