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

/*

DR RUN

Initial Setup
• Sorted Array: [1, 2, 3, 4, 5] (indices 0 to 4) target 8
• Pointers: left = 0 (value 1), right = 4 (value 5)
• Count: 0

Step-by-Step Execution

Iteration 1
• sum = nums.get(0) + nums.get(4) \(\rightarrow \) 1 + 5 = 6
• Check: Is 6 < 8? Yes!
• Action:
• count += (4 - 0) \(\rightarrow \) count becomes 4.
• (Why 4? Because if 1 + 5 < 8, then 1 paired with any number smaller than 5 is also valid: (1,5), (1,4), (1,3), and (1,2)).
• left++ (left moves to index 1, value 2)

Iteration 2
same

Iteration 3
• sum = nums.get(2) + nums.get(4) \(\rightarrow \) 3 + 5 = 8
• Check: Is 8 < 8? No (it must be strictly less than 8).
• Action:
• right-- (right moves to index 3, value 4)

Iteration 4
• sum = nums.get(2) + nums.get(3) \(\rightarrow \) 3 + 4 = 7
• Check: Is 7 < 8? Yes!
• Action:
• count += (3 - 2) \(\rightarrow \) count += 1 \(\rightarrow \) count becomes 8.
• (This 1 new pair is: (3,4)).
• left++ (left moves to index 3, value 4)

Loop Termination
• left = 3, right = 3.
• The condition while (left < right) (3 < 3) is now false. The loop stops.

*/