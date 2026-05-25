import java.util.Arrays;

public class O2_2_Unique_Path_memoization {

    // Recursive function with DP array
    public static int f(int i, int j, int[][] dp) {

        // Base case: reached starting cell
        if (i == 0 && j == 0)
            return 1;

        // Out of bounds
        if (i < 0 || j < 0)
            return 0;

        // 🔵 Memoization check (NEW)
        if (dp[i][j] != -1)
            return dp[i][j];

        // Recursive calls
        int up = f(i - 1, j, dp);
        int left = f(i, j - 1, dp);

        // 🔵 Store result before returning (NEW)
        return dp[i][j] = up + left;
    }

    public static int uniquePaths(int m, int n) {

        // 🔵 Create DP array (NEW)
        int[][] dp = new int[m][n];

        // Initialize with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // IMPORTANT: pass dp array in function call
        return f(m - 1, n - 1, dp);
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        System.out.println("Number of Unique Paths: " + uniquePaths(m, n));
    }
}
