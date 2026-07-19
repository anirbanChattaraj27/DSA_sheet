
/*
Time Complexity: O(N*2*3), There are three nested loops that account for O(N*2*3) complexity

Space Complexity: O(1), We are using two external arrays of size ‘2*3’.
*/

import java.util.*;

class StockBuySell {
    // Function to calculate maximum profit with at most k transactions
    public int maximumProfit(int[] prices, int n, int k) {
        // 3D DP array: dp[day][buy/sell][remaining transactions]
        int[][][] dp = new int[n + 1][2][k + 1];

        // Fill DP table in reverse order (bottom-up)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) { // 0 = can buy, 1 = can sell
                for (int cap = 1; cap <= k; cap++) { // cap = remaining transactions
                    if (buy == 0) {
                        // Either do nothing OR buy the stock
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    } else {
                        // Either do nothing OR sell the stock
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        // Final answer: starting at day 0, with buy option, and k transactions allowed
        return dp[0][0][k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int k = 2;
        StockBuySell sbs = new StockBuySell();
        System.out.println("The maximum profit that can be generated is " +
                sbs.maximumProfit(prices, n, k));
    }
}
