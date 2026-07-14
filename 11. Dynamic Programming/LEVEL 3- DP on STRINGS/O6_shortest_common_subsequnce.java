
import java.util.Arrays;

public class O6_shortest_common_subsequnce {

    static int minSuperSeqRec(String s1, String s2, int m, int n,
                              int[][] dp) {
  
        // If s1 is empty, take all of s2
        if (m == 0)
            return n;

        // If s2 is empty, take all of s1
        if (n == 0)
            return m;

        // check before solve the subproblem
        if (dp[m][n] != -1)
            return dp[m][n];

        // If last chars match, include once
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = 1 + minSuperSeqRec(s1, s2, m - 1, n - 1, dp);

        // If not match, try both options and take min 
        // and store it in dp array
        return dp[m][n] =
                   1 + Math.min(minSuperSeqRec(s1, s2, m - 1, n, dp),
                                minSuperSeqRec(s1, s2, m, n - 1, dp));
    }

    static int minSuperSeq(String s1, String s2) {
  
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minSuperSeqRec(s1, s2, m, n, dp);
    }

    public static void main(String[] args) {
  
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int res = minSuperSeq(s1, s2);

        System.out.println(res);
    }
}
