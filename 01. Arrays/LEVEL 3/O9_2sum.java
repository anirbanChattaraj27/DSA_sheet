
/* LEETCODE: 1
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


import java.util.*;

public class O9_2sum {



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
    static boolean twoSum(int[] arr, int target){
       
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        // Iterate while left pointer is less than right
        while (left < right) {
            int sum = arr[left] + arr[right];

            // Check if the sum matches the target
            if (sum == target)
                return true;
            else if (sum < target)
            
            // Move left pointer to the right
                left++; 
            else
            
            // Move right pointer to the left
                right--;
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
    public static int[] twoSumIndices2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement found, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current element and index
            map.put(arr[i], i);
        }
        // No pair found
        return new int[] { -1, -1 };
    }


    // Better WAY
    public static boolean twoSumExists3(int[] arr, int target) {
        int n = arr.length;
        
        // Create an array of pairs [value, original_index]
        int[][] numsWithIndex = new int[n][2];
        
        // Store each element with its original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i]; // value
            numsWithIndex[i][1] = i;      // original index
        }
        
        // Sort the array based on the value, not index
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers: one at start, one at end
        int left = 0, right = n - 1;
        
        // Run loop until pointers cross
        while (left < right) {
            // Calculate the sum of values at pointers
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            
            if (sum == target) {
                // Found the pair, return "YES"
                return true;
            } else if (sum < target) {
                // Sum is less than target, so move left pointer right to increase sum
                left++;
            } else {
                // Sum is greater than target, so move right pointer left to decrease sum
                right--;
            }
        }
        
        // If loop ends without returning, no pair found
        return false;
    }

    // Variant 2: Return indices of two numbers that sum to target
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
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }
        
        // No pair found
        return new int[] {-1, -1};
    }



    public static void main(String[] args){

        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (twoSumExists2(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }

}
