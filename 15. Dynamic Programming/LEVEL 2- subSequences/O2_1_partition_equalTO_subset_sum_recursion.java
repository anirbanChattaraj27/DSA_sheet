// copy 15

public class O2_1_partition_equalTO_subset_sum_recursion {

    /*
        Recursive function to check if subset with given target exists

        ind    -> current index
        target -> remaining target sum
        arr    -> input array
    */
    public static boolean f(int ind, int target, int[] arr) {

        // ✅ Base Case 1: If target becomes 0 → subset found
        if (target == 0)
            return true;

        // ✅ Base Case 2: If only first element left
        if (ind == 0)
            return arr[0] == target;

        // 🔹 Choice 1: Do NOT take current element
        boolean notTake = f(ind - 1, target, arr);

        // 🔹 Choice 2: Take current element (if possible)
        boolean take = false;
        if (arr[ind] <= target)
            take = f(ind - 1, target - arr[ind], arr);

        return take || notTake;
    }


    /*
        This method checks if array can be divided into
        two subsets with equal sum.

        Logic:
        1. Find total sum
        2. If sum is odd → cannot divide equally
        3. Target = totalSum / 2
        4. Check if subset with target exists
    */
    public static boolean canPartition(int[] arr, int n) {

        int totSum = 0;

        for (int i = 0; i < n; i++)
            totSum += arr[i];

        // If total sum is odd → cannot divide into 2 equal parts
        if (totSum % 2 != 0)
            return false;

        int target = totSum / 2;

        // Check subset sum equal to target
        return f(n - 1, target, arr);
    }


    // 🔹 Main Function
    public static void main(String[] args) {

        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        boolean result = canPartition(arr, n);

        if (result)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

/*
| Approach    | Time Complexity | Space Complexity | Stack Used? |
| ----------- | --------------- | ---------------- | ----------- |
| Recursion   | O(2^n)          | O(n)             | ✅ Yes       |
| Memoization | O(n × target)   | O(n × target)    | ✅ Yes       |
| Tabulation  | O(n × target)   | O(n × target)    | ❌ No        |
 */