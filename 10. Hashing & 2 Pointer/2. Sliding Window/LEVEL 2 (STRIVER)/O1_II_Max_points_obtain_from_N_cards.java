/*
 * arr = [6 2 3 4 7 2 1 7 1], K = 4
 * o/p: 16
 * explain: I have to pick K cards which give max sum  
 *          In this case, picking 6, 2 from the front and 7, 1 from the back gives the maximum sum of 16.

 * N.B.: I have to pick K cards either from front OR from last or from both ends BUT I can not pick from middle elements
 * here in this example i can pick 1st 4 elements from front or last 4 elements or 2 elements from front and 2 elemnts from last OR 3 elements from front or 1 element from the end
 */

public class O1_II_Max_points_obtain_from_N_cards {
    public static int maxScore(int[] nums, int k) {
        int lsum = 0, rsum = 0, maxSum = 0;

        // Step 1: Take first k elements from the left
        for (int i = 0; i < k; i++) {
            lsum += nums[i];
        }
        maxSum = lsum;

        // Step 2: Try replacing elements from the left with right side elements
        int rIndex = nums.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum -= nums[i];           // Remove from left
            rsum += nums[rIndex];      // Add from right
            rIndex--;

            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        System.out.println("Max score: " + maxScore(arr, k));  // Output: 16
    }
}
