/*
https://www.geeksforgeeks.org/implement-upper-bound/

Input: arr[] = {2, 3, 7, 10, 11, 11, 25}, target = 11
Output: 6
Explanation: 6 is the smallest index in arr[], at which element (arr[6] = 25) is larger than 11.

Input: arr[] = {2, 3, 7, 10, 11, 11, 25}, target = 100
Output: 7
Explanation: As no element in arr[] is greater than 100, return the length of array.

 * The upper bound of a number is defined as the smallest index in the sorted array where the 
 * element is greater than the given number.

 * Note: If all the elements in the given array are smaller than or equal to the target, the 
 * upper bound will be the length of the array.
 */

import java.util.*;

public class O12_Implement_Upper_Bound {

    // LS || O(n) Time and O(1) Space
    static int upperBound1(int[] arr, int target) {
        int n = arr.length;

        // Compare target with each element in array
        for (int i = 0; i < n; ++i) {

            // If larger value found, return its index
            if (arr[i] > target) {
                return i;
            }
        }

        // If all elements are smaller, return length
        return n;
    }

    // BS || O(log n) Time and O(1) Space
    static int upperBound2(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If arr[mid] > target, then arr[mid] can be the upper bound so store mid in result and search in left half, i.e. arr[lo...mid-1]
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1; // looking for more small index on left
            }

            // If arr[mid] <= target, then upper bound  cannot lie in the range [lo...mid], so  search in right half, i.e. arr[mid+1...hi]
            else {
                lo = mid + 1; // looking for right
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;

        System.out.println(upperBound2(arr, target));
    }
}
