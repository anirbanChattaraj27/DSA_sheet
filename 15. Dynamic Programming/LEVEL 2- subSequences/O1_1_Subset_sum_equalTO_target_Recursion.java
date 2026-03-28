// copy 14

public class O1_1_Subset_sum_equalTO_target_Recursion {

    /*
     * Problem:
     * Given an array and a target,
     * return true if there exists a subset whose sum = target.
     *
     * At every index we have 2 choices:
     * 1️⃣ Take the element
     * 2️⃣ Do not take the element
     */

    // Recursive function
    // ind    → current index
    // target → remaining target to achieve
    public static boolean f(int ind, int target, int[] arr) {

        // ✅ Base Case 1:
        // If target becomes 0 → subset found
        if (target == 0)
            return true;

        // ✅ Base Case 2:
        // If we are at index 0,
        // check if that single element equals target
        if (ind == 0)
            return arr[0] == target;

        // 🔹 Choice 1: Do NOT take current element
        boolean notTake = f(ind - 1, target, arr);

        // 🔹 Choice 2: Take current element (only if <= target)
        boolean take = false;
        if (arr[ind] <= target)
            take = f(ind - 1, target - arr[ind], arr);

        // If any choice returns true → return true
        return take || notTake;
    }

    // Wrapper function
    public static boolean subsetSumToK(int n, int k, int[] arr) {

        // Start recursion from last index
        return f(n - 1, k, arr);
    }

    // Driver code
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int k = 9;

        boolean result = subsetSumToK(arr.length, k, arr);

        System.out.println("Subset with given target exists: " + result);
    }
}

/*
| Approach    | Time Complexity | Space Complexity | Recursion Stack |
| ----------- | --------------- | ---------------- | --------------- |
| Recursion   | O(2ⁿ)           | O(n)             | Yes             |
| Memoization | O(n × k)        | O(n × k)         | Yes             |
| Tabulation  | O(n × k)        | O(n × k)         | No              |
*/