// 2 pointer
// LC 3  https://leetcode.com/problems/longest-substring-without-repeating-characters/

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

        for (int r = 0; r < str.length(); r++) { // outer loop for traversing the string
            if (set.contains(str.charAt(r))) { //if duplicate element is found

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
        so max Length will not change, it remains 3 only.
    */

    // O(N)
    public int lengthOfLongestSubstring3(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // 1. Add right character
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1); 

            // 2. Shrink until window becomes valid
            while (map.get(ch) > 1) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                left++;
            }

            // 3. Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.print(" " + lengthOfLongestSubstring(s));
    }
}


/*
map.getOrDefault('a',0) +1
right will move 1 by 1 idx, and put a, b, c
| Character | Count |
| --------- | ----- |
| a         |     1 |
| b         |     1 |
| c         |     1 |

abca
| Character | Count |
| --------- | ----- |
| a         |     2 |
| b         |     1 |
| c         |     1 |

now,
 while (map.get(ch) > 1) 
 if any of the char's value is more than 1, we will shrink the window from left side, and reduce the count of that char in map

 map.get(leftChar) - 1) =====> reduce the count of that char in map, if it was 2 it will become 1
*/