// https://leetcode.com/problems/house-robber-ii/description/
// same code as per prev with a slight change 
// copy: 6
import java.util.*;

public class O6_house_robber_2 {

    public static int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) take += prev2;

            int notTake = prev;

            int curri = Math.max(take, notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    public static long houseRobber(int arr[]) {
        int n = arr.length;

        if (n == 1) return arr[0];

        // Case 1: Exclude last house
        int[] temp1 = Arrays.copyOfRange(arr, 0, n - 1); // here i am sending array input from user 0 yo n-1

        // Case 2: Exclude first house
        int[] temp2 = Arrays.copyOfRange(arr, 1, n); // here i am sending array input from user 1 to n

        return Math.max(maximumNonAdjacentSum(temp1), 
                        maximumNonAdjacentSum(temp2));
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2};

        long result = houseRobber(arr);
        System.out.println("Maximum money that can be robbed: " + result);
    }
}
