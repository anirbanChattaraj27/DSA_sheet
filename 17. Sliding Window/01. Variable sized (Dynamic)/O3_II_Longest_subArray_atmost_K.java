// https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
/*
only POSITIVE numbers

Given an array arr[] of size N and an integer K, the task is to find the length 
of the largest subarray having the sum of its elements at most K, where K > 0.
Input: arr[] = {1, 2, 1, 0, 1, 1, 0}, k = 4
Output: 5
Explanation: {1, 2, 1} => sum = 4, length = 3 {1, 2, 1, 0}, {2, 1, 0, 1} => sum = 4, length = 4 {1, 0, 1, 1, 0} =>5 sum = 3, length = 5

Input: 8, 2, 4, 0, 1, 1, 0, K = 9
Output: 6
*/

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
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Define the input array and the maximum sum k
        int[] arr = {7, 2, 1, 1, 6, 5};
        int k = 11;

        System.out.println(longestSubarray3(arr, k));
        System.out.println(longestSubarray3(arr, k));
    }
}
