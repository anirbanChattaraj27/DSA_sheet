// https://leetcode.com/problems/count-number-of-nice-subarrays/description/
/*
Given an array of integers nums and an integer k. A continuous subarray is called nice 
if there are k odd numbers on it. Return the number of nice sub-arrays.

 

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:
Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 */


import java.util.*;

public class O10_count_no_of_nice_subArray {

    // BRUTE FORCE O(N^2)
    public int numberOfSubarrays1(int[] nums, int k) {
        // Initialize counter for total nice subarrays
        int count = 0;

        // Loop over all starting indices
        for (int start = 0; start < nums.length; start++) {
            // Track number of odd elements in current subarray
            int oddCount = 0;

            // Loop over ending indices starting from 'start'
            for (int end = start; end < nums.length; end++) {
                // Check if current number is odd
                if (nums[end] % 2 != 0)
                    oddCount++;

                // If odd count exceeds k, break (not nice)
                if (oddCount > k)
                    break;

                // If odd count is exactly k, count this subarray
                if (oddCount == k)
                    count++;
            }
        }

        // Return total nice subarrays
        return count;
    }

    // Better O(N)
    public static int numberOfSubarrays2(int[] nums, int k) {

        // Frequency map to track count of odd-number sums
        Map<Integer, Integer> freq = new HashMap<>();

        // Initial state: zero odd numbers has occurred once
        freq.put(0, 1);

        // Running count of odd numbers in current prefix
        int oddCount = 0;

        // Total number of nice subarrays
        int result = 0;

        // Traverse the entire array
        for (int num : nums) {

            // Check if number is odd
            if (num % 2 == 1) oddCount++;

            // Check if there's a prefix with (oddCount - k)
            if (freq.containsKey(oddCount - k)) {
                result += freq.get(oddCount - k);
            }

            // Update frequency map with current oddCount
            freq.put(oddCount, freq.getOrDefault(oddCount, 0) + 1);
        }

        // Return total result
        return result;
    }


    // OPTIMAL O(N)
    public static int countAtMost(int[] nums, int k) {
        int left = 0, res = 0;

        // Traverse through the array
        for (int right = 0; right < nums.length; right++) {
            // If current number is odd, reduce k
            if (nums[right] % 2 != 0)
                k--;

            // Shrink the window until k is valid
            while (k < 0) {
                if (nums[left] % 2 != 0)
                    k++;
                left++;
            }

            // Add valid subarrays ending at right
            res += (right - left + 1);
        }

        // Return result
        return res;
    }

    // Function to return number of subarrays with exactly k odd numbers
    public static int numberOfSubarrays3(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println("----> " + numberOfSubarrays2(nums, k));
    }
}
