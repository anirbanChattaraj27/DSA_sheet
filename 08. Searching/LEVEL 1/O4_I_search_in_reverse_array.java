// search in roatated sorted array

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is present at index 8 in arr[].

Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: 6 is not present in arr[].

Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.

 */

import java.util.ArrayList;

public class O4_I_search_in_reverse_array {

    // GFG  ||  array
    static int search1(int[] arr, int x) {
      
        // Initialize two pointers, lo and hi, at the start and end of the array
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If key found, return the index
            if (x  == arr[mid])
                return mid;

            // If Left half is sorted
            if (arr[mid] > arr[lo]) {
              
                // If the key lies within this sorted half, move the hi pointer to mid - 1
                if (x < arr[mid] && x >= arr[lo])
                    hi = mid - 1;
              
                // Otherwise, move the lo pointer to mid + 1
                else
                    lo = mid + 1;
            }
          
            // If Right half is sorted
            else {
              
                // If the key lies within this sorted half, move the lo pointer to mid + 1
                if (x > arr[mid] && x <= arr[hi])
                    lo = mid + 1;
              
                // Otherwise, move the hi pointer to mid - 1
                else
                    hi = mid - 1;
            }
        }
      
        // Key not found
        return -1; 
    }

    // striver  ||  arraylist
    public static int search2(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;

        while (low <= high) {
            
            int mid = (low + high) / 2;

            // if mid points to the target
            if (arr.get(mid) == k)
                return mid;

            // if left part is sorted
            if (arr.get(low) <= arr.get(mid)) {

                if (arr.get(low) <= k && k <= arr.get(mid)) {  // element exists
                    high = mid - 1;
                }
                 else { // element does not exist
                    low = mid + 1;
                }
            } 

            // if right part is sorted
            else { 

                if (arr.get(mid) <= k && k <= arr.get(high)) { // element exists
                    low = mid + 1;
                } 
                else { // element does not exist                    
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int x = 3;

        System.out.print(search1(array, x));
    }

}