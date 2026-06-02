// https://leetcode.com/problems/find-k-closest-elements/description/

// 2 pointer ----------> (O(log(N - K) + K) --> more efficient
// Binary search ------> (O(N)

import java.util.ArrayList;
import java.util.List;

public class O1_K_closest_element {
    
    // 2 pointer + Slidign Window
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize two pointers at the extreme ends of the array
        int left = 0;
        int right = arr.length - 1;

        // Shrink the window until its size equals k
        while (right - left + 1 > k) {
            // Compare the distances of the outer elements to x
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                // Left element is further away, eliminate it
                left++;
            } else {
                // Right element is further away (or there is a tie)
                // In a tie, we eliminate the right element because 
                // the problem prefers the smaller/leftmost element.
                right--;
            }
        }

        // Collect the remaining k elements into the result list
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        
        return result;

    }

    // B.S
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        // Binary search for the starting index of the k-element window
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare the distance of x from arr[mid] vs arr[mid + k]
            if (x - arr[mid] <= arr[mid + k] - x) {
                // arr[mid] is closer or tied, so the window can start at mid or further left
                right = mid;
            } else {
                // arr[mid + k] is closer, so mid cannot be the start index
                left = mid + 1;
            }
        }

        // Build the result list from the identified window [left, left + k)
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
