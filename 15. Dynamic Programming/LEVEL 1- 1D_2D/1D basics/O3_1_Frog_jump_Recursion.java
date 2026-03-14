

public class O3_1_Frog_jump_Recursion {

    public static int f(int ind, int[] heights) {

        // ✅ Base Case:
        // If frog is at index 0, no energy required
        if (ind == 0)
            return 0;

        // 🔹 Jump from (ind - 1)
        int left = f(ind - 1, heights)
                + Math.abs(heights[ind] - heights[ind - 1]);

        // 🔹 Jump from (ind - 2)
        int right = Integer.MAX_VALUE;

        if (ind > 1) {
            right = f(ind - 2, heights)
                    + Math.abs(heights[ind] - heights[ind - 2]);
        }

        // Return minimum energy
        return Math.min(left, right);
    }


    // Function called from main
    public static int frogJump(int n, int[] heights) {
        return f(n - 1, heights);
    }


    // 🔹 Main Method
    public static void main(String[] args) {

        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;

        int result = frogJump(n, heights);

        System.out.println("Minimum Energy Required: " + result);
    }
}