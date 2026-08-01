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

    // BRUTE FORCE
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
    // LC 1: this way will not work, bcz array is not sorted, if u sort and do index num will change
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
    // LC 1:
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
