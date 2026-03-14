
// code from chatgpt, direct asked gpt for this code did not give image to produce the code, if dont understand use video to generate code
public class O3_IV_Buy_sell_stock_III_space_optimization {

    static int maxProfit(int[] prices, int n) {

        // ahead -> represents dp[ind+1]
        int[][] ahead = new int[2][3];

        // curr -> represents dp[ind]
        int[][] curr = new int[2][3];

        // traverse from last day to first day
        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {

                        // Option 1: Buy the stock
                        int buyStock = -prices[ind] + ahead[0][cap];

                        // Option 2: Skip buying
                        int skip = ahead[1][cap];

                        curr[buy][cap] = Math.max(buyStock, skip);

                    } else {

                        // Option 1: Sell the stock
                        int sellStock = prices[ind] + ahead[1][cap - 1];

                        // Option 2: Skip selling
                        int skip = ahead[0][cap];

                        curr[buy][cap] = Math.max(sellStock, skip);
                    }
                }
            }

            // move current row to ahead for next iteration
            ahead = curr;
            curr = new int[2][3];
        }

        // starting state
        return ahead[1][2];
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        int profit = maxProfit(prices, n);

        System.out.println("Maximum Profit: " + profit);
    }
}