// https://www.geeksforgeeks.org/dsa/number-subarrays-maximum-value-given-range/
// Count subarrays with max values in given range

/*
The task is to find the count of subarrays where the maximum element in that subarray 
is in range [l, r]. In other words, the max element is at least l and at most r.

Input: arr[] = [1, 2, 3, 4, 5], l = 2, r = 5
Output: 11
Explanation: Valid subarrays are: [2], [3], [4], [5], [1,2], [2,3], [3,4], [4,5], [1,2,3], [2,3,4], [3,4,5], [1,2,3,4], [2,3,4,5], [1,2,3,4,5].
*/
public class O9_Subarrays_with_Max_in_range {
    static int countSubarrays(int[] arr, int l, int r) {
        
        int n = arr.length;
        int count = 0;
        int lastInvalid = -1, lastValid = -1;
 
        // Traverse the array once
        for (int i = 0; i < n; i++) {
            
            // If arr[i] is out of range,  
            // reset lastValid
            if (arr[i] > r) {
                lastInvalid = i;
                lastValid = -1;
            }

            // If arr[i] is within range,  
            // update lastValid
            if (arr[i] >= l && arr[i] <= r) {
                lastValid = i;
            }

            // Add valid subarrays ending at index i
            if (lastValid != -1) {
                count += lastValid - lastInvalid;
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5};
        int l = 2, r = 5;

        System.out.println(countSubarrays(arr, l, r));
    }
}
