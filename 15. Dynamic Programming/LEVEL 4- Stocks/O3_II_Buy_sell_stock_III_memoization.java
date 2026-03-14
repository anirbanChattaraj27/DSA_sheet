import java.util.Arrays;

public class O3_II_Buy_sell_stock_III_memoization {

    static int f(int ind, int buy, int cap, int[] prices, int n, int[][][] dp) {

        if (ind == n || cap == 0) {
            return 0;
        }

        // DP ARRAY USED: If this state is already computed, return stored value
        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }

        int profit;

        if (buy == 1) {

            profit = Math.max(
                    -prices[ind] + f(ind + 1, 0, cap, prices, n, dp),
                    0 + f(ind + 1, 1, cap, prices, n, dp)
            );

        } else {

            profit = Math.max(
                    prices[ind] + f(ind + 1, 1, cap - 1, prices, n, dp),
                    0 + f(ind + 1, 0, cap, prices, n, dp)
            );
        }

        // DP ARRAY USED: Store the computed result before returning
        return dp[ind][buy][cap] = profit;
    }

    static int maxProfit(int[] prices, int n) {

        // DP ARRAY CREATED: dimensions -> [index][buy][cap]
        int[][][] dp = new int[n][2][3];

        // Initialize dp array with -1 (means not computed)
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        return f(0, 1, 2, prices, n, dp);
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        int profit = maxProfit(prices, n);

        System.out.println("Maximum Profit: " + profit);
    }
}