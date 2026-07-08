 

import java.util.Arrays;
import java.util.List;

public class O6_ii_0_1_knapsack_memoization {

    public static int f(int ind, int W, List<Integer> wt, List<Integer> val, int[][] dp) {
        if (ind == 0) {
            if (wt.get(0) <= W) 
                return val.get(0);
            return 0;
        }

        if (dp[ind][W] != -1) return dp[ind][W];

        int notTake = 0 + f(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (wt.get(ind) <= W) {
            take = val.get(ind) + f(ind - 1, W - wt.get(ind), wt, val, dp);
        }

        return dp[ind][W] = Math.max(take, notTake);
    }

    public static int knapsack(List<Integer> weight, List<Integer> value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, maxWeight, weight, value, dp);
    }

    public static void main(String[] args) {
        // Test Case Data
        List<Integer> weight = Arrays.asList(1, 2, 4, 5);
        List<Integer> value = Arrays.asList(5, 4, 8, 6);
        int maxWeight = 5;
        int n = weight.size();

        // Run the knapsack function
        int maxProfit = knapsack(weight, value, n, maxWeight);

        // Print results
        System.out.println("Weights: " + weight);
        System.out.println("Values:  " + value);
        System.out.println("Knapsack Capacity: " + maxWeight);
        System.out.println("Maximum Profit:    " + maxProfit);
    }
}
