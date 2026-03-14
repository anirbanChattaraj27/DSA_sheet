/*
https://www.geeksforgeeks.org/implement-lower-bound/

 * Given a sorted array arr[] and a number target, the task is to find the lower bound of the 
 * target in this given array. The lower bound of a number is defined as the smallest index in 
 * the sorted array where the element is greater than or equal to the given number.
 * Note: If all the elements in the given array are smaller than the target, the lower bound 
        will be the length of the array.

Input: arr[] = {2, 3, 7, 10, 11, 11, 25}, target = 9
Output: 3
Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than 
or equal to 9.

Input: arr[] = {2, 3, 7, 10, 11, 11, 25}, target = 11
Output: 4
Explanation: 4 is the smallest index in arr[] where element (arr[4] = 11) is greater than or 
equal to 11.

Input: arr[] = {2, 3, 7, 10, 11, 11, 25}, target = 100
Output: 6
Explanation: As no element in arr[] is greater than 100, return the length of array.

*/

public class O11_Implement_Lower_Bound {

    // Linear search || O(n) Time and O(1) Space
    static int lowerBound1(int[] arr, int target) {

        int n = arr.length;

        for (int i = 0; i < n; ++i) {

            if(arr[i] >= target) {
                return i;
            }
        }
        return n;
    }

    // Binary search  ||  O(log n) Time and O(1) Space
    public static int lowerBound2(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length;
      
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            // If arr[mid] >= target, then mid can be the lower bound, so update res to mid and search in left half, i.e. [lo...mid-1]
            if (arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            }
            
            // If arr[mid] < target, then lower bound cannot lie in the range [lo...mid] so search in right half, i.e. [mid+1...hi]
            else {
                lo = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 16, 25};
        int target = 15;
  
        System.out.println(lowerBound1(arr, target));
        System.out.println(lowerBound2(arr, target));
    }
}
