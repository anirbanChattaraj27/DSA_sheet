// Java program to find substrings with K Distinct characters

/*
Input: s = “abc”, k = 2
Output: 2
Explanation: Possible substrings are {“ab”, “bc”}


Input: s = “aba”, k = 2
Output: 3
Explanation: Possible substrings are {“ab”, “ba”, “aba”}


Input: s = “aa”, k = 1
Output: 3
Explanation: Possible substrings are {“a”, “a”, “aa”}
 */
import java.util.*;

public class O8_subString_with_K_unique_characters {

    // Naive approch
    static int countSubstr1(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Array to check if a character  is present in substring i..j
            boolean[] map = new boolean[26];
            int distinctCnt = 0;

            for (int j = i; j < n; j++) {

                // If new character is present, increment distinct count.
                if (!map[s.charAt(j) - 'a']) {
                    map[s.charAt(j) - 'a'] = true;
                    distinctCnt++;
                }

                // If distinct count is equal to k.
                if (distinctCnt == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // sliding window
    static int count(String s, int k) {
        int n = s.length();
        int ans = 0;

        // Use sliding window technique
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {

            // Expand window and add character
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) {
                distinctCnt++;
            }

            // Shrink window if distinct characters exceed k
            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) {
                    distinctCnt--;
                }
                i++;
            }

            // Add number of valid substrings ending at j
            ans += j - i + 1;
        }
        return ans;
    }

    // Function to find the number of substrings with exactly k Distinct characters.
    static int countSubstr2(String s, int k) {
        int ans = 0;

        // Subtract substrings with at most 
        // k-1 distinct characters from substrings
        // with at most k distinct characters
        ans = count(s, k) - count(s, k - 1);

        return ans;
    }


    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(countSubstr1(s, k));
    }
}
