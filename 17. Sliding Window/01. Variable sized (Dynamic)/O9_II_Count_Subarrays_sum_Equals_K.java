/*
 Binary Subarrays With Sum
 Count of Subarrays with sum equals k in given Binary Array

 * https://www.geeksforgeeks.org/count-of-subarrays-with-sum-equals-k-in-given-binary-array/
 * LC 930 --> https://leetcode.com/problems/binary-subarrays-with-sum/description/
 * 
 * Input: arr[] = {1, 0, 1, 1, 0, 1}, k = 2
Output: 6
Explanation: All valid subarrays are: {1, 0, 1}, {0, 1, 1}, {1, 1}, {1, 0, 1}, {0, 1, 1, 0}, {1, 1, 0}.


Input: arr[] = {0, 0, 0, 0, 0}, k = 0
Output: 15 
Explanation: All subarrays have a sum equal to 0, and there are a total of 15 subarrays.
 */

public class O9_II_Count_Subarrays_sum_Equals_K {

    // O(N^2)
     static int numberOfSubarrays1(int[] arr, int k) {

        int ans = 0, n = arr.length;
        
        // Check for each subarray 
        for (int i = 0; i < n; i++) {
            
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                
                if (sum == k) ans++;
            }
        }
        
        return ans;
    }

    // O(n)
    public static int atMost(int[] nums, int k) {

        // Edge case
        if (k < 0)
            return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // 1. Add right element
            sum += nums[right];

            // 2. Shrink until window becomes valid
            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // 3. Count all valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1};
        int k = 2;

        System.out.println(numberOfSubarrays1(arr, k));
        System.out.println(numSubarraysWithSum(arr, k));
    }
}
