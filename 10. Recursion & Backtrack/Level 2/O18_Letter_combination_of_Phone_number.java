// leetcode: 17: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

class Solution {

    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); // List to store results

        // Return empty list if digits string is empty
        if (digits.length() == 0) {
            return ans;
        }

        // Initiate recursive function
        helper(digits, ans, 0, "");
        return ans; // Return the result
    }

    private void helper(String digits, List<String> ans, int index, String current) {
        // Base case: if index reaches the end of digits
        if (index == digits.length()) {
            // Add the current combination to the answer
            ans.add(current);
            return;
        }

        // Get characters corresponding to the current digit
        String s = map[digits.charAt(index) - '0'];

        // Loop through the corresponding characters
        for (int i = 0; i < s.length(); i++) {
            // Recursively call function with the next index
            // Add current character to the string
            helper(digits, ans, index + 1, current + s.charAt(i));
        }
    }
}

// Main class containing the main method
public class O18_Letter_combination_of_Phone_number {

    public static void main(String[] args) {
        Solution solution = new Solution(); // Create an instance of Solution
        String digits = "23"; // Input digits
        List<String> result = solution.letterCombinations(digits); // Get combinations

        // Print the results
        for (String combination : result) {
            System.out.print(combination + " "); // Display each combination
        }
    }
}
