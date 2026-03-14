import java.util.*;

public class O5_2_Count_partition_with_given_difference_Memoization {

    // Constant for modulo operation (10^9 + 7)
    static int MOD = (int) 1e9 + 7;

    /**
     * Recursive function with memoization
     * Counts number of subsets from index 0..ind whose sum equals 'sum'
     */
    static int f(int ind, int sum, int[] num, int[][] dp) {

        // Base Case: When we are at index 0
        if (ind == 0) {

            // If sum = 0 and element is also 0,
            // we have two choices: take or not take
            if (sum == 0 && num[0] == 0)
                return 2;

            // If sum is 0 (not take) OR
            // sum equals num[0] (take it)
            if (sum == 0 || sum == num[0])
                return 1;

            // Otherwise no valid subset
            return 0;
        }

        // If already computed, return stored value
        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        // Not take current element
        int notTake = f(ind - 1, sum, num, dp);

        // Take current element (only if <= sum)
        int take = 0;
        if (num[ind] <= sum)
            take = f(ind - 1, sum - num[ind], num, dp);

        // Store result in dp table and return
        return dp[ind][sum] = (notTake + take) % MOD;
    }

    /**
     * Helper function to initialize DP array
     */
    static int findWays(int[] num, int target) {

        int n = num.length;

        // dp[n][target+1], initialized with -1
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n - 1, target, num, dp);
    }

    /**
     * Main function to count partitions with given difference
     *
     * Logic:
     * Let total sum = S
     * We need S1 - S2 = d
     * Also S1 + S2 = S
     *
     * Solving equations:
     * S1 = (S - d) / 2
     *
     * So problem reduces to:
     * Count subsets with sum = (S - d)/2
     */
    static int countPartitions(int n, int d, int[] arr) {

        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        // If (totalSum - d) is negative or odd, no valid partition
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0)
            return 0;

        return findWays(arr, (totalSum - d) / 2);
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {

        // Example input
        int[] arr = {5, 2, 6, 4};
        int n = arr.length;
        int d = 3;

        int result = countPartitions(n, d, arr);

        System.out.println("Number of partitions with difference " + d + " = " + result);

        /*
           You can test with custom input like this:

           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           int d = sc.nextInt();
           int[] arr = new int[n];
           for(int i = 0; i < n; i++) {
               arr[i] = sc.nextInt();
           }
           System.out.println(countPartitions(n, d, arr));
        */
    }
}