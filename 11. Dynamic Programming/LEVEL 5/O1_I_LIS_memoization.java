/*
Method 1: Recursion
Time: O(2^n) ❌

Method 2: Memoization
Time: O(n²)
Space: O(n²) ✅ ---> O(n²) for the DP table + O(n) recursion stack

Method 3: Binary Search (Patience Sorting)
Time: O(n log n)
Space: O(n) ✅

Method 4: Tabulation
Time: O(n²)
Space: O(n²) (or optimized) ✅
 */

/*
nums = [10, 9, 2, 5, 3, 7, 101, 18]
o/p: 4
2 → 3 → 7 → 18
2 → 5 → 7 → 101

nums = [4, 10, 4, 3, 8, 9]
o/p: 3
4 → 8 → 9
3 → 8 → 9

*/

import java.util.Arrays;

public class O1_I_LIS_memoization {

    static int[][] dp;

    public static int lis(int index, int prevIndex, int[] arr) {

        // Base Case
        if (index == arr.length) {
            return 0;
        }

        // Already computed
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        // Option 1: Skip current element
        int notTake = lis(index + 1, prevIndex, arr);

        // Option 2: Take current element
        int take = 0;
        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + lis(index + 1, index, arr);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    /*
    index → Current position in the array.
    prevIndex → Index of the last element included in the LIS.
    prevIndex = -1 means no element has been chosen yet.
    */

    public static void main(String[] args) {

        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        // prevIndex ranges from -1 to n-1
        dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = lis(0, -1, arr);

        System.out.println("Length of LIS = " + ans);
    }
}
