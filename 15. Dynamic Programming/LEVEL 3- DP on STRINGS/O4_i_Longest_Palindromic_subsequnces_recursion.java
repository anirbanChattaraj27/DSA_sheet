

/*
s = "bbabcbcab"
reverse(s) = "bacbcbabb"

LCS(s, reverse(s)) = 7

b a b c b a b
↑           ↑
same forward and backward

 */

// Striver DP
// Longest Palindromic Subsequence using Pure Recursion

import java.util.*;

public class O4_i_Longest_Palindromic_subsequnces_recursion {

    // Recursive function to find LCS
    public static int lcs(int i, int j, String s, String t) {

        // Base Case
        // If any string becomes empty
        if (i == 0 || j == 0) {
            return 0;
        }

        // If characters match
        if (s.charAt(i - 1) == t.charAt(j - 1)) {

            return 1 + lcs(i - 1, j - 1, s, t);
        }

        // If characters do not match
        else {

            int moveLeft = lcs(i - 1, j, s, t);
            int moveRight = lcs(i, j - 1, s, t);

            return Math.max(moveLeft, moveRight);
        }
    }

    // Function to find Longest Palindromic Subsequence
    public static int longestPalindromeSubsequence(String s) {

        int n = s.length();

        // Reverse the string
        String t = new StringBuilder(s).reverse().toString();

        // Call recursive LCS
        return lcs(n, n, s, t);
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