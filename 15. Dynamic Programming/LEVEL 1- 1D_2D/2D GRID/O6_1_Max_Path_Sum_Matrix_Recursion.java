public class O6_1_Max_Path_Sum_Matrix_Recursion {

    /*
     * Recursive function to calculate Maximum Path Sum
     * i = current row
     * j = current column
     *
     * From each cell we can move:
     * 1. Up        (i-1, j)
     * 2. Left Diagonal  (i-1, j-1)
     * 3. Right Diagonal (i-1, j+1)
     */

    public static int f(int i, int j, int[][] matrix) {

        // 🔹 Boundary check for column
        // If column goes out of bounds, return very small value
        // so that this path is never chosen
        if (j < 0 || j >= matrix[0].length)
            return (int) -1e8;

        // 🔹 Base Case:
        // If we reach first row, return that value
        if (i == 0)
            return matrix[0][j];

        // Move Up
        int up = matrix[i][j] + f(i - 1, j, matrix);

        // Move Left Diagonal
        int leftDiagonal = matrix[i][j] + f(i - 1, j - 1, matrix);

        // Move Right Diagonal
        int rightDiagonal = matrix[i][j] + f(i - 1, j + 1, matrix);

        // Return maximum among three choices
        return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    /*
     * This function starts recursion from last row
     * and checks maximum path ending at any column
     */
    public static int getMaxPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int maxi = (int) -1e8;

        // We can start from any column in last row
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, f(n - 1, j, matrix));
        }

        return maxi;
    }

    // Main method for testing
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };

        int result = getMaxPathSum(matrix);

        System.out.println("Maximum Path Sum: " + result);
    }
}


/*
| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(m × 3^n)  | O(n)         |
| Memoization | O(n × m)    | O(n × m)     |
| Tabulation  | O(n × m)    | O(n × m)     |
*/
