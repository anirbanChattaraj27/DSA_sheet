// LC 167 [2 pointer]
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
/*
Input: numbers = [2,7,11,15], target = 9 Sorted input
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
*/

// 2 pointer and hash both 
// 2 pointer: bcz array is already sorted, so to get the index of elements are easy

import java.util.*;

public class O2_2SUM_2 {

    public int[] twoSum2_1(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        int[] temp = new int[2]; 
        
        while (left < right) {
            int currentSum = arr[left] + arr[right]; // Calculate the combined sum

            if (currentSum == sum) {
                temp[0] = left + 1; // 1-indexed for LeetCode 167
                temp[1] = right + 1;
                break;
            } 
            else if (currentSum < sum) {
                left++;  // Combined sum is too small -> make it bigger
            } 
            else {
                right--; // Combined sum is too large -> make it smaller
            }
        }
            
        return temp;
    }

    // using MAP
    public int[] twoSum2_2 (int[] numbers, int target) {
        // Map stores: Key = Number, Value = 1-based index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            
            // If complement exists, we found our pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i + 1 };
            }
            
            // Store current number with its 1-based index
            map.put(numbers[i], i + 1);
        }
        
        return new int[] {-1, -1}; // Fallback (problem guarantees a solution)
    }
}
