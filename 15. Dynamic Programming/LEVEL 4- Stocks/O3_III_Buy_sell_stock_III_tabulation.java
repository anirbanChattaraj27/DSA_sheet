// code from chatgpt, direct asked gpt for this code did not give image to produce the code, if dont understand use video to generate code
 
public class O3_III_Buy_sell_stock_III_tabulation {

    static int maxProfit(int[] prices, int n) {

        // dp[ind][buy][cap]
        // ind -> current day
        // buy -> 1 means we can buy, 0 means we must sell
        // cap -> number of transactions remaining

        int[][][] dp = new int[n + 1][2][3];

        // Base Case already handled because Java initializes array with 0
        // dp[n][buy][cap] = 0  -> no days left
        // dp[ind][buy][0] = 0  -> no transactions left

        // We fill the table from back (n-1) to front (0)
        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {

                        // Transition when we are allowed to BUY

                        int buyStock =
                                -prices[ind] + dp[ind + 1][0][cap];
                        // If we buy today, money decreases and next state becomes SELL

                        int skip =
                                dp[ind + 1][1][cap];
                        // If we skip buying today, state remains BUY

                        dp[ind][buy][cap] = Math.max(buyStock, skip);

                    } else {

                        // Transition when we must SELL

                        int sellStock =
                                prices[ind] + dp[ind + 1][1][cap - 1];
                        // If we sell today, transaction count decreases

                        int skip =
                                dp[ind + 1][0][cap];
                        // If we skip selling, remain in SELL state

                        dp[ind][buy][cap] = Math.max(sellStock, skip);
                    }
                }
            }
        }

        // Starting state: day 0, allowed to buy, 2 transactions available
        return dp[0][1][2];
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        int profit = maxProfit(prices, n);

        System.out.println("Maximum Profit: " + profit);
    }
}