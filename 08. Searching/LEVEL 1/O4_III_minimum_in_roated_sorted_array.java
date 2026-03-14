/*  Given a sorted array of distinct elements arr[] of size n that is rotated at some 
    unknown point, the task is to find the minimum element in it. 

    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element present in the array.

Input: arr[] = [4, 2, 3]
Output: 2
Explanation: 2 is the only minimum element in the array.
 */

import java.util.*;

public class O4_III_minimum_in_roated_sorted_array {

    // LS - O(n)
    static int findMin1(int[] arr) {
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, arr[i]);
        }

        return res;
    }

    // BS - O(log n)
    public static int findMin2(int[] arr) {

        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]); // keep the minimum:                
                low = mid + 1; // Eliminate left half:
            } //if right part is sorted
            else {
                ans = Math.min(ans, arr[mid]); // keep the minimum:
                high = mid - 1; // Eliminate right half:
            }
        }
        return ans;
    }

    public static int findMin3(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted then arr[low] will always be the minimum in that search space:
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]); // keep the minimum:
                low = mid + 1; // Eliminate left half:

            } 

            //if right part is sorted:
            else {
                ans = Math.min(ans, arr[mid]); // keep the minimum:
                high = mid - 1; // Eliminate right half:
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin1(arr));
    }
}
