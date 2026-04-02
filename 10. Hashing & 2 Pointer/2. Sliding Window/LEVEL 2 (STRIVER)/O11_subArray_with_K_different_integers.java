/*  LEETCODE 992

Given an integer array nums and an integer k, return the number of good subarrays of nums.
A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

Example 2:
Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
*/



import java.util.*;

public class O11_subArray_with_K_different_integers {

    // Brute Force
    public static int subarraysWithKDistinct(int[] nums, int k) {
        // Store the total count of valid subarrays
        int count = 0;

        // Iterate through all possible starting points
        for (int i = 0; i < nums.length; i++) {

            // Use a hashmap to store frequency of elements
            Map<Integer, Integer> map = new HashMap<>();

            // Iterate through all possible end points
            for (int j = i; j < nums.length; j++) {

                // Update the frequency of the current number
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                // If size equals k, it's a valid subarray
                if (map.size() == k)
                    count++;

                // If more than k distinct, break early
                if (map.size() > k)
                    break;
            }
        }

        // Return total valid subarrays
        return count;
    }


    // Optimal
    public int atMostK(int[] nums, int K) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        // Traverse the array with right pointer
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) {
                K--;
            }

            // Shrink the window if K becomes negative
            while (K < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    K++;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    // Main function to return number of subarrays with exactly K distinct integers
    public int subarraysWithKDistinct2(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
