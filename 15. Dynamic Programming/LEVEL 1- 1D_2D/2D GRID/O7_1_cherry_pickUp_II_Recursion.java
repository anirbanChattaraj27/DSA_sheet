public class O7_1_cherry_pickUp_II_Recursion {

    /*
     * PROBLEM:
     * Two robots (Alice and Bob) start from:
     * Alice → (0, 0)
     * Bob   → (0, c-1)
     *
     * They move down row by row.
     * From (i, j) they can move to:
     *    (i+1, j-1)
     *    (i+1, j)
     *    (i+1, j+1)
     *
     * If both land on same cell → count chocolate once.
     * Goal → Max chocolates collected.
     */

    // Recursive function
    public static int f(int i, int j1, int j2,
                        int r, int c, int[][] grid) {

        // ❌ Out of boundary check
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return (int) -1e8;  // Invalid path
        }

        // ✅ Base Case: Last row reached
        if (i == r - 1) {

            // If both robots on same cell
            if (j1 == j2)
                return grid[i][j1];

            // If on different cells
            else
                return grid[i][j1] + grid[i][j2];
        }

        // Explore all 9 possible combinations of moves
        int maxi = (int) -1e8;

        for (int dj1 = -1; dj1 <= +1; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {

                int value = 0;

                // If both robots on same cell
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                // Recursive call for next row
                value += f(i + 1,
                           j1 + dj1,
                           j2 + dj2,
                           r, c, grid);

                // Take maximum
                maxi = Math.max(maxi, value);
            }
        }

        return maxi;
    }

    // Main function to call recursion
    public static int maximumChocolates(int r, int c, int[][] grid) {

        // Start from row 0,
        // Alice at column 0,
        // Bob at column c-1
        return f(0, 0, c - 1, r, c, grid);
    }

    // Driver code
    public static void main(String[] args) {

        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int r = grid.length;
        int c = grid[0].length;

        System.out.println("Maximum Chocolates: "
                + maximumChocolates(r, c, grid));
    }
}



/*
| Version     | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Recursion   | O(9^r)          | O(r)             |
| Memoization | O(r × c²)       | O(r × c²)        |
*/