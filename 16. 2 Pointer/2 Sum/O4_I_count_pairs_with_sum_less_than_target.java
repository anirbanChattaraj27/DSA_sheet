// Leetcode 2824
import java.util.*;

public class O4_I_count_pairs_with_sum_less_than_target {

    // 2 pointer
    public int countPairs(List<Integer> nums, int target) {
        
        Collections.sort(nums);
        
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {
                // 2. Add ALL valid pairs between left and right
                count += (right - left);
                // 3. Move left pointer up to look for larger numbers
                left++;
            } else {
                // 4. If sum is too big, make it smaller by moving right pointer down
                right--;
            }
        }        
        return count;
    }

    // using Hash
    public int countPairs2(List<Integer> arr, int target) {
        int n = arr.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int currentNum = arr.get(i);

            // Look through all unique numbers we have seen so far
            for (int existingNum : map.keySet()) {
                // Check if their combined sum is strictly less than target
                if (currentNum + existingNum < target) {
                    // Add the frequency of that number to our count
                    count += map.get(existingNum);
                }
            }

            // Record the current number in the map AFTER checking pairs
            map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
        }
        
        return count;
    }
}