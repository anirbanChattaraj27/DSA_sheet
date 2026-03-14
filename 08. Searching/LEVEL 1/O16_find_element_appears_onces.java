/* *************Single Element in sorted array*************

 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/

 * Given a sorted array in which all elements appear twice and one element 
 * appears only once, the task is to find the element that appears once.

Input: arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
Output: 4
Explanation: All numbers except 4 occur twice in the array.

Input: arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output: 8
Explanation: All numbers except 8 occur twice in the array.

 */

import java.util.ArrayList;

public class O16_find_element_appears_onces {

    // GFG || Array
    static int singleNonDuplicate1(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // Ensure mid is even
            if (mid % 2 == 1) {
                mid--;
            }

            // If repeating element is at even position, 
            // then single element must be on the right side
            if (arr[mid] == arr[mid + 1]) {
                lo = mid + 2;
            } 
            
            // Else single element must be on the left  
            else {
                hi = mid;
            }
        }
        return arr[lo];
    }

    // Striver  || ArrayList
    public static int singleNonDuplicate2(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of the array.

        // Edge cases:
        if (n == 1) {
            return arr.get(0);
        }
        if (!arr.get(0).equals(arr.get(1))) {
            return arr.get(0);
        }
        if (!arr.get(n - 1).equals(arr.get(n - 2))) {
            return arr.get(n - 1);
        }

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (!arr.get(mid).equals(arr.get(mid + 1)) && !arr.get(mid).equals(arr.get(mid - 1))) {
                return arr.get(mid);
            }

            // We are in the left:
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))
                    || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {

                low = mid + 1; // Eliminate the left half:
            } 
            
            // We are in the right:
            else {
                high = mid - 1; // Eliminate the right half:
            }
        }
        return -1; // Dummy return statement:
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8};
        System.out.println(singleNonDuplicate1(arr));
    }
}
