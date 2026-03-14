public class O3_I_Buy_sell_stock_III_recursion {

    static int f(int ind, int buy, int cap, int[] prices, int n) {

        if (ind == n || cap == 0) {
            return 0;
        }

        if (buy == 1) {
            return Math.max(
                    -prices[ind] + f(ind + 1, 0, cap, prices, n),
                    0 + f(ind + 1, 1, cap, prices, n)
            );
        }

        return Math.max(
                prices[ind] + f(ind + 1, 1, cap - 1, prices, n),
                0 + f(ind + 1, 0, cap, prices, n)
        );
    }

    static int maxProfit(int[] prices, int n) {
        return f(0, 1, 2, prices, n);
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        int profit = maxProfit(prices, n);

        System.out.println("Maximum Profit: " + profit);
    }
}