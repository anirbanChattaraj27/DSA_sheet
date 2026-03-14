// https://leetcode.com/problems/unique-paths/submissions/1924669589/

public class O2_1_Unique_Path_recursion {

    // Recursive function
    public static int f(int i, int j) {

        // Base case: reached starting cell
        if (i == 0 && j == 0)
            return 1;

        // Out of bounds
        if (i < 0 || j < 0)
            return 0;

        // Move up
        int up = f(i - 1, j);

        // Move left
        int left = f(i, j - 1);

        return up + left;
    }

    // Function to calculate unique paths
    public static int uniquePaths(int m, int n) {
        return f(m - 1, n - 1);
    }

    // Main function (without Scanner)
    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        int result = uniquePaths(m, n);

        System.out.println("Number of Unique Paths: " + result);
    }
}


/*
| Version         | Time        | Space  |
| --------------- | ----------- | ------ |
| Recursion       | Exponential | Stack  |
| Memoization     | O(m×n)      | O(m×n) |
| Tabulation      | O(m×n)      | O(m×n) |
| Space Optimized | O(m×n)      | O(n) ✅ |


*/