import java.util.*;

class Solution {
    // Function to compute max value by cutting rod using top-down DP
    public int rodCutting(int[] price, int n) {
        // Create DP table initialized to -1
        int[][] dp = new int[n][n + 1];

        // Fill dp with -1 to indicate uncomputed subproblems
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from last index (n - 1)
        return helper(n - 1, n, price, dp);
    }

    // Recursive helper function with memoization
    private int helper(int i, int length, int[] price, int[][] dp) {
        // Base case: only one rod piece of length 1
        if (i == 0) {
            return length * price[0];
        }

        // Return precomputed value
        if (dp[i][length] != -1) return dp[i][length];

        // Option 1: do not take current rod length
        int notTake = helper(i - 1, length, price, dp);

        // Option 2: take current rod length (if it fits)
        int take = Integer.MIN_VALUE;
        int rodLength = i + 1;
        if (rodLength <= length) {
            take = price[i] + helper(i, length - rodLength, price, dp);
        }

        // Store max of both in dp
        return dp[i][length] = Math.max(take, notTake);
    }
}

// Driver class
public class O11_rod_cutting_memoization {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Price list
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        // Total rod length
        int n = 8;

        // Output result
        int result = sol.rodCutting(price, n);
        System.out.println("The maximum obtainable value is: " + result);
    }
}

/*
Problem Statement: Given a rod of length N inches and an array price[] where price[i] denotes 
the value of a piece of rod of length i inches (1-based indexing). Determine the maximum value
obtainable by cutting up the rod and selling the pieces. Make any number of cuts, or none at 
all, and sell the resulting pieces.

Input : price = [1, 6, 8, 9, 10, 19, 7, 20], N = 8
Output :25
Explanation :Cut the rod into lengths of 2 and 6 for a total price of 6 + 19= 25.

Input :price = [1, 5, 8, 9], N = 4
Output :10
Explanation :Cut the rod into lengths of 2 and 2 for a total price of 5 + 5 = 10.

*/