/*
Example 1:

Input: arr = [3, 1, 2, 5]
Output: 18
Explanation: The minimum of subarrays: [3], [1], [2], [5], [3, 1], [1, 2], [2, 5], [3, 1, 2], [1, 2, 5], [3, 1, 2, 5] are 3, 1, 2, 5, 1, 1, 2, 1, 1, 1 respectively and their sum is 18.

Example 2:

Input: arr = [2, 3, 1]
Output: 10
Explanation: The minimum of subarrays: [2], [3], [1], [2,3], [3,1], [2,3,1] are 2, 3, 1, 2, 1, 1 respectively and their sum is 10.
*/

import java.util.*;

class Solution {

    // Function to find the sum of the minimum value in each subarray
    public int sumSubarrayMins(int[] arr) {
        // Size of the array
        int n = arr.length;

        // Modulo value to prevent integer overflow
        int mod = (int)1e9 + 7;

        // Variable to store the total sum
        int sum = 0;

        // Traverse each starting index of subarrays
        for (int i = 0; i < n; i++) {
            // Initialize the minimum as the current element
            int mini = arr[i];

            // Traverse all subarrays starting at index i
            for (int j = i; j < n; j++) {
                // Update the minimum in the current subarray
                mini = Math.min(mini, arr[j]);

                // Add the current minimum to the total sum
                sum = (sum + mini) % mod;
            }
        }

        // Return the total computed sum
        return sum;
    }

    // OPTIMIZED
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are greater or equal to current
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            // If stack is empty, NSE doesn't exist → set to n
            ans[i] = !st.isEmpty() ? st.peek() : n;

            // Push current index to stack
            st.push(i);
        }

        // Return NSE indices
        return ans;
    }

    // Function to find indices of Previous Smaller or Equal Element (PSEE)
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse array from left to right
        for (int i = 0; i < n; i++) {
            // Pop elements greater than current
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            // If stack is empty, PSEE doesn't exist → set to -1
            ans[i] = !st.isEmpty() ? st.peek() : -1;

            // Push current index to stack
            st.push(i);
        }

        // Return PSEE indices
        return ans;
    }

    // Function to compute the sum of minimums in all subarrays
    public int sumSubarrayMinsOPTIMIZED(int[] arr) {
        int n = arr.length;

        // Get NSE and PSEE indices
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        // Modulo for large results
        int mod = (int)1e9 + 7;
        int sum = 0;

        // Traverse each element to compute its contribution
        for (int i = 0; i < n; i++) {
            // Count of elements to the left including current
            int left = i - psee[i];

            // Count of elements to the right including current
            int right = nse[i] - i;

            // Total subarrays where arr[i] is the minimum
            long freq = left * right * 1L;

            // Contribution = frequency * value
            int val = (int)((freq * arr[i]) % mod);

            // Add contribution to sum
            sum = (sum + val) % mod;
        }

        // Return the final sum
        return sum;
    }

}


// Separate class containing the main method
public class O16_sum_of_subarray_minimum {
    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 5};

        // Create instance of Solution
        Solution sol = new Solution();

        // Call the function to get the sum of minimums
        int ans = sol.sumSubarrayMins(arr);

        // Print the result
        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}