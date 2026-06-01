/* LEETCODE: 1 [basically Hashing]
https://leetcode.com/problems/two-sum/description/


Given an array arr[] of n integers and a target value, check if there exists a 
pair whose sum equals the target. This is a variation of the 2-Sum problem.

Examples: 

Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.

Input: arr[] = [1, -2, 1, 0, 5], target = 0
Output: false
Explanation: There is no pair with sum equals to given target.
 */


// leetcide 1: 2 pointer is not easy to implement bcz array is not sorted, and i need to return index

import java.util.*;

public class O1_2sum {

    public static boolean twoSumExists(int[] arr, int target) {
        int n = arr.length;
        // Outer loop picks one element at a time
        for (int i = 0; i < n; i++) {
            // Inner loop searches for another element that complements arr[i]
            for (int j = i + 1; j < n; j++) {
                // If sum equals target, return "YES"
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        // No pair found that sums to target
        return false;
    }

    // Function to return indices of two numbers that sum to target (variant 2)
    public static int[] twoSumIndices(int[] arr, int target) {
        int n = arr.length;
        // Outer loop picks one element at a time
        for (int i = 0; i < n; i++) {
            // Inner loop searches for another element that complements arr[i]
            for (int j = i + 1; j < n; j++) {
                // If sum equals target, return the pair of indices
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // No such pair found
        return new int[]{-1, -1};
    }

    // OPTIMIZED: USING 2 pointer
    // LC 1: this way will not work, bcz array is not sorted, if u sort and do index no will change
    // LC 167 will work
    static boolean twoSum(int[] arr, int target) {

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        // Iterate while left pointer is less than right
        while (left < right) {
            int sum = arr[left] + arr[right];

            // Check if the sum matches the target
            if (sum == target) {
                return true; 
            }else if (sum < target) // Move left pointer to the right
            {
                left++; 
            }else // Move right pointer to the left
            {
                right--;
            }
        }
        // If no pair is found
        return false;
    }

    // Variant 2: Return indices of two numbers that sum to target
    // we need to keep indices so we can not sort, that is why used 2D array to keep track of indices
    public static int[] twoSumIndices3(int[] arr, int target) {
        int n = arr.length;
        int[][] numsWithIndex = new int[n][2];

        // Store element with original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }

        // Sort by the value to apply two-pointer
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                // Return original indices of the two numbers found
                return new int[]{numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }

        // No pair found
        return new int[]{-1, -1};
    }


    // Optimized Approch MAP
    public static boolean twoSumExists2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Iterate over all elements
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return true;  // Pair found
            }
            // Store current element and its index
            map.put(arr[i], i);
        }
        // No pair found
        return false;
    }

    // Variant 2: Return indices of two numbers that sum to target using hashing
    public static int[] twoSumIndices2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement found, return indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // Store current element and index
            map.put(arr[i], i);
        }
        // No pair found
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {

        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;

        if (twoSumExists2(arr, target)) {
            System.out.println("true"); 
        }else {
            System.out.println("false");
        }
    }

}
