
import java.util.Arrays;

public class O3_2_Frog_jump_Memoization {

    public static int f(int ind, int[] heights, int[] dp) {

        // ✅ Base Case
        if (ind == 0)
            return 0;

        // ✅ If already computed, return stored value
        if (dp[ind] != -1)
            return dp[ind];

        // 🔹 Jump from (ind - 1)
        int left = f(ind - 1, heights, dp)
                + Math.abs(heights[ind] - heights[ind - 1]);

        // 🔹 Jump from (ind - 2)
        int right = Integer.MAX_VALUE;

        if (ind > 1) {
            right = f(ind - 2, heights, dp)
                    + Math.abs(heights[ind] - heights[ind - 2]);
        }

        // Store result before returning
        dp[ind] = Math.min(left, right);

        return dp[ind];
    }


    // Function called from main
    public static int frogJump(int n, int[] heights) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(n - 1, heights, dp);
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;

        int result = frogJump(n, heights);

        System.out.println("Minimum Energy Required: " + result);
    }
}