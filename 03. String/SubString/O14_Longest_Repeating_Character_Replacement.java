/*
Longest substring having all same characters after k changes

 * LEETCODE: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * Striver: https://www.youtube.com/watch?v=_eNhaDCr6P0&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=8
 * GFG: https://www.geeksforgeeks.org/maximum-length-substring-having-all-same-characters-after-k-changes/
 * 
 * You are given a string s and an integer k. You can choose any
 * character of the string and change it to any other uppercase 
 * English character. You can perform this operation at most k times.
 * 
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 */


import java.util.*;


public class O14_Longest_Repeating_Character_Replacement {

    // Function to find the maximum length of substring with at most k changes
    static int longestSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int res = 0;

        int l = 0; // Left boundary of the window

        // Right boundary of the window
        for (int r = 0; r < n; ++r) {

            // Increase the frequency of the  current character
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            // Update maxFreq with the frequency of the most frequent character in the current window
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(r)));

            // Shrink the window if more than k changes required
            if (r - l + 1 - maxFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++; 
            }

            // Update the maximum length of the substring
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int k = 2;
        String s = "ABABA";
        System.out.println("Maximum length = " + longestSubstr(s, k));

        k = 4;
        s = "HHHHHH";
        System.out.println("Maximum length = " + longestSubstr(s, k));
    }
}
