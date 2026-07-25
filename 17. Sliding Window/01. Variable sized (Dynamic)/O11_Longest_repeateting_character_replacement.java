
/*  LEETCODE: 424

You are given a string s and an integer k. You can choose any character of the 
string and change it to any other uppercase English character. You can perform this 
operation at most k times.Return the length of the longest substring containing the 
same letter you can get after performing the above operations.

 

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

public class O11_Longest_repeateting_character_replacement {
    
    // Brute-Force
    public static int characterReplacement(String s, int k) {
        
        // Variable to track the maximum valid substring length
        int maxLength = 0;

        // Outer loop to iterate through all starting indices
        for (int i = 0; i < s.length(); i++) {

            // Frequency array to store counts of each uppercase letter
            int[] freq = new int[26];

            // Variable to track the max frequency character in the current window
            int maxFreq = 0;

            // Inner loop to check substrings starting at i
            for (int j = i; j < s.length(); j++) {

                // Increase frequency of current character
                freq[s.charAt(j) - 'A']++;

                // Update most frequent character count in window
                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

                // Current window size
                int windowSize = j - i + 1;

                // Calculate replacements needed to make all characters same
                int replacements = windowSize - maxFreq;

                // If replacements are within k, update maxLength
                if (replacements <= k) {
                    maxLength = Math.max(maxLength, windowSize);
                }
            }
        }

        return maxLength;
    }


    // Better O(N)
    public int characterReplacement2(String s, int k) {
        
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;

        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {

            // 1. Add right character
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Maximum frequency inside current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // 2. Shrink until window becomes valid
            while ((right - left + 1) - maxFreq > k) {

                // Remove left character
                freq[s.charAt(left) - 'A']--;

                left++;
            }

            // 3. Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; 
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("   "   + characterReplacement(s, k));
    }
}

