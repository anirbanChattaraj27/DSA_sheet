/*

Example 1:

Input: nums = [1, 2, 3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
            [1], range = largest - smallest = 1 - 1 = 0 
            [2], range = 2 - 2 = 0
            [3], range = 3 - 3 = 0
            [1,2], range = 2 - 1 = 1
            [2,3], range = 3 - 2 = 1
            [1,2,3], range = 3 - 1 = 2
            So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

Example 2:

Input: nums = [1, 3, 3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
            [1], range = largest - smallest = 1 - 1 = 0
            [3], range = 3 - 3 = 0
            [3], range = 3 - 3 = 0
            [1,3], range = 3 - 1 = 2
            [3,3], range = 3 - 3 = 0
            [1,3,3], range = 3 - 1 = 2
            So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.

*/

import java.util.*;

// Solution class with all helper methods and final logic
class Solution {

    // Function to find indices of Next Smaller Elements
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    // Function to find indices of Next Greater Elements
    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    // Function to find indices of Previous Smaller or Equal Elements
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    // Function to find indices of Previous Greater or Equal Elements
    private int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    // Function to compute sum of subarray minimums
    private long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = 1L * left * right;
            sum += freq * arr[i];
        }
        return sum;
    }

    // Function to compute sum of subarray maximums
    private long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = 1L * left * right;
            sum += freq * arr[i];
        }
        return sum;
    }

    // Function to compute total sum of subarray ranges (max - min)
    public long subArrayRanges(int[] arr) {
        return sumSubarrayMaxs(arr) - sumSubarrayMins(arr);
    }
}

// Separate class containing the main method
public class O17_sum_subarray_ranges {
    public static void main(String[] args) {
        // Sample input
        int[] arr = {1, 2, 3};

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Compute the sum of subarray ranges
        long ans = sol.subArrayRanges(arr);

        // Print the result
        System.out.println("The sum of subarray ranges is: " + ans);
    }
}
