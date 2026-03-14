/*
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 * https://www.geeksforgeeks.org/count-of-subarrays-having-exactly-k-distinct-elements/
 * 
 * Given an array arr[] and an integer k, the task is to find the count of 
 * subarrays such that each subarray has exactly k distinct elements.
 * 
 * Input: arr[] = [1, 2, 2, 3], k = 2 
Output: 4 
Explanation: Subarrays with exactly 2 distinct elements are: [1, 2], [1, 2, 2] and [2, 3].


Input: arr[] = [3, 1, 2, 2, 3], k = 3 
Output: 4
Explanation: Subarrays with exactly 3 distinct elements are: [3, 1, 2], [3, 1, 2, 2], [3, 1, 2, 2, 3] and [1, 2, 2, 3].


Input: arr[] = [1, 1, 1, 1], k = 2
Output: 0
Explanation: There is no subarray having exactly 2 distinct integers.
 */

// Java Code to count the subarrays having exactly k distinct elements by exploring all subarrays

import java.util.*;

public class O9_Subarrays_with_K_Different_Integers {

    // O9(N^2)
    static int exactlyK(int[] arr, int k) {
        int n = arr.length;
        int res = 0;

        // Iterate over all subarrays arr[i...j]
        for (int i = 0; i < n; i++) {

            // Hash set to count distinct elements
            HashSet<Integer> st = new HashSet<>();

            for (int j = i; j < n; j++) {
                st.add(arr[j]);

                // If count of distinct elements > k, then don't extend the subarray further
                if (st.size() > k)
                    break;
                if (st.size() == k)
                    res += 1;
            }
        }
        return res;
    }

    // O(N) || leetcode sol. || 2 pointer  || sliding window
    public int subarraysWithKDistinct(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }
    
    public int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            ans += right - left + 1; // Size of subarray
            right++;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int k = 2;
        System.out.println(exactlyK(arr, k));
    }
}
