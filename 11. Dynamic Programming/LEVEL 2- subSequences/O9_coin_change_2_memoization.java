
import java.util.*;

public class O9_coin_change_2_memoization {
    // Recursive function with memoization
    private long countWaysToMakeChangeUtil(int[] arr, int ind, int T, long[][] dp) {
        if (ind == 0) {
            return (T % arr[0] == 0) ? 1 : 0;
        }
        if (dp[ind][T] != -1) return dp[ind][T];

        long notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);
        long taken = 0; 
        if (arr[ind] <= T) {
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);
        }
        return dp[ind][T] = notTaken + taken;
    }

    public long countWaysToMakeChange(int[] arr, int n, int T) {
        long[][] dp = new long[n][T + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 4;
        int n = arr.length;

        O9_coin_change_2_memoization sol = new O9_coin_change_2_memoization();
        System.out.println("The total number of ways is " + sol.countWaysToMakeChange(arr, n, target));
    }
}
