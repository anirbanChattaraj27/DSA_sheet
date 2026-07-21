// 2 pointer
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Given a string s, find the length of the longest substring without repeating characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.*;

public class O4_longest_subString_without_repeateting_character {

    // STRIVER O(2N)
    public static int lengthOfLongestSubstring(String str) {

        if (str.length() == 0) {
            return 0;
        }

        int maxans = Integer.MIN_VALUE;
        Set< Character> set = new HashSet<>();
        int l = 0;

        for (int r = 0; r < str.length(); r++){ // outer loop for traversing the string
            if (set.contains(str.charAt(r))){ //if duplicate element is found
            
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }

    /*
    DRY for above:
    ABCAA
    loop will run normally and find the len as 3 ABC
    then when it will find another A it will remove A from front and add the new A now still max len remians the same 3
    now when when another A will come it will keep removeing al the B, C, A and add A in the set
    so max Lean will not change, it remains 3 only.
    */


    // Striver Optimized Approch O(N)
    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;

        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }

            map.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    // Sliding window [leetcode official solution]
    public static int lengthOfLongestSubstring2(String s) {

        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    // gemini ---> verify
     public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        
        // Map to store (Character -> Its latest index position)
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char currChar = s.charAt(right);

            // If the character is already inside the current window, jump 'left'
            if (map.containsKey(currChar)) {
                // Ensure left only moves forward (never goes backward)
                left = Math.max(left, map.get(currChar) + 1);
            }

            // Update/Insert the latest index of the character
            map.put(currChar, right);

            // Calculate the valid window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.print(" " + lengthOfLongestSubstring(s));
    }
}
