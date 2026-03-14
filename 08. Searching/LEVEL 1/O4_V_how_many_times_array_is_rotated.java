
/*
https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/?ref=rbp

Given an array arr[] having distinct numbers sorted in increasing order and the 
array has been right rotated (i.e, the last element will be cyclically shifted to 
the starting position of the array) k number of times, the task is to find the value of k.

    Input: arr[] = {15, 18, 2, 3, 6, 12}
    Output: 2
    Explanation: Initial array must be {2, 3, 6, 12, 15, 18}. 
    We get the given array after rotating the initial array twice.


    Input: arr[] = {7, 9, 11, 12, 5}
    Output: 4


    Input: arr[] = {7, 9, 11, 12, 15};
    Output: 0
*/

public class O4_V_how_many_times_array_is_rotated {

    // array which is first sorted in ascending order, then rotated
    static int countRotations(int arr[]) {
        // We basically find index of minimum element
        int n = arr.length;
        int min = arr[0];
        int min_index = 0;

        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    // Striver || Iteration || T.C = O(log n) & S.C = O(1)
    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // search space is already sorted then arr[low] will 
            // always be the minimum in that search space: 
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {

                if (arr[low] < ans) { // keep the minimum:
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1; // Eliminate left half:
            } 
            
            //if right part is sorted:
            else {
                
                if (arr[mid] < ans) { // keep the minimum:
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1; // Eliminate right half:
            }
        }
        return index;
    }

    // Recursive || GFG || T.C = O(log n) & S.C = O(1)
    static int countRotations2(int arr[], int low, int high) {
        // This condition is needed to handle the case when array is not rotated at all
        if (high < low) {
            return 0;
        }

        // If there is only one element left
        if (high == low) {
            return low;
        }

        // Find mid  ===>  (low + high)/2
        int mid = low + (high - low) / 2;

        // Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid + 1] < arr[mid]) {
            return (mid + 1);
        }

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid;
        }

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid]) {
            return countRotations2(arr, low, mid - 1);
        }

        return countRotations2(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = countRotations(arr);
        System.out.println("The array is rotated " + ans + " times.");

    }
}
