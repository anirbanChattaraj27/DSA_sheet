/* https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/

 * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: 2 occurs 4 times in the given array.


Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: 4 is not present in the given array.
 */

public class O15_occurance_of_element_in_array {
    static int countFreq1(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
          
            // If the current element is equal to target, increment the result
            if (arr[i] == target)
                res++;
        }
      
        return res;
    }
    
    /* ALGORITHM: First, we find the index of the first occurrence (Lower Bound)  of target and then the index of the first element greater than the target (Upper Bound). The difference between these two indices will */

    // BS  ||  O(logn) Time and O(1) Space
    static int lowerBound(int[] arr, int target) {
        int res = arr.length;
        
        // Search space for binary search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                res = mid;
                hi = mid - 1;
            } 
          	else {
                lo = mid + 1;
            }
        }
        return res;
    }

    static int upperBound(int[] arr, int target) {
        int res = arr.length;
        
        // Search space for binary search
        int lo = 0, hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } 
          	else {
                lo = mid + 1;
            }
        }
        return res;
    }

    static int countFreq2(int[] arr, int target) {
      
        // Return the difference between upper bound and lower bound of the target
        return upperBound(arr, target) - lowerBound(arr, target);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;
        System.out.println(countFreq2(arr, target));
    }
}

