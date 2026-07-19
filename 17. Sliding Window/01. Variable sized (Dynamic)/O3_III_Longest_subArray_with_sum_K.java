// I can not use sliding window here as it contains negetive values, if it contains only positive numbers then I can use prev approch here\\
// negetive numbers

// https://www.geeksforgeeks.org/longest-sub-array-sum-k/
// https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/

/*
 * 
 *  Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
    Output: 6
    Explanation: Subarrays with sum = 15 are 
            [5, 2, 7, 1], 
            [10, 5],
            [10, 5, 2, 7, 1, -10]. 
            The length of the longest subarray with a sum of 15 is 6.
 */

import java.util.*;

public class O3_III_Longest_subArray_with_sum_K {

    // brute force
    public static int getLongestSubarray1(int[] arr, long k) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            // Sum of subarray from i to j
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // If subarray sum is equal to k
                if (sum == k) {
                    // find subarray length and update result
                    int subLen = j - i + 1;
                    res = Math.max(res, subLen);
                }
            }
        }
        return res;
    }

    
    public static int getLongestSubarray2(int[] arr, int k) {
        // Map to store (prefix_sum, first_index_where_it_occurred)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: The sum from index 0 to i equals k
            if (sum == k) {
                maxLength = i + 1;
            }

            // Case 2: If (sum - k) exists in map, a subarray sums to k
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            // Only add sum to map if it doesn't exist to preserve the EARLIEST index
            // This ensures we get the LONGEST possible subarray
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, -10};
        int k = 15;
        int len = getLongestSubarray1(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
