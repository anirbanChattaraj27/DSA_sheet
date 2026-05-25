// Minimum Size Subarray Sum (Smallest subarray whose sum is greater than or equal to target).
// Given an array of positive integers and a positive number k. Find the smallest contiguous subarray whose sum is either greater than or equal to k. If no subarray is found then return 0.

// // https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/

// Example 1 –
// Input :  {7, 2, 1, 1, 6, 5},  k = 11
// Output:  2 ( subarray {6, 5} has the minimum length )

// Example 2 –
// Input : {1, 4, 3},   k = 12
// Output: 0 (No subarray is possible)


/* Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray   whose sum is greater than or equal 
to target. If there is no such subarray, return 0 instead.

        LeetCode -> https://leetcode.com/problems/minimum-size-subarray-sum/
*/

import java.util.*;


public class O3_I_Shortest_size_subArray_with_sum_K {

    public static int minSubArrayLength_BruteForce(int[] nums, int k) {

        // Declare a variable and assign integer max value
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        // outer loop starts from 0th index
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            // Inner starts from the value of i
            for (int j = i; j < nums.length; j++) {
                // Add the value in sum variable
                sum = sum + nums[j];

                /*
                 * If the value of sum is greater than or equal to the value of k.
                 */
                if (sum >= k) {
                    // Update the value of minlength, if it's applicable
                    minLength = Math.min(minLength, (j-i)+1); 
                    break;
                }
            }
        }

        // Return minlength
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static int minSubArrayLength_Window(int[] nums, int k) {

        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Move end pointer
        for (int end = 0; end < nums.length; end++) {

            // Add value to the sum variable
            sum = sum + nums[end];

            // while sum is greater than the value of k
            while (sum >= k && start <= end) {

                // Keep track of minLength
                minLength = Math.min(minLength, (end - start) + 1);

                /* Subtract the value from sum variable and Move start pointer */
                sum = sum - nums[start++];
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    
    public static void main(String[] args) {

        int[] arr = { 1, 4, 45, 6, 0, 19};
        int k = 51;

        // int[] arr = { 1, 4, 3 };
        // int k = 12;

        int length = minSubArrayLength_BruteForce(arr, k);
        System.out.println(length);
    }
}