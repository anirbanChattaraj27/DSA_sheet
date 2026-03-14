/* ******** */
// NOTE: show method copyOfRange

// Create a copy of the given input array.
// Sort the copied array.
// Run a nested loop and find the position of the given array element in the sorted array.
// And replace the element with the position.
// Print the modified input array.

import java.util.*;

public class O29_replace_each_element_by_its_rank {
    static void changeArr(int[] arr) {
        // Copy arr array into newArray
        int newArray[] = Arrays.copyOfRange(arr, 0, arr.length);

        // Sort newArray[] in ascending order
        Arrays.sort(newArray);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (newArray[j] == arr[i]) {
                    arr[i] = j + 1;
                    break;
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Given array arr[]
        int[] arr = { 100, 2, 70, 12, 90, 45, 100 };

        // Function Call
        changeArr(arr);

        // Print the array elements
        System.out.println(Arrays.toString(arr));
    }
}