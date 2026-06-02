// https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
/*
Given an array arr[] of size N and an integer K, the task is to find the length 
of the largest subarray having the sum of its elements at most K, where K > 0.
Input: arr[] = {1, 2, 1, 0, 1, 1, 0}, k = 4
Output: 5
Explanation: {1, 2, 1} => sum = 4, length = 3 {1, 2, 1, 0}, {2, 1, 0, 1} => sum = 4, length = 4 {1, 0, 1, 1, 0} =>5 sum = 3, length = 5

Input: 8, 2, 4, 0, 1, 1, 0, K = 9
Output: 6
*/

public class O3_III_Longest_subArray_atmost_K {

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

    // sliding window STRIVER [O(N + N)  ==> O(2N)]
    // Expand & Shrinking
    public static int longestSubarray2 (int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int sum = 0;
        int maxLen = 0;

        while (right < n) {
            sum += arr[right];

            // Shrink the window while sum > k
            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            // Check and update max length if current sum is within the limit
            if (sum <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    // STRIVER O(N)
    public static int longestSubarray3 (int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int sum = 0;
        int maxLen = 0;

        if (right < n) { // just by writing if i can reduce T.C.
            sum += arr[right];

            // Shrink the window while sum > k
            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            // Check and update max length if current sum is within the limit
            if (sum <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    // sliding window GFG (O(2N))
    static int longestSubarray4 (int[] arr, int k) {

        int sum = 0; // Initialize the current sum to 0.        
        int cnt = 0; // Initialize a counter for the current subarray (or window) length to 0.
        int res = 0; // Initialize the result to 0.

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) { // Reset the counter if an element is greater than k.
                sum = 0;
                cnt = 0;
                continue;
            }

            if ((sum + arr[i]) <= k) {

                // Include the current element in the subarray. Increment the subarray length.
                cnt++;
                sum += arr[i];
            } 

            else {
                cnt++;
                sum += arr[i];

                // If the sum exceeds k, remove elements from the
                // subarray until the sum is less than or equal to K.
                while (sum > k) {
                    sum -= arr[i - cnt + 1];
                    cnt--;
                }
            }
            res = Math.max(cnt, res); // Update the result with the maximum subarray length.
        }
        return res;
    }

    public static void main(String[] args) {
        // Define the input array and the maximum sum k
        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        int k = 4;

        System.out.println(longestSubarray3(arr, k));
        System.out.println(longestSubarray3(arr, k));
    }
}
