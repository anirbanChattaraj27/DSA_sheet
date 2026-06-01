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

    private static void firstNegInt2(int[] arr, int k) {
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
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int n = arr.length;

        // Process the first window of size k 
        for (int i = 0; i < k; i++)
            if (arr[i] < 0)
                dq.addLast(i);

        // Process rest of the elements, i.e., 
        // from arr[k] to arr[n-1]
        for (int i = k; i < n; i++) {
            if (!dq.isEmpty())
                res.add(arr[dq.peekFirst()]);
            else
                res.add(0);
            
            // Remove the elements which are out of 
            // this window
            while (!dq.isEmpty() && dq.peekFirst() < (i - k + 1))
                dq.pollFirst();
            
            // Add the current element if it is negative
            if (arr[i] < 0)
                dq.addLast(i);
        }
        
        // For the last window, process it separately
        if (!dq.isEmpty())
            res.add(arr[dq.peekFirst()]);
        else
            res.add(0);
        
        return res.stream().mapToInt(i -> i).toArray();
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

