// LC 1248 ---> https://leetcode.com/problems/count-number-of-nice-subarrays/description/
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

    // OPTIMAL O(N)
    public static int countAtMost(int[] nums, int k) {

        int left = 0;
        int count = 0;

        // Traverse the array with the right pointer
        for (int right = 0; right < nums.length; right++) {

            // 1. Add the current element to the window
            // If it is odd, consume one allowed odd number
            if (nums[right] % 2 == 1)
                k--;

            // 2. Shrink the window until it becomes valid
            while (k < 0) {

                // If the left element is odd,
                // restore one allowed odd number
                if (nums[left] % 2 == 1)
                    k++;

                // Remove the left element from the window
                left++;
            }

            // 3. Count all valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

    // Function to return number of subarrays with exactly k odd numbers
    public static int numberOfSubarrays2(int[] nums, int k) {
        // Exactly(K) = AtMost(K) - AtMost(K-1)
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println("----> " + numberOfSubarrays2(nums, k));
    }
}
