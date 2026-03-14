// Striver DP
// Print Longest Common Subsequence using Tabulation

public class O2_iii_longest_Common_SubSequence_print_tabulation {

    public static String lcs(String s, String t) {

        int n = s.length();
        int m = t.length();

        // DP table
        int[][] dp = new int[n + 1][m + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of LCS
        int len = dp[n][m];

        // Create a character array to store LCS
        char[] ans = new char[len];

        int index = len - 1;
        int i = n;
        int j = m;

        // Backtrack to build the LCS string
        while (i > 0 && j > 0) {

            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans[index] = s.charAt(i - 1);
                index--;
                i--;
                j--;
            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }

            else {
                j--;
            }
        }

        return new String(ans);
    }

    public static void main(String[] args) {

        // Direct input
        String s = "abcde";
        String t = "bdgek";

        String result = lcs(s, t);

        System.out.println("Longest Common Subsequence: " + result);
    }
}