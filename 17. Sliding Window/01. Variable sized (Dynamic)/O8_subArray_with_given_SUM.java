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

    // NON-NEGETIVE numbers ----> Sliding window
    // Negetive numbers----> prefix sum approch
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
    //  SLiding window / caterpillar
    static ArrayList<Integer> subarraySum2(int[] arr, int target) {

        // Initialize window
        int s = 0, e = 0;
        ArrayList<Integer> res = new ArrayList<>();

        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            // If current sum becomes more or equal,
            // set end and try adjusting start
            if (curr >= target) {
                e = i;

                // While current sum is greater, 
                // remove starting elements of current window
                while (curr > target && s < e) {
                    curr -= arr[s];
                    ++s;
                }

                // If we found a subarray
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

    // Prefix sum
    public static void subArraySum(int[] arr, int n, int sum) {
        // cur_sum to keep track of cumulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            // check whether cur_sum - sum = 0, if 0 it means the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            // if hashMap already has the value, means we already have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            // if value is not present then add to hashmap
            hashMap.put(cur_sum, i);
        }
        // if end is -1 : means we have reached end withou the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes " + start + " to " + end);
        }
    }

}

