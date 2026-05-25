// Striver DP - Longest Palindromic Subsequence (Tabulation)

import java.util.*;


/*
s = "bbabcbcab"
reverse(s) = "bacbcbabb"

LCS(s, reverse(s)) = 7

b a b c b a b
↑           ↑
same forward and backward
 */


public class O4_iii_Longest_Palindromic_subsequnces_tabulation {

    // Function to calculate LCS (Longest Common Subsequence)
    // between two strings using Tabulation (Bottom-Up DP)
    public static int lcs(String s, String t) {

        int n = s.length();   // length of first string
        int m = t.length();   // length of second string

        // DP table where dp[i][j] represents
        // LCS length of first i characters of s
        // and first j characters of t
        int[][] dp = new int[n + 1][m + 1];

        // Base case:
        // If one string length is 0, LCS = 0
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                // If characters do not match
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Final answer stored in dp[n][m]
        return dp[n][m];
    }

    // Function to find Longest Palindromic Subsequence
    public static int longestPalindromeSubsequence(String s) {

        // Create reverse of string
        String t = new StringBuilder(s).reverse().toString();

        // LPS = LCS(original string, reversed string)
        return lcs(s, t);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        // Call function
        int result = longestPalindromeSubsequence(s);

        // Output result
        System.out.println("Length of Longest Palindromic Subsequence: " + result);

        sc.close();
    }
}

