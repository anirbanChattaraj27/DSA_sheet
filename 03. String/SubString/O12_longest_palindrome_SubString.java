// https://www.geeksforgeeks.org/longest-palindromic-substring/
// RANDOM GFG prblm

/*
Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.


Input: s = “Geeks” 
Output: “ee”


Input: s = “abc” 
Output: “a”

Input: s = “” 
Output: “”
 */


public class O12_longest_palindrome_SubString {

    // 
    static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int start = 0, maxLen = 1;

        // Traverse the input string
        for (int i = 0; i < n; i++) {

            // THIS RUNS TWO TIMES 
            // for both odd and even length
            // palindromes. j = 0 means odd
            // and j = 1 means even length
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j; 

                // Expand substring while it is a palindrome
                // and in bounds
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(longestPalindrome(s));
    }
}
