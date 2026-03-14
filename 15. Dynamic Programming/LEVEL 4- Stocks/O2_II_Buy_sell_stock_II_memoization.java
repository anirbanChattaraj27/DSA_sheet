public class O2_II_Buy_sell_stock_II_memoization {

    // Helper function to calculate the maximum profit using memoization
    private static long f(int ind, int buy, long[] values, int n, long[][] memo) {
        // Base case: if we've processed all elements, return 0
        if (ind == n) return 0;

        // Check if the result for this subproblem is already computed
        if (memo[ind][buy] != -1) {
            return memo[ind][buy];
        }

        // Variable to store the profit at each step
        long profit = 0;

        // If we are allowed to buy (buy == 1), try to buy or skip
        if (buy == 1) {
            profit = Math.max(-values[ind] + f(ind + 1, 0, values, n, memo), // Buy the stock
                              f(ind + 1, 1, values, n, memo)); // Skip buying the stock
        } else {
            // If we cannot buy (buy == 0), try to sell or skip
            profit = Math.max(values[ind] + f(ind + 1, 1, values, n, memo), // Sell the stock
                              f(ind + 1, 0, values, n, memo)); // Skip selling the stock
        }

        // Memoize the result
        memo[ind][buy] = profit;
        
        // Return the computed profit
        return profit;
    }

    // Function to get the maximum profit by calling the helper function with initial parameters
    public static long getMaximumProfit(long[] values, int n) {
        // Memoization table: n x 2 matrix initialized with -1 (for uncomputed states)
        long[][] memo = new long[n][2];
        
        // Initialize memoization table with -1 (indicating not computed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                memo[i][j] = -1;
            }
        }
        
        return f(0, 1, values, n, memo); // Start from index 0 with buy option allowed (buy == 1)
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