
/*
Given an increasing sorted rotated array arr of distinct integers. The array is right-rotated 
K times. Find the value of K.

Input: arr = [5, 1, 2, 3, 4]
Output: 1
Explanation: The given array is 5 1 2 3 4. The original sorted array is 1 2 3 4 5. 
            We can see that the array was rotated 1 times to the right.

Input: arr = [1, 2, 3, 4, 5]
Output: 0
Explanation: The given array is not rotated.
*/ 


public class O4_IV_find_K_rotation_point {

    public static int findRotationCount(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            // If the array is already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            // Check if mid is the minimum element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Decide whether we need to go to the left half or the right half
            if (arr[mid] <= arr[high]) {
                high = mid - 1;
            } else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            }
        }

        return 0; // Just a fallback, ideally should not reach here
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println("Rotation count for arr1: " + findRotationCount(arr1)); // Output: 1
        System.out.println("Rotation count for arr2: " + findRotationCount(arr2)); // Output: 0
    }
}
