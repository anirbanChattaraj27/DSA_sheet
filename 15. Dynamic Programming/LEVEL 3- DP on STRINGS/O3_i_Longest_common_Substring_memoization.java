
// Striver DP
// Longest Common Substring using Memoization (Top-Down)


/*
⚠️⚠️⚠️ Important ⚠️⚠️⚠️
Longest Common Substring memoization is tricky because substring 
requires continuous matching, so we must reset to 0 when characters differ.
*/
import java.util.Arrays;

public class O3_i_Longest_common_Substring_memoization {

    // Global variable to track maximum substring length
    static int ans = 0;

    // Recursive function
    public static int lcs(int i, int j, String s, String t, int[][] dp) {

        // Base case
        if (i == 0 || j == 0) {
            return 0;
        }

        // If already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match
        if (s.charAt(i - 1) == t.charAt(j - 1)) {

            dp[i][j] = 1 + lcs(i - 1, j - 1, s, t, dp);

            // Update global maximum
            ans = Math.max(ans, dp[i][j]);
        }

        else {
            dp[i][j] = 0;
        }

        // Explore other possibilities
        lcs(i - 1, j, s, t, dp);
        lcs(i, j - 1, s, t, dp);

        return dp[i][j];
    }

    public static int longestCommonSubstring(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        // Initialize dp with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion
        lcs(n, m, s, t, dp);

        return ans;
    }

    public static void main(String[] args) {

        // Direct input (no Scanner)
        String s = "abcjklp";
        String t = "acjkp";

        int result = longestCommonSubstring(s, t);

        System.out.println("Length of Longest Common Substring: " + result);
    }
}