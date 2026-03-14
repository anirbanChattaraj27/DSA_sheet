public class O5_1_Triangle_Recursion {

    /*
     * Recursive function to calculate minimum path sum in triangle
     *
     * i = current row
     * j = current column
     * n = total number of rows
     */
    public static int f(int i, int j, int[][] triangle, int n) {

        // 🔹 Base Case:
        // If we reach last row, simply return that value
        if (i == n - 1) {
            return triangle[n - 1][j];
        }

        // Move Down (same column)
        int down = triangle[i][j] + f(i + 1, j, triangle, n);

        // Move Diagonal (next column)
        int diagonal = triangle[i][j] + f(i + 1, j + 1, triangle, n);

        // Return minimum of both choices
        return Math.min(down, diagonal);
    }

    /*
     * Function to start recursion from top (0,0)
     */
    public static int minimumPathSum(int[][] triangle, int n) {

        return f(0, 0, triangle, n);
    }

    // Main method to test
    public static void main(String[] args) {

        int[][] triangle = {
                {1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}
        };

        int n = triangle.length;

        int result = minimumPathSum(triangle, n);

        System.out.println("Minimum Path Sum in Triangle: " + result);
    }
}

/*
| Version     | Time Complexity | Space Complexity | Why               |
| ----------- | --------------- | ---------------- | ----------------- |
| Recursion   | O(2^n)          | O(n)             | Recomputes states |
| Memoization | O(n²)           | O(n²)            | Stores states     |
| Tabulation  | O(n²)           | O(n²)            | Iterative DP      |
*/