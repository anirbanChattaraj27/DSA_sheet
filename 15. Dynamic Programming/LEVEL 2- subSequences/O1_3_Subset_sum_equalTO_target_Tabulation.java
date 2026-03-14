
public class O1_3_Subset_sum_equalTO_target_Tabulation {

    public static boolean subsetSumToK(int n, int k, int[] arr) {

        /*
            STEP 1: Create DP table

            dp[ind][target] =
                true  -> subset exists from 0..ind with sum = target
                false -> no subset exists

            Size:
                n rows
                k+1 columns (target 0 to k)
        */
        boolean[][] dp = new boolean[n][k + 1];


        /*
            STEP 2: Base Case Initialization

            Target = 0 is always possible
            (by taking empty subset)
        */
        for (int i = 0; i < n; i++) {  // base case in Recursion: if(target == 0) return true // any moment target becomes 0 return true, and what value target will become 0? for 0 to n-1 target will be 0. 
            dp[i][0] = true; // dp[idx][target] // so when idx value is i means 0 to n-1, and target is 0 then return true
        }


        /*
            If first element is <= k, "First Element is Base Case"
            then we can make that target using only first element
        */
        if (arr[0] <= k) { // base case 2 in recursion: when idx == 0, return true if it's equal to target // so idx is 0 but target can be anything 
            dp[0][arr[0]] = true; // if(idx==0) return a[0] = target
        }

        /*
            STEP 3: Fill DP table 

            Build answers from smaller index
            to larger index (Bottom-Up approach)
        */
        for (int ind = 1; ind < n; ind++) {

            for (int target = 1; target <= k; target++) {

                // Not taking current element
                boolean notTake = dp[ind - 1][target];

                // Taking current element
                boolean take = false;
                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        /*
            Final answer:
            Can we make sum k using elements 0..n-1 ?
        */
        return dp[n - 1][k];
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int k = 5;

        boolean result = subsetSumToK(n, k, arr);

        if (result)
            System.out.println("Subset with given target exists.");
        else
            System.out.println("Subset with given target does NOT exist.");
    }
}

/*
| Approach    | Time Complexity | Space Complexity | Recursion Stack |
| ----------- | --------------- | ---------------- | --------------- |
| Recursion   | O(2ⁿ)           | O(n)             | Yes             |
| Memoization | O(n × k)        | O(n × k)         | Yes             |
| Tabulation  | O(n × k)        | O(n × k)         | No              |
 */