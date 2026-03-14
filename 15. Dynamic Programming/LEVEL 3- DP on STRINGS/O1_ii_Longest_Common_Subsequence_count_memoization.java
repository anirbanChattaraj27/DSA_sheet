
import java.util.*;

public class O1_ii_Longest_Common_Subsequence_count_memoization {

    static int f(int i, int j, String s, String t, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + f(i - 1, j - 1, s, t, dp);

        return dp[i][j] = Math.max(
                f(i - 1, j, s, t, dp),
                f(i, j - 1, s, t, dp)
        );
    }

    static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(n - 1, m - 1, s, t, dp);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "bdgek";

        System.out.println(lcs(s, t));
    }
}
