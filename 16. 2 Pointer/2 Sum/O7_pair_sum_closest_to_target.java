// https://www.geeksforgeeks.org/dsa/2-sum-pair-sum-closest-to-target/
/*
Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: Out of all the pairs, [5, 20] has sum = 25 which is closest to 25.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class O7_pair_sum_closest_to_target {
    static ArrayList<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];
            int currDiff = Math.abs(target - currSum);

            // check if this pair is closer than the closest
            // pair so far
            if (currDiff < minDiff) {
                minDiff = currDiff;
                res = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
            }

            // if this pair has sum = target, return it immediately
            if (currSum == target)
                return new ArrayList<>(Arrays.asList(arr[left], arr[right]));

            // if this pair has less sum, move to greater values
            else if (currSum < target)
                left++;

            // if this pair has more sum, move to smaller values
            else
                right--;
        }

        return res;
    }

}
