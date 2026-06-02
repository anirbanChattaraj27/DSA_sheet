// Leetcode 209
public class O14_minimum_size_subArray_sum {
    
    // gemini code --. verify
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            // Phase 1: Expand the window
            windowSum += nums[right];

            // Phase 2: Dynamically contract the window as long as it's valid
            while (windowSum >= target) {
                // Record the smallest window length found so far
                minLength = Math.min(minLength, right - left + 1);
                
                // Shrink from the left
                windowSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, it means no valid subarray exists
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
