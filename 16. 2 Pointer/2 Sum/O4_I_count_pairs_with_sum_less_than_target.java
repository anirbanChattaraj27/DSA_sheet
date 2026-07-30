// Leetcode 2824

/* when COUNT is there, there are 2 types of question
    1. count pair with given sum || with 0 sum
    2. count pair with <= target AND < target || > target AND >= target
        a) count pairs < target
        b) count pairs <= target
        c) count pairs > target
        d) count pairs >= target
*/
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

1. Count pairs with sum < target 
    if (sum < target) {
        count += (right - left);
        left++;
    } 
    else {
        right--;
    }
    
    REASON:
        if:
            arr[left] + arr[right] < target
        then:
            arr[left] + arr[left+1]
            arr[left] + arr[left+2]
            ...
            arr[left] + arr[right]


2. Count pairs with sum <= target
    SAME as per 1

    
3. Count pairs with sum > target

    if (sum > target) {
        count += (right - left);
        right--;
    } 
    else {
        left++;
    }

    we count, We move right, not left.


4. Count pairs with sum >= target
   SAME as 3


SUMMARY
Problem	    Condition	    Count	    Move after counting
Sum < K	    sum < K	    right - left	left++
Sum <= K	sum <= K	right - left	left++
Sum > K	    sum > K	    right - left	right--
Sum >= K	sum >= K	right - left	right--


*/