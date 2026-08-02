/* NO LEETCODE
https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum
Example 1:
Input: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!
 */

import java.util.HashMap;

public class O8_IV_longest_subarray_with_0_Sum {

    public static int longestSubarrayWithZeroSum1(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; ++i) {
            int sum = 0;
            for (int j = i; j < a.length; ++j) {
                sum += a[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // O(N)
    public static int longestSubarrayWithZeroSum2(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Prefix sum 0 occurs before the array starts

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i]; // 1. Build Prefix Sum

            if (map.containsKey(prefixSum)) { // 2. Same prefix seen before, means subarray with 0 sum exists
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } 

            else { 
                map.put(prefixSum, i); // 3. Store first occurrence only
            }
        }
        return maxLength;
    }

    public static void main(String args[]) {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(longestSubarrayWithZeroSum1(a));
        System.out.println(longestSubarrayWithZeroSum2(a));
    }
}
