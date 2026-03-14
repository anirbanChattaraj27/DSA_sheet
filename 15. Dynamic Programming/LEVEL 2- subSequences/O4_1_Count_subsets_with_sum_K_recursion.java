/*
    Class Name: O4_1_Count_subsets_with_sum_K_recursion

    This program counts the number of subsets
    whose sum equals K using Pure Recursion.
*/

public class O4_1_Count_subsets_with_sum_K_recursion {

    /*
        Recursive Function

        ind -> current index
        sum -> remaining target sum
        num -> input array

        Returns number of subsets
    */
    public static int f(int ind, int sum, int[] num) {

        // ✅ Base Case 1:
        // If sum becomes 0, we found one valid subset
        if (sum == 0)
            return 1;

        // ✅ Base Case 2:
        // If only first element left
        if (ind == 0)
            return (num[0] == sum) ? 1 : 0;

        // 🔹 Not Take
        int notTake = f(ind - 1, sum, num);

        // 🔹 Take (only if element <= sum)
        int take = 0;
        if (num[ind] <= sum)
            take = f(ind - 1, sum - num[ind], num);

        // Return total ways
        return notTake + take;
    }


    // Function called from main
    public static int findWays(int[] num, int tar) {

        int n = num.length;

        return f(n - 1, tar, num);
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] num = {1, 2, 2, 3};
        int target = 3;

        int result = findWays(num, target);

        System.out.println("Number of subsets with sum " + target + " : " + result);
    }
}