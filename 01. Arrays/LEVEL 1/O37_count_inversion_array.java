/*
https://leetcode.com/problems/count-the-number-of-inversions/description/
https://www.geeksforgeeks.org/dsa/inversion-count-in-array-using-merge-sort/

Given an integer array arr[] of size n, find the inversion count in the array. 
Two array elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Note: Inversion Count for an array indicates that how far (or close) the array is 
from being sorted. If the array is already sorted, then the inversion count is 0, but 
if the array is sorted in reverse order, the inversion count is maximum. 


Input: arr[] = [1, 2, 3, 4, 5]
Output: 0
Explanation: There is no pair of indexes (i, j) exists in the given array such that arr[i] > arr[j] and i < j

Input: arr[] = [10, 10, 10]
Output: 0
Explanation: There is no pair of indexes (i, j) exists in the given array such that arr[i] > arr[j] and i < j


*/

public class O37_count_inversion_array {

    // Brute
    static int numberOfInversions(int[] arr) {
        int cnt = 0; // Initialize count
        int n = arr.length;
        // Check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) cnt++; // Increment if inversion found
            }
        }
        return cnt; // Return total inversions
    }

    // OPTIMAL
    public int merge(int[] arr, int low, int mid, int high) {
        // Temporary array
        int[] temp = new int[high - low + 1];

        // Starting indices of left and right halves
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Variable to count inversions
        int cnt = 0;

        // Merge elements in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1); // Count inversions
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return cnt;
    }

    // Merge sort function
    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low >= high) return cnt;

        int mid = (low + high) / 2;

        // Count inversions in left half
        cnt += mergeSort(arr, low, mid);
        // Count inversions in right half
        cnt += mergeSort(arr, mid + 1, high);
        // Count inversions during merge
        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    // Function to get number of inversions
    public int numberOfInversions2(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        // Input array
        int[] a = {5, 4, 3, 2, 1};

        // Count inversions
        int cnt = numberOfInversions(a);

        System.out.println("The number of inversions are: " + cnt);
    }
}
