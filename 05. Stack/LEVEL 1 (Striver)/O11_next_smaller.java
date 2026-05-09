/*

Example 1:
Input:
 arr = [4, 8, 5, 2, 25]
Output:
 [2, 5, 2, -1, -1]
Explanation:

- For 4, the next smaller element is 2.
- For 8, the next smaller element is 5.
- For 5, the next smaller element is 2.
- For 2, there is no smaller element to its right → -1.
- For 25, no smaller element exists → -1.

Example 2:
Input:
 arr = [10, 9, 8, 7]
Output:
 [9, 8, 7, -1]
*/

import java.util.*;

class Solution {

    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;

        // Initialize the answer array with -1
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Traverse each element in the array
        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            // Look ahead to find the next smaller element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < curr) {
                    // Store and break on finding the smaller element
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        // Return the answer array
        return ans;
    }

    // Function to find next smaller element using stack
    public int[] nextSmallerElement2(int[] arr) {
        int n = arr.length;

        // Stack to keep potential next smaller elements
        Stack<Integer> st = new Stack<>();

        // Initialize result array with -1
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from stack that are not smaller
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            // If stack not empty, top is the next smaller element
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }

            // Push current element to stack
            st.push(arr[i]);
        }

        // Return result
        return ans;
    }
}

public class O11_next_smaller {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2, 4 };
        Solution sol = new Solution();

        // Get next smaller elements
        int[] ans = sol.nextSmallerElement(arr);

        // Print result
        System.out.print("The next smaller elements are: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}