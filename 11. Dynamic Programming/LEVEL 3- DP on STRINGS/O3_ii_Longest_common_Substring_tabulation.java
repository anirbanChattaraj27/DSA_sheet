// Striver DP
// Longest Common Substring using Tabulation (Bottom-Up DP)

public class O3_ii_Longest_common_Substring_tabulation {

    // Function to compute Longest Common Substring
    public static int lcs(String s, String t) {

        int n = s.length();
        int m = t.length();

        // DP table
        // dp[i][j] = length of longest common substring ending at s[i-1] and t[j-1]
        int[][] dp = new int[n + 1][m + 1];

        int ans = 0; // stores maximum substring length

        // Base case initialization
        // First row and first column are already 0 by default

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // If characters match
                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // Update maximum substring length
                    ans = Math.max(ans, dp[i][j]);
                }

                // If characters don't match
                else {
                    // Reset to 0 because substring must be continuous
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Direct input (no Scanner)
        String s = "abcjklp";
        String t = "acjkp";

        int result = lcs(s, t);

        System.out.println("Length of Longest Common Substring: " + result);
    }
}