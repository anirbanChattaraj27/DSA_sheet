// https://www.geeksforgeeks.org/find-missing-elements-of-a-range/

// Input: arr[] = {10, 12, 11, 15}, low = 10, high = 15
// Output: 13, 14

// Input: arr[] = {1, 14, 11, 51, 15},  low = 50, high = 55
// Output: 50, 52, 53, 54 55

import java.util.*;

public class O15_missing_elements_in_range {

    static void printMissing(int ar[], int low, int high) {

        HashSet<Integer> hs = new HashSet<>();

        // Insert all elements in set
        for (int i = 0; i < ar.length; i++)
            hs.add(ar[i]);

        // Traverse through the range an print all missing elements
        for (int i = low; i <= high; i++) {
            if (!hs.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 4, 15 };
        int low = arr[0];
        int high = arr[arr.length-1];
        printMissing(arr, low, high);
    }
}
