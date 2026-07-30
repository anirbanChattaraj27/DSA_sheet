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

    public static List<Integer> firstNegativeInteger(int[] arr, int k) {

    List<Integer> ans = new ArrayList<>();

    int firstNeg = 0;

    for (int i = 0; i <= arr.length - k; i++) {

        // Move pointer inside current window
        while (firstNeg < i + k) {

            if (firstNeg < i || arr[firstNeg] >= 0)
                firstNeg++;
            else
                break;
        }

        if (firstNeg < i + k)
            ans.add(arr[firstNeg]);
        else
            ans.add(0);
    }

    return ans;
}


    public static void main(String[] args) {
        // Example 1
        int arr1[] = new int[] { 5, -2, 3, 4, -5 };
        int k1 = 2;
        System.out.println(firstNegativeInteger(arr1, k1));
        // Example 2
        int arr2[] = new int[] { 7, 9, -1, 2, 3, 4, -2, -3, -4 };
        int k2 = 3;
        firstNegativeInteger(arr2, k2);

    }
}

