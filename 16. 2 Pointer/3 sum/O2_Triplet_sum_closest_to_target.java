// LC 16
// Triplet Sum Closest to Given Sum 

import java.util.Arrays;

public class O2_Triplet_sum_closest_to_target {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        // 2. Initialize with the first possible triplet sum
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // 3. Loop through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // 4. Update closestSum if the current deviation is smaller
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // 5. Move pointers based on the sum comparison
                if (currentSum < target) {
                    left++; // Need a larger sum
                } else if (currentSum > target) {
                    right--; // Need a smaller sum
                } else {
                    return currentSum; // Found exact match, return early
                }
            }
        }
        
        return closestSum;
    } 
}
