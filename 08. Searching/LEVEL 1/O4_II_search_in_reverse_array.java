// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
// https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-rotated-array-with-duplicates/

// array may may duplicate values
// search in a Rotated sorted array II

public class O4_II_search_in_reverse_array {

    public static boolean searchInARotatedSortedArrayII(int[] arr, int x) {
        int n = arr.length; // size of the array.
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // if mid points the target
            if (arr[mid] == x) {
                return true;
            }

            // Edge case:
            if (arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                lo = lo + 1;
                hi = hi - 1;
                continue;
            } 

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
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 8;
        boolean ans = searchInARotatedSortedArrayII(arr, k);
        if (ans == false) {
            System.out.println("Target is not present."); 
        }else {
            System.out.println("Target is present in the array.");
        }
    }
}
