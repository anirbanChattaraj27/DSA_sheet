
/*
 * Example 1:
 * Input: * nums = "541892", k = 2
 * Output: * "1892"
 * Explanation:
    Removing the two digits 5 and 4 yields the smallest number, 1892.
 * 
 * Example 2:
 * Input: * nums = "1002991", k = 3
 * Output: * "21"
 * Explanation:
    Remove the three digits 1(leading one), 9, and 9 to form the new number 21(Note that the output must not contain leading zeroes) which is the smallest.
 * 
 */

import java.util.Stack;

class Solution {

    // Function to find the smallest possible integer after removing k digits
    public String removeKdigits(String nums, int k) {
        // Stack to store digits
        Stack<Character> st = new Stack<>();

        // Traverse the given string
        for (int i = 0; i < nums.length(); i++) {
            char digit = nums.charAt(i); // Current digit

            // Pop last digits if a smaller digit is found and k > 0
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop(); // Remove the last digit
                k--; // Decrement k by 1
            }

            // Push the current digit
            st.push(digit);
        }

        // If more digits can be removed
        while (k > 0) {
            st.pop(); // Pop the last added digits
            k--; // Decrement k by 1
        }

        // Handle edge case: if stack is empty
        if (st.isEmpty())
            return "0";

        // StringBuilder to store the result
        StringBuilder res = new StringBuilder();

        // Add digits from stack to result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Trim the leading zeros
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        // Reverse the string to get the correct number
        res.reverse();

        // If result is empty, return "0"
        if (res.length() == 0)
            return "0";

        // Return the result as a string
        return res.toString();
    }
}

// Separate class containing the main method
public class O21_Remove_K_digits {
    public static void main(String[] args) {
        String nums = "541892"; // Input number as string
        int k = 2; // Number of digits to remove

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the function to find the smallest number after removing k digits
        String ans = sol.removeKdigits(nums, k);

        // Print the result
        System.out.println("The smallest possible integer after removing k digits is: " + ans);
    }
}