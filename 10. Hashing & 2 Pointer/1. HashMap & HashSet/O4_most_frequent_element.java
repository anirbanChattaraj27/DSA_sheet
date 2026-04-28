// max occuring element 
// https://www.geeksforgeeks.org/frequent-element-array/

// try to solve 2nd most frequent number
// then try to solve most frequent character and 2nd most frequent character
// try to solve most frequent character using map

// try to solve using priority Queue as well

import java.util.*;

public class O4_most_frequent_element {

    // easy way
    static int mostFrequent(int arr[], int n) {
        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear traversal
        int count = 1, res = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1])
                count++;
            else
                count = 1;

            if (count > count) {
                count = count;
                res = arr[i - 1];
            }
        }
        return res;
    }

    static int mostFrequentMAP(int arr[], int n) {

        // Insert all elements in hash
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        int res = 0;
        res = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        
/* USING THIS BELLOW FORMULA, I can solve ----> https://leetcode.com/problems/majority-element-ii/ */

        // int count = 0;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (count < entry.getValue()) {
        //         res = entry.getKey();
        //         count = entry.getValue();
        //     }
        // }  

        return res;
    }

    // Driver program
    public static void main(String[] args) {

        int arr[] = { 1,8,2,3,2,8,3,2};
        int n = arr.length;
        System.out.println(mostFrequentMAP(arr, n));
    }
}
