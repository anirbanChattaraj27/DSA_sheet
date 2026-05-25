// code from chatgpt, direct asked gpt for this code did not give image to produce the code, if dont understand use video to generate code


public class O2_III_Buy_sell_stock_II_tabulation {

    // Function to get the maximum profit using tabulation (bottom-up approach)
    public static long getMaximumProfit(long[] values, int n) {
        // DP table: dp[ind][buy] where:
        // dp[ind][0] = max profit we can get until day 'ind' without having a stock
        // dp[ind][1] = max profit we can get until day 'ind' with having a stock
        long[][] dp = new long[n + 1][2];

        // Initialize dp table: base case when there are no days (profit = 0)
        dp[n][0] = dp[n][1] = 0; // No profit can be made if there are no days left

        // Iterate over the days in reverse order (bottom-up approach)
        for (int ind = n - 1; ind >= 0; ind--) {
            // If we are allowed to buy (buy == 1), try to buy or skip
            dp[ind][1] = Math.max(-values[ind] + dp[ind + 1][0], dp[ind + 1][1]); // Buy the stock or skip buying
            
            // If we cannot buy (buy == 0), try to sell or skip
            dp[ind][0] = Math.max(values[ind] + dp[ind + 1][1], dp[ind + 1][0]); // Sell the stock or skip selling
        }

        // Return the result stored in dp[0][1], which represents the max profit starting from day 0 with the option to buy
        return dp[0][1];
    }

    // Main function to test the logic
    public static void main(String[] args) {
        long[] stockPrices = {1, 2, 3, 0, 2}; // Example array of stock prices
        int n = stockPrices.length; // Length of the stock prices array

        // Get the maximum profit
        long maxProfit = getMaximumProfit(stockPrices, n);

        // Print the result
        System.out.println("Maximum Profit: " + maxProfit);
    }
}