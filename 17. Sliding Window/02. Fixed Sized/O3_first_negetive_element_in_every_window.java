/* https://www.tutorialcup.com/interview/queue/first-negative-integer-in-every-window-of-size-k.htm

    Naive Approach
    For every window of size k, traverse through all the elements of the window and print the first negative integer.

    Run a loop for i equals 0 to (n – k), here each i corresponds to a window of size k.
    Run a nested loop for j equals i to (i + k)(not included). This loop traverses the window i.
    If the value of arr[j] is negative print it and break, else continue to check for the next element.
    If there is no negative element in a window, print 0.
    Complexity Analysis

    Time Complexity = O(n * k)
    Space Complexity = O(1)

    Input: arr[] = [-8, 2, 3, -6, 1] , k = 2
    Output: [-8, 0, -6, -6]
    Explanation: First negative integer for each window of size 2
    [-8,2] = -8, [2,3] = 0 (does not contain a negative integer), [3,-6] = -6, [-6,10] = -6

    Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
    Output: [-1, -1, -7, -15, -15, 0]
    Explanation: First negative integer for each window of size 3
    [ 12, -1, -7] = -1, [-1,-7, 8] = -1, [-7, 8, -15] = -7, [8, -15, 30] = -15, [-15, 30, 16] = -15, [30, 16, 28] = 0

 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class O3_first_negetive_element_in_every_window {

    private static void firstNegInt1(int[] arr, int k) {
        int n = arr.length;
        // Run a loop corresponding to every window in the array
        for (int i = 0; i <= n - k; i++) {
            boolean negFound = false;
            // Traverse the window
            for (int j = i; j < i + k; j++) {
                // If current element if negative print it
                if (arr[j] < 0) {
                    System.out.print(arr[j] + " ");
                    negFound = true;
                    break;
                }
            }
            // if there is no negative element then print 0
            if (!negFound)
                System.out.print("0 ");
        }
        System.out.println();
    }

    public static int[] firstNegInt2(int[] arr, int k) {
        int n = arr.length;
        
        // Handle edge case where window size is larger than array size
        if (n < k || k <= 0) {
            return new int[0]; 
        }

        // There will be exactly (n - k + 1) windows
        int[] result = new int[n - k + 1];
        int resultIdx = 0;

        // 1. Process the first window (Find the first negative element's index)
        int firstNegativeIdx = -1;
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                firstNegativeIdx = i;
                break; // Found the first one, stop looking
            }
        }

        // Store result for the first window
        if (firstNegativeIdx != -1) {
            result[resultIdx++] = arr[firstNegativeIdx];
        } else {
            result[resultIdx++] = 0;
        }

        // 2. Slide the window (using your loop structure)
        for (int i = k; i < n; i++) {
            
            // If the tracked negative element just fell out of the window on the left
            if (firstNegativeIdx != -1 && firstNegativeIdx <= i - k) {
                firstNegativeIdx = -1; // Reset it
            }

            // If we don't have a valid negative index, search within the current window scope
            if (firstNegativeIdx == -1) {
                for (int j = i - k + 1; j <= i; j++) {
                    if (arr[j] < 0) {
                        firstNegativeIdx = j;
                        break;
                    }
                }
            }

            // Store result for the current window
            if (firstNegativeIdx != -1) {
                result[resultIdx++] = arr[firstNegativeIdx];
            } else {
                result[resultIdx++] = 0;
            }
        }

        return result;
    }

    public static List<Integer> firstNegInt3(int[] arr, int k) {
        int fstNegIdx = 0;
        List<Integer> res = new ArrayList<>();
        int n = arr.length;

        for (int i = k - 1; i < n; i++) {
            // Skip out of window and positive elements
            while (fstNegIdx < i && (fstNegIdx <= i - k || arr[fstNegIdx] >= 0)) {
                fstNegIdx++;
            }

            // Check if a negative element is found,
            // otherwise use 0
            if (fstNegIdx < n && arr[fstNegIdx] < 0) {
                res.add(arr[fstNegIdx]);
            } else {
                res.add(0);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        // Example 1
        int arr1[] = new int[] { 5, -2, 3, 4, -5 };
        int k1 = 2;
        firstNegativeInteger(arr1, k1);
        // Example 2
        int arr2[] = new int[] { 7, 9, -1, 2, 3, 4, -2, -3, -4 };
        int k2 = 3;
        firstNegativeInteger(arr2, k2);

    }
}

