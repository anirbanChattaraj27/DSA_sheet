// code from chatgpt, direct asked gpt for this code did not give image to produce the code, if dont understand use video to generate code


public class O2_IV_Buy_sell_stock_II_Space_Optimization {

    // Function to get the maximum profit using space optimization
    public static long getMaximumProfit(long[] values, int n) {
        // Variables to store the maximum profit for the previous day when holding a stock (prev1) or not holding a stock (prev2)
        long prev1 = 0, prev2 = 0;

        // Iterate over the days in reverse order (bottom-up approach)
        for (int ind = n - 1; ind >= 0; ind--) {
            // Calculate profit when we are allowed to buy (buy == 1)
            long curr1 = Math.max(-values[ind] + prev2, prev1); // Buy the stock or skip buying
            
            // Calculate profit when we are not allowed to buy (buy == 0)
            long curr2 = Math.max(values[ind] + prev1, prev2); // Sell the stock or skip selling

            // Update prev1 and prev2 for the next iteration
            prev1 = curr1;
            prev2 = curr2;
        }

        // Return the result stored in prev1, which represents the max profit starting from day 0 with the option to buy
        return prev1;
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