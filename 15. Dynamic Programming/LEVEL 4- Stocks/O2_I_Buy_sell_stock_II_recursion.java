public class O2_I_Buy_sell_stock_II_recursion {

    // Helper function to calculate the maximum profit using recursion
    private static long f(int ind, int buy, long[] values, int n) {
        // Base case: if we've processed all elements, return 0
        if (ind == n) return 0;

        // Variable to store the profit at each step
        long profit = 0;

        // If we are allowed to buy (buy == 1), try to buy or skip
        if (buy == 1) {
            profit = Math.max(-values[ind] + f(ind + 1, 0, values, n), // Buy the stock
                              f(ind + 1, 1, values, n)); // Skip buying the stock
        } else { 
            // If we cannot buy (buy == 0), try to sell or skip
            profit = Math.max(values[ind] + f(ind + 1, 1, values, n), // Sell the stock
                              f(ind + 1, 0, values, n)); // Skip selling the stock
        }
        
        // Return the calculated profit
        return profit;
    }

    // Function to get the maximum profit by calling the helper function with initial parameters
    public static long getMaximumProfit(long[] values, int n) {
        return f(0, 1, values, n); // Start from index 0 with buy option allowed (buy == 1)
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