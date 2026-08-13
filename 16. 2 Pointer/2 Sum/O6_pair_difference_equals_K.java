// Leetcode 532
// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
/*
Example 1:
    Input: nums = [3,1,4,1,5], k = 2
    Output: 2
    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:
    Input: nums = [1,2,3,4,5], k = 1
    Output: 4
    Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
    Input: nums = [1,3,1,5,4], k = 0
    Output: 1
    Explanation: There is one 0-diff pair in the array, (1, 1).
*/

import java.util.*;

public class O6_pair_difference_equals_K {

    // MAP
    static int usingMapCorrected(int arr[], int n, int k) {
        // Edge case: absolute difference cannot be negative
        if (k < 0) {
            return 0;
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;

        // Step 1: Fully populate the frequency map first
        for (int i = 0; i < n; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Iterate through the UNIQUE keys to count unique pairs
        for (int num : m.keySet()) {
            if (k > 0) {
                // Check only one direction (num + k) to avoid double counting
                if (m.containsKey(num + k)) {
                    count++;
                }
            } else {
                // If k == 0, we need the exact same number to appear at least twice
                if (m.get(num) > 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // 2 pointer
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        int count = 0;

        // Step 2: Two-pointer traversal
        while (left < nums.length && right < nums.length) {
            // Pointers cannot be at the same index
            if (left == right) {
                right++;
                continue;
            }

            int diff = nums[right] - nums[left];

            if (diff == k) {
                count++;
                left++;
                right++;

                // Skip duplicate elements for 'left' to ensure unique pairs
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
                // Sync 'right' if 'left' catches up to it
                if (right <= left) {
                    right = left + 1;
                }
            } else if (diff < k) {
                right++; // Make the difference larger
            } else {
                left++;  // Make the difference smaller
            }
        }

        return count;
    }
}
