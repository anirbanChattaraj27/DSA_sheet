
import java.util.Arrays;

class knapsack {
    // Utility function for solving the unbounded knapsack problem using recursion + memoization
    public int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: if we're at the first item
        if (ind == 0) {
            // Calculate and return the maximum value for the given weight limit
            return (W / wt[0]) * val[0];
        }

        // If the result for this index and weight limit is already calculated, return it
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        // Calculate the maximum value without taking the current item
        int notTaken = knapsackUtil(wt, val, ind - 1, W, dp);

        // Initialize 'taken' with a very small value
        int taken = Integer.MIN_VALUE;

        // If current item can fit in the remaining capacity
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil(wt, val, ind, W - wt[ind], dp);
        }

        // Store and return the maximum of taking or not taking the current item
        return dp[ind][W] = Math.max(notTaken, taken);
    }

    // Main function to call the utility function and set up DP table
    public int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        // Create a DP table
        int[][] dp = new int[n][W + 1];

        // Initialise with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function and return the answer
        return knapsackUtil(wt, val, n - 1, W, dp);
    }
}

// Driver code
public class O10_unbounded_knapsack_memoization {
    public static void main(String[] args) {
        // Initialize item weights
        int[] wt = {2, 4, 6};

        // Initialize item values
        int[] val = {5, 11, 13};

        // Weight capacity of the knapsack
        int W = 10;

        // Number of items
        int n = wt.length;

        // Create Solution object
        knapsack obj = new knapsack();

        // Output the result
        System.out.println("The Maximum value of items the thief can steal is " 
             + obj.unboundedKnapsack(n, W, val, wt));
    }
}
