/*
    Input Format: N = 4, array[] = {3, 1, 2, 4}, k = 6
    Result: 2
    Explanation: The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].
 */

// LEETCODE: 560
// https://leetcode.com/problems/subarray-sum-equals-k/
// thos leetcode problem contains negetive numbers so, use prefix sum
// similar to shortest / longest size subarray PREFIX SUM 

 import java.util.*;
      

public class O8_II_Count_Subarrays_sum_Equals_K {

    // O(n^3)
    public static int findAllSubarraysWithGivenSum1(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            for (int j = i; j < n; j++) { // ending index j

                // calculate the sum of subarray [i...j]
                int sum = 0;
                for (int K = i; K <= j; K++)
                    sum += arr[K];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    // same approch like slogest shortest size subarray, here i have to return count of subarrays
    // if contains negetive numbers then use prefix sum + hashmap not sliding window
    public int subarraySum(int[] arr, int target) {
        int s = 0;
        int sum = 0;
        int count = 0;
        
        for (int e = 0; e < arr.length; e++) {
            sum += arr[e];

            while (sum > target && s <= e) {
                sum -= arr[s];
                s++;
            }

            // only change in this line, here i have to return count of subarrays
            if (sum == target) {
                count++;
            }
        }
        return count;
    }
 
    // preffered approch bcz i/p contains negetives
    // O(n)
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        Map<Integer,Integer> mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(preSum - k, 0);

            // Update the count of prefix sum in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}
