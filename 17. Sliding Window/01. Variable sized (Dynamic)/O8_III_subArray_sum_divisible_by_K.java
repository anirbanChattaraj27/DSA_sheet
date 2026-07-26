// LC 974: https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/2019331686/
/*
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

 */
import java.util.HashMap;
import java.util.Map;

public class O8_III_subArray_sum_divisible_by_K {

    // TC: O(N) || SC: (O(min(N, K)))
    public int subarraySum(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    // // TC: O(N) || SC: O(K)
    public int subarraysDivByK(int[] nums, int k) {
        // Use a primitive array instead of a HashMap
        int[] remainderCounts = new int[k];
        
        // Base case: Remainder 0 has been seen 1 time initially
        remainderCounts[0] = 1;
        
        int runningSum = 0;
        int count = 0;
        
        for (int num : nums) {
            runningSum += num;
            
            // Calculate remainder and handle negative values in one step
            int rem = runningSum % k;
            if (rem < 0) {
                rem += k;
            }
            
            // Add the history count directly from the array index
            count += remainderCounts[rem];
            
            // Increment the frequency of this remainder
            remainderCounts[rem]++;
        }
        
        return count;
    }
}
