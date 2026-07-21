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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }

            map.putIfAbsent(prefixSum, i);
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
