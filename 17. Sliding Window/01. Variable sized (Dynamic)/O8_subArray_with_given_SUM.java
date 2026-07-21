/*
https://www.geeksforgeeks.org/dsa/find-subarray-with-given-sum/
https://www.geeksforgeeks.org/dsa/find-subarray-with-given-sum-in-array-of-integers/

// mainly prefix sum qs

    N = 5, S = 12
    A[] = {1,2,3,7,5}
    Output: 2 4
    Explanation: The sum of elements from 2nd position to 4th position is 12.

    I/P: arr[] = [1, 4], target = 0
    O/P: [-1]
    Explanation: There is no subarray with 0 sum.

    // NON-NEGATIVE numbers ----> Sliding window
    // Negative numbers ----> prefix-sum + hashmap approach
 */

import java.util.*;

public class O8_subArray_with_given_SUM {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;

        // Pick a starting point for a subarray
        for (int s = 0; s < n; s++) {
            int curr = 0;

            // Consider all ending points
            // for the picked starting point
            for (int e = s; e < n; e++) {
                curr += arr[e];
                if (curr == target) {
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }
            }
        }
        // If no subarray is found
        res.add(-1);
        return res;
    }

    // O(n) Time and O(1) Space
    // Sliding window / caterpillar
    static ArrayList<Integer> subarraySum2(int[] arr, int target) {

        int s = 0;
        int curr = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int e = 0; e < arr.length; e++) {
            curr += arr[e];

            // If current sum becomes more than target, move start forward
            while (curr > target && s <= e) {
                curr -= arr[s];
                s++;
            }

            // If we found a subarray
            if (curr == target) {
                res.add(s + 1);
                res.add(e + 1);
                return res;
            }
        }

        // If no subarray is found
        res.add(-1);
        return res;
    }

    // Prefix-sum + hashmap approach works for negative numbers too
    static ArrayList<Integer> subarraySumWithNegatives(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix sum 0 before the array starts

        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - target)) {
                res.add(map.get(prefixSum - target) + 1);
                res.add(i + 1);
                return res;
            }

            map.putIfAbsent(prefixSum, i);
        }

        res.add(-1);
        return res;
    }
    

    public static void main(String[] args) {
        int[] arr = {2, 12, -2, -20, 10};
        int target = -10;

        System.out.println("With negative numbers:");
        System.out.println(subarraySumWithNegatives(arr, target));

        int[] arr2 = {1, 2, 3, 7, 5};
        int target2 = 12;
        System.out.println("Without negatives:");
        System.out.println(subarraySum2(arr2, target2));
    }
}
