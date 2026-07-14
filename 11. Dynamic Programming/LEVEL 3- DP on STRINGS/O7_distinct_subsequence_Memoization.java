import java.util.*;

class Solution {
     
    int helper(int i, int j, String s, String t, int[][] dp) {
        // If we have matched all characters of t (successfully matched right-to-left)
        if (j < 0) return 1;

        // If we have exhausted s but t still has unmatched characters
        if (i < 0) return 0;

        // If already computed
        if (dp[i][j] != -1) return dp[i][j];

        // If characters match
        if (s.charAt(i) == t.charAt(j)) {
            // Option 1: take current character (move both pointers left)
            int take = helper(i - 1, j - 1, s, t, dp);

            // Option 2: skip current character of s (move only s pointer left)
            int notTake = helper(i - 1, j, s, t, dp);

            dp[i][j] = take + notTake;
        } else {
            // If mismatch, skip character of s
            dp[i][j] = helper(i - 1, j, s, t, dp);
        }
        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        // Handle edge case where t is longer than s
        if (n < m) return 0;

        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Start recursion from the last indices
        return helper(n - 1, m - 1, s, t, dp);
    }
}


// Driver class
public class O7_distinct_subsequence_Memoization {
    public static void main(String[] args) {
        
        Solution sol = new Solution();

        // Input strings
        String s = "babgbag";
        String t = "bag";

        // Print answer
        System.out.println(sol.numDistinct(s, t));
    }
}

