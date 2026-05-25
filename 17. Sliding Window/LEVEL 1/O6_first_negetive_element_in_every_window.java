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

 */

public class O6_first_negetive_element_in_every_window {

    private static void firstNegativeInteger(int[] arr, int k) {
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

