
// TABULATION = space optimization
// TC: O(N)
// SC: O(1)

import java.util.*;

public class O5_3_Max_sum_of_NonAdjacent_element_Tabulation {

    public static int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i=0; i<nums.length; i++){

            int take = nums[i];
            if (i > 1) take += prev2;

            int notTake = 0 + prev;

            int curri = Math.max(take, notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 9};
        System.out.println(maximumNonAdjacentSum(nums)); // Output: 11
    }
}

