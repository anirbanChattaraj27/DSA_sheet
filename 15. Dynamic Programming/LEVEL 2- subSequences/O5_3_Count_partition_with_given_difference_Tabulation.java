import java.util.*;

public class O5_3_Count_partition_with_given_difference_Tabulation {

    // Mod value to prevent overflow
    static int MOD = (int) 1e9 + 7;

    /**
     * Tabulation method to count subsets with given target sum
     */
    static int findWays(int[] num, int tar) {

        int n = num.length;

        // DP table: dp[i][sum] = number of ways to form 'sum'
        // using elements from index 0 to i
        int[][] dp = new int[n][tar + 1];

        // Base Case Initialization for index 0

        // If first element is 0,
        // we can either take it or not take it for sum = 0
        if (num[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        // If first element is not zero and <= target,
        // we can form that sum by taking it
        if (num[0] != 0 && num[0] <= tar)
            dp[0][num[0]] = 1;

        // Fill the DP table
        for (int ind = 1; ind < n; ind++) {
            for (int sum = 0; sum <= tar; sum++) {

                // Not take current element
                int notTake = dp[ind - 1][sum];

                // Take current element (if possible)
                int take = 0;
                if (num[ind] <= sum)
                    take = dp[ind - 1][sum - num[ind]];

                dp[ind][sum] = (notTake + take) % MOD;
            }
        }

        return dp[n - 1][tar];
    }

    /**
     * Count partitions with given difference
     *
     * We know:
     * S1 - S2 = d
     * S1 + S2 = totalSum
     *
     * => S1 = (totalSum - d) / 2
     *
     * So we count subsets with sum = (totalSum - d)/2
     */
    static int countPartitions(int n, int d, int[] arr) {

        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        // If invalid case
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0)
            return 0;

        int target = (totalSum - d) / 2;

        return findWays(arr, target);
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {

        // Example Test Case
        int[] arr = {5, 2, 6, 4};
        int d = 3;
        int n = arr.length;

        int result = countPartitions(n, d, arr);

        System.out.println("Number of partitions with difference " + d + " = " + result);

        /*
        // Uncomment for custom input

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(countPartitions(n, d, arr));
        */
    }
}