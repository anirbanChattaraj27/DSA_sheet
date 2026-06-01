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
        // 1. Sort the array first
        Arrays.sort(arr);
        
        // 2. Initialize with the first possible pair sum and pair elements
        int closestSum = arr[0] + arr[1];
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(arr[0], arr[1]));

        int left = 0;
        int right = arr.length - 1;

        // 3. Loop through the array using two pointers
        while (left < right) {
            int currentSum = arr[left] + arr[right];

            // 4. Update closestSum and res if the current deviation is smaller
            // This is the exact same if block logic from your triplet sum code
            if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                closestSum = currentSum;
                res = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
            }

            // 5. Move pointers based on the sum comparison
            if (currentSum < target) {
                left++; // Need a larger sum
            } else if (currentSum > target) {
                right--; // Need a smaller sum
            } else {
                // Found exact match, return immediately
                return new ArrayList<>(Arrays.asList(arr[left], arr[right]));
            }
        }

        return res;
    }

}
