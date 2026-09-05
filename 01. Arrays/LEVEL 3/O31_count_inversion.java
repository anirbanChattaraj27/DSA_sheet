/*
    Traverse through the array, and for every index, find the number of smaller 
    elements on its right side of the array. This can be done using a nested loop. 
    Sum up the counts for all indices in the array and print the sum.

    Input: arr[] = {8, 4, 2, 1}
    Output: 6
    Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).

    Input: arr[] = {1, 20, 6, 4, 5}
    Output: 5
    Explanation: Given array has five inversions: (20, 6), (20, 4), (20, 5), (6, 4), (6, 5)
*/

public class O31_count_inversion {
    // static int arr[] = new int[] { 1, 6, 4, 5 };

    // brute 
    static int getInvCount(int arr[]) {
        int inv_count = 0;

        for (int i=0; i<arr.length-1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    inv_count++;
        return inv_count;
    }

    static int countAndMerge(int[] arr, int l, int m, int r) {
      
        // Counts in two subarrays
        int n1 = m - l + 1, n2 = r - m;

        // Set up two arrays for left and right halves
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        // Initialize inversion count (or result)
        // and merge two halves
        int res = 0;
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {

            // No increment in inversion count
            // if left[] has a smaller or equal element
            if (left[i] <= right[j])
                arr[k++] = left[i++];
          
            // If right is smaller, then it is smaller than n1-i 
            // elements because left[] is sorted
            else {
                arr[k++] = right[j++];
                res += (n1 - i);
            }
        }

        // Merge remaining elements
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];

        return res;
    }

    // Function to count inversions in the array
    static int countInv(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int m = (r + l) / 2;

            // Recursively count inversions
            // in the left and right halves
            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);

            // Count inversions such that greater element is in 
            // the left half and smaller in the right half
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    static int inversionCount(int[] arr) {
        return countInv(arr, 0, arr.length - 1);
    }

    
    // Driver method to test the above function
    public static void main(String[] args) {
        int arr[] = { 8, 4, 2, 1 };
        System.out.println("Number of inversions are " + getInvCount(arr)); //(6,4), (6,5)
        // printInversion(arr); 
    }
}
