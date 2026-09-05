
/*

https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
https://leetcode.com/problems/find-peak-element/description/

Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
Output: 5
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

Input: arr[] = [10, 20, 15, 2, 23, 90, 80]
Output: 1 or 5
Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6].


Input: arr[] = [1, 2, 3]
Output: 2
Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.
 */
// Java program to find a peak element in the given array
// Using Linear Search
import java.util.*;

public class O17_peak_element_in_array {

    // GFG || array || L.S.
    static int peakElement(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean left = true;
            boolean right = true;

            // Check for element to the left
            if (i > 0 && arr[i] <= arr[i - 1]) {
                left = false;
            }

            // Check for element to the right
            if (i < n - 1 && arr[i] <= arr[i + 1]) {
                right = false;
            }

            // If arr[i] is greater than its left as well as
            // its right element, return its index
            if (left && right) {
                return i;
            }
        }
        return 0;
    }

    // striver || ArrayList || L.S.
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of array.

        for (int i = 0; i < n; i++) {
            // Checking for the peak:
            if ((i == 0 || arr.get(i - 1) < arr.get(i))
                    && (i == n - 1 || arr.get(i) > arr.get(i + 1))) {
                return i;
            }
        }
        // Dummy return statement
        return -1;
    }

    // GFG || array || B.S.
    static int peakElement2(int[] arr) {
        int n = arr.length;

        // If there is only one element, then it's a peak
        if (n == 1) {
            return 0;
        }

        // Check if the first element is a peak
        if (arr[0] > arr[1]) {
            return 0;
        }

        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        // Search Space for binary Search
        int lo = 1, hi = n - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If the element at mid is a  
            // peak element return mid
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If next neighbor is greater, then peak
            // element will exist in the right subarray
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1; 
            }// Otherwise, it will exist in left subarray
            else {
                hi = mid - 1;
            }
        }
        return 0;
    }

    // striver || ArrayList || B.S.
    public static int findPeakElement3(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of array

        // Edge cases:
        if (n == 1) {
            return 0;
        }
        if (arr.get(0) > arr.get(1)) {
            return 0;
        }
        if (arr.get(n - 1) > arr.get(n - 2)) {
            return n - 1;
        }

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the peak:
            if (arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1)) {
                return mid;
            }

            // If we are in the left:
            if (arr.get(mid) > arr.get(mid - 1)) {
                low = mid + 1; 
            }// If we are in the right:
            // Or, arr[mid] is a common point:
            else {
                high = mid - 1;
            }
        }
        // Dummy return statement
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 2, 23, 90, 80};
        System.out.println(peakElement(arr));
    }
}
