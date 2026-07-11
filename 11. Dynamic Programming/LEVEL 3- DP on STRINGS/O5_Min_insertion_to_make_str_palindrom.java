
import java.util.*;

public class O5_Min_insertion_to_make_str_palindrom {

    // Your exact recursive function to compute LCS/LPS using memoization
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

    // Function to calculate Longest Palindromic Subsequence (LPS)
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

    // only part added new, rest part is same as O4_ii_Longest_Palindromic_subsequnces_memoization
    public static int minInsertions(String s) {
        int n = s.length();
        
        // Find the length of the longest palindromic component
        int lpsLength = longestPalindromeSubsequence(s);
        
        // The remaining characters must be inserted to form pairs
        return n - lpsLength;
    }

    public static void main(String[] args) {
        String s1 = "mbadm";
        // LPS of "mbadm" is "mam" or "mbm" (length 3). 
        // Min insertions = 5 - 3 = 2 (e.g., "mbdadbm")
        System.out.println("Minimum insertions for 'mbadm': " + minInsertions(s1)); 

        String s2 = "abca";
        // LPS of "abca" is "aba" or "aca" (length 3). 
        // Min insertions = 4 - 3 = 1 (e.g., "acbca")
        System.out.println("Minimum insertions for 'abca': " + minInsertions(s2)); 
    }
}
