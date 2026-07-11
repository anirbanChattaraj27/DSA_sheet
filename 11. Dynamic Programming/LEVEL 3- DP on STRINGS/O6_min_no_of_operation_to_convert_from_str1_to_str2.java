
import java.util.*;

public class O6_min_no_of_operation_to_convert_from_str1_to_str2 {

    // Your exact recursive function to compute LCS using memoization
    public static int lcs(int i, int j, String s, String t, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) { 
            return dp[i][j];
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = 1 + lcs(i - 1, j - 1, s, t, dp);
        } else {
            int moveLeft = lcs(i - 1, j, s, t, dp);
            int moveRight = lcs(i, j - 1, s, t, dp);
            dp[i][j] = Math.max(moveLeft, moveRight);
        }

        return dp[i][j];
    }

    // NEW PART: Problem solver function
    public static int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // DP array initialized with -1
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // 1. Find the length of the longest common sequence
        int lcsLength = lcs(n, m, str1, str2, dp);

        // 2. Apply formula: (n - lcs) deletions + (m - lcs) insertions
        int deletions = n - lcsLength;
        int insertions = m - lcsLength;

        return deletions + insertions;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";
        
        // LCS of "abcd" and "anc" is "ac" (length 2)
        // Deletions from str1 = 4 - 2 = 2 (remove 'b' and 'd')
        // Insertions to str1  = 3 - 2 = 1 (add 'n')
        // Total operations = 2 + 1 = 3
        System.out.println("Minimum operations: " + minDistance(str1, str2)); // Output: 3
    }
}
