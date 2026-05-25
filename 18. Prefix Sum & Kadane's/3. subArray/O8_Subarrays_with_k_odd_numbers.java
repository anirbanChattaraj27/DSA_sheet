/*

Count Number of Nice Subarrays
Subarrays with k odd numbers

https://www.geeksforgeeks.org/number-subarrays-m-odd-numbers/
https://leetcode.com/problems/count-number-of-nice-subarrays/description/

Input : arr = [2, 5, 6, 9],  k = 2 
Output: 2
Explanation: There are 2 subarrays with 2 odds: [2, 5, 6, 9] and [5, 6, 9].

Input : arr = [2, 2, 5, 6, 9, 2, 11],  k = 2
Output: 8
Explanation: There are 8 subarrays with 2 odds: [2, 2, 5, 6, 9], [2, 5, 6, 9], [5, 6, 9], [2, 2, 5, 6, 9, 2], [2, 5, 6, 9, 2], [5, 6, 9, 2], [6, 9, 2, 11] and [9, 2, 11] .

 */

import java.util.HashMap;

public class O8_Subarrays_with_k_odd_numbers {

    /*
     * The idea is to generate all possible subarrays, and find the count of subarrays with 
     * number of odd elements equal to k. 
     */
    static int countSubarrays(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        // traverse for all possible subarrays
        for (int i = 0; i < n; i++) {

            int odd = 0;
            for (int j = i; j < n; j++) {

                // if current element is odd
                if (arr[j] % 2 != 0) {
                    odd++;
                }

                // if count of odd numbers in subarray is k
                if (odd == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // leetcode solution || sliding window || 2 pointer
    public static int countSubarrays1(int[] nums, int k) {
        // Count subarrays with exactly k odd numbers by subtracting:
        // subarrays with at most (k-1) odd numbers from subarrays with at most k odd numbers.
        return helper(nums, k) - helper(nums, k - 1);
    }

    // Helper function to count subarrays with at most k odd numbers
    public static int helper(int[] nums, int k) {
        int count = 0, sum = 0;
        int l = 0, r = 0;
        int len = nums.length;
        
        while (r < len) {
            // Convert odd/even to binary: odd (nums[r] % 2) gives 1, even gives 0.
            sum += (nums[r] % 2);
            
            // If there are more than k odd numbers in the current window, shrink the window from the left until it's valid.
            while (sum > k && r >= l) {
                sum -= (nums[l] % 2);
                l++;
            }
            
            // All subarrays ending at index r with a valid window contribute to the answer.
            count += (r - l + 1);
            r++;
        }
        
        return count;
    }

    /*
     * The idea is to HashMap to store the count of prefix subarrays with particular number of 
     * odd numbers, and then calculate the subarrays with count of odd numbers equal to k using 
     * this HashMap. To do so, create HashMap prefix[], where prefix[i] stores the count of prefix 
     * subarrays with number of odd elements equal to i. When the count of odd numbers exceeds or 
     * is equal to k, add the number of prefixes which has “(odd – k)” numbers to the answer.
     * O(N)
     */
    static int countSubarrays2(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        // to store count of prefix subarrays with particular count of odd numbers
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        // to store count of odd numbers
        int odd = 0;

        for (int i = 0; i < n; i++) {

            // if current element is odd
            if (arr[i] % 2 != 0) {
                odd++;
            }

            // if count of odd numbers in subarray is k
            if (prefix.containsKey(odd - k)) {
                count += prefix.get(odd - k);
            }

            prefix.put(odd, prefix.getOrDefault(odd, 0) + 1);
        }
        return count;
    }
    
    /*
     * The idea is to replace all the odd numbers with 1 and all the even numbers with zero and 
     * then calculate the number of subarrays with sum equal to m. Similar to above approach, 
     * use HashMap to store the sum at particular index, and proceed similarly.
     * O(N)
     */
    static int countSubarrays3(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        // to store count of prefix subarrays with particular sum of elements
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        // convert all odd numbers to 1 and even numbers to 0
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] % 2;

        // to store sum of subarray
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            // if sum - k is present in prefix then add prefix[sum - k] to count
            if (prefix.containsKey(sum - k))
                count += prefix.get(sum - k);

            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {2, 2, 5, 6, 9, 2, 11};
        int k = 2;
        System.out.println(countSubarrays1(arr, k));
    }
}
