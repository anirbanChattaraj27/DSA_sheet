import java.util.Arrays;

public class O7_2_Min_coins_Memoization {

    public int f(int ind, int T, int[] coins, int[][] dp) {
        // Base Case: If we are at the first coin index
        if (ind == 0) {
            if (T % coins[0] == 0) {
                return T / coins[0];
            }
            return (int) 1e9; // Return a large value representing infinity
        }

        // Memoization check
        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        // Option 1: Do not take the current coin
        int notTake = 0 + f(ind - 1, T, coins, dp);

        // Option 2: Take the current coin
        int take = (int) 1e9;
        if (coins[ind] <= T) {
            take = 1 + f(ind, T - coins[ind], coins, dp);
        }

        // Store the result in the DP table and return
        return dp[ind][T] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        // Initialize DP table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = f(n - 1, amount, coins, dp);

        // If the result is infinity, it means the amount cannot be formed
        if (result >= (int) 1e9) {
            return -1;
        }
        return result;
    }

    // Main method included inside the matching file class
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        O7_2_Min_coins_Memoization obj = new O7_2_Min_coins_Memoization ();
        int answer = obj.coinChange(coins, amount);
        
        System.out.println("Coins: " + Arrays.toString(coins));
        System.out.println("Target Amount: " + amount);
        System.out.println("Minimum Coins Needed: " + answer); // Expected Output: 3
    }
}
