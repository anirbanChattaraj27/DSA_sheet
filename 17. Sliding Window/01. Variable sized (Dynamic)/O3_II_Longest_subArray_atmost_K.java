/*  ~~~~~~~~~~~~~~~~~~~~~ PART 1 ~~~~~~~~~~~~~~~~~~~~~~~
only POSITIVE numbers
// https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/

Given an array arr[] of size N and an integer K, the task is to find the length 
of the largest subarray having the sum of its elements at most K, where K > 0.
Input: arr[] = {1, 2, 1, 0, 1, 1, 0}, k = 4
Output: 5
Explanation: {1, 2, 1} => sum = 4, length = 3 {1, 2, 1, 0}, {2, 1, 0, 1} => sum = 4, length = 4 {1, 0, 1, 1, 0} =>5 sum = 3, length = 5

Input: 8, 2, 4, 0, 1, 1, 0, K = 9
Output: 6
*/



/* ~~~~~~~~~~~~~~~~~~~~~ PART 2 ~~~~~~~~~~~~~~~~~~~~~~~
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

public class O3_II_Longest_subArray_atmost_K {

    public static int longestSubarray1 (int[] arr, int k) {
        int res = 0;

        // Iterate through the array starting at each element
        for (int i = 0; i < arr.length; i++) {

            // Find current sum (between i and j)
            int sum = 0; 
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // If current sum is within the limit, update result
                if (sum <= k) {
                    res = Math.max(res, j - i + 1);
                } 
                // If sum exceeds k, stop further addition for this subarray
                else if(sum > k) {
                    break;
                }
            }
        }
        return res;
    }

    // sliding window [O(N + N)  ==> O(2N)]
    // Expand & Shrinking
    public static int longestSubArrayLength_Window(int[] nums, int k) {
        int start = 0;
        int sum = 0;
        int maxLength = 0; // Initialize to 0, as a valid length cannot be negative

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            // Shrink the window ONLY when the sum exceeds k
            while (sum > k && start <= end) {
                sum -= nums[start++];
            }

            // Now the window is valid (sum <= k), update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


    //  ~~~~~~~~~~~~~~~~~~~~~ PART 1 ~~~~~~~~~~~~~~~~~~~~~~~/\
    // STRIVER O(N) 
    // preffered
    public static int longestSubarray3 (int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for(int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink the window while sum > k
            while (sum > k) {
                sum -= arr[left++];
            }

            // Check and update max length if current sum is within the limit
            if (sum <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            /* when Sum == K
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }*/
        }
        return maxLen;
    }

    //  ~~~~~~~~~~~~~~~~~~~~~ PART 2 ~~~~~~~~~~~~~~~~~~~~~~~
    // Longest ---> SUM == K
    // FOR Negetive numbers
    public static int getLongestSubarray2(int[] arr, int k) {
        int prefixSum = 0;
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>(); 
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }

            map.putIfAbsent(prefixSum, i); // Because we want the longest subarray.
        }
        return maxLength;
    }
    

    public static void main(String[] args) {
        // Define the input array and the maximum sum k
        int[] arr = {7, 2, 1, 1, 6, 5};
        int k = 11;

        System.out.println(longestSubarray3(arr, k));
        System.out.println(longestSubarray3(arr, k));
    }
}
