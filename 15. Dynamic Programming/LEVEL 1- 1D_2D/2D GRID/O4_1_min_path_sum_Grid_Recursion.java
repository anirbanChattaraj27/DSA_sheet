public class O4_1_min_path_sum_Grid_Recursion {

    /*
     * Recursive function to find minimum path sum
     * from (0,0) to (i,j)
     */
    public static int f(int i, int j, int[][] grid) {

        // Base Case: Reached starting cell
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        // If out of bounds, return a very large value
        // so that this path is never chosen
        if (i < 0 || j < 0) {
            return (int) 1e9;  // Large value (acts like infinity)
        }

        // Move UP
        int up = grid[i][j] + f(i - 1, j, grid);

        // Move LEFT
        int left = grid[i][j] + f(i, j - 1, grid);

        // Return minimum of both paths
        return Math.min(up, left);
    }

    /*
     * Function to start recursion from bottom-right cell
     */
    public static int minSumPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        return f(n - 1, m - 1, grid);
    }

    // Main function to test
    public static void main(String[] args) {

        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int result = minSumPath(grid);

        System.out.println("Minimum Path Sum: " + result);
    }
}
