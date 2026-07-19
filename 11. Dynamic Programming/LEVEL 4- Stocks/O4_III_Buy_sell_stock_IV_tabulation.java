/*
Time Complexity: O(N*2*3), There are three nested loops that account for O(N*2*3) complexity.

Space Complexity: O(N*2*3), We are using an external array of size ‘N*2*3’. Stack Space is eliminated.
*/

import java.util.Arrays;

public class O4_III_Buy_sell_stock_IV_tabulation {
    
    // Function to calculate the maximum profit
    public static int maximumProfit(int[] prices, int n, int k) {
        // Creating a 3D array dp of size [n+1][2][k+1] initialized to 0
        int[][][] dp = new int[n + 1][2][k + 1];
        
        // As dp array is initialized to 0, we have already covered the base case
        
        // Iterate through the array and fill in the dp array
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], 
                                -prices[ind] + dp[ind + 1][1][cap]);
                    } else { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        
        return dp[0][0][k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int k = 2;
        
        System.out.println("The maximum profit that can be generated is " + maximumProfit(prices, n, k));
    }
}
