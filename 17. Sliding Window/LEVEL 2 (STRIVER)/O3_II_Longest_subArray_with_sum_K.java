// I can not use 2 pointer here as it contains negetive values, if it contains only positive numbers then I can use prev approch here\\


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

public class O3_II_Longest_subArray_with_sum_K {

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

    // using hashing (Better approch)
    public static int getLongestSubarray2(int[] a, long k) {
        int n = a.length; // size of the array.

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, -10};
        int k = 15;
        int len = getLongestSubarray1(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
