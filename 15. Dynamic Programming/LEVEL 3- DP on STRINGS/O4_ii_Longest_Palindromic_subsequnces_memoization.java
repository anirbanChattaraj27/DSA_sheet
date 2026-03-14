// Striver DP
// Longest Palindromic Subsequence using Memoization (Top-Down DP)

/*
s = "bbabcbcab"
reverse(s) = "bacbcbabb"

LCS(s, reverse(s)) = 7

b a b c b a b
↑           ↑
same forward and backward
 */

import java.util.*;

public class O4_ii_Longest_Palindromic_subsequnces_memoization {

    // Recursive function to compute LCS using memoization
    public static int lcs(int i, int j, String s, String t, int[][] dp) {

        // Base case: if any string becomes empty
        if (i == 0 || j == 0) {
            return 0;
        }

        // If already computed, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match
        if (s.charAt(i - 1) == t.charAt(j - 1)) {

            dp[i][j] = 1 + lcs(i - 1, j - 1, s, t, dp);
        }

        // If characters do not match
        else {

            int moveLeft = lcs(i - 1, j, s, t, dp);
            int moveRight = lcs(i, j - 1, s, t, dp);

            dp[i][j] = Math.max(moveLeft, moveRight);
        }

        return dp[i][j];
    }

    // Function to calculate Longest Palindromic Subsequence
    public static int longestPalindromeSubsequence(String s) {

        int n = s.length();

        // Reverse the string
        String t = new StringBuilder(s).reverse().toString();

        // DP array initialized with -1
        int[][] dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call LCS function
        return lcs(n, n, s, t, dp);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int result = longestPalindromeSubsequence(s);

        System.out.println("Length of Longest Palindromic Subsequence: " + result);

        sc.close();
    }
}

/*
Approach	    Time	Space
Memoization 	O(N²)	O(N²) + recursion stack
Tabulation	    O(N²)	O(N²)
 */