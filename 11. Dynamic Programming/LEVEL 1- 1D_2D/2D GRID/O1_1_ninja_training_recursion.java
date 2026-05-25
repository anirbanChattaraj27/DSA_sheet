// copy: 7
// advanced version of 1D DP, house robber, max sum adjacent
// simple recursion, NO DP

public class O1_1_ninja_training_recursion {

    // Recursive function
    public static int f(int day, int last, int[][] points) {

        // Base case
        if (day == 0) {
            int maxi = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        int maxi = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }

        return maxi;
    }

    public static int ninjaTraining(int n, int[][] points) {
        return f(n - 1, 3, points);
    }

    // Main function
    public static void main(String[] args) {

        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;

        int result = ninjaTraining(n, points);

        System.out.println("Maximum Points: " + result);
    }
}
