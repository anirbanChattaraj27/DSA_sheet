/*
 Binary Subarrays With Sum
 Count of Subarrays with sum equals k in given Binary Array

 * https://www.geeksforgeeks.org/count-of-subarrays-with-sum-equals-k-in-given-binary-array/
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 * 
 * Input: arr[] = {1, 0, 1, 1, 0, 1}, k = 2
Output: 6
Explanation: All valid subarrays are: {1, 0, 1}, {0, 1, 1}, {1, 1}, {1, 0, 1}, {0, 1, 1, 0}, {1, 1, 0}.


Input: arr[] = {0, 0, 0, 0, 0}, k = 0
Output: 15
Explanation: All subarrays have a sum equal to 0, and there are a total of 15 subarrays.
 */

import java.util.*;

public class O7_II_Count_Subarrays_sum_Equals_K {

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
    static int atmost(int[] arr, int k) {
        if (k < 0)
            return 0;

        int n = arr.length;
        int res = 0, sum = 0, j = 0;

        for (int i = 0; i < n; i++) {

            while (j < n && sum + arr[j] <= k) {
                sum += arr[j];
                j++;
            }

            // Number of sub-arrays starting from index i that have sum atmost k will  be (j-i).
            res += (j - i);

            // Remove the i'th index from window.
            sum -= arr[i];
        }

        return res;
    }

    static int numberOfSubarrays2(int[] arr, int k) {

        // Call atmost(arr, k) and atmost
        // (arr, k-1) to get the count of
        // subarrays with sum at most k
        // and sum at most k-1 respectively,
        // then subtract them to get the count
        // of subarrays with sum exactly
        // equal to k
        return atmost(arr, k) - atmost(arr, k - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1};
        int k = 2;

        System.out.println(numberOfSubarrays1(arr, k));
        System.out.println(numberOfSubarrays2(arr, k));
    }
}
