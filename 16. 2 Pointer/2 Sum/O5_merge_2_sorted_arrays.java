// Leetcode 88

public class O5_merge_2_sorted_arrays {

    // in place merging, leetcode style
    /*
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;     // Pointer for last valid element in nums1
        int j = n - 1;     // Pointer for last element in nums2
        int k = m + n - 1; // Pointer for last position in nums1 total capacity

        // Merge from highest to lowest to prevent overwriting nums1 elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Only need to copy remaining elements from nums2
        // Remaining elements in nums1 are already in their correct places
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
     
    // SC O(1)
    public static void merge(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;
 
        // Consider each element `arr1[i]` of array `arr1` and ignore the element if it is
        // already in the correct order; otherwise, swap it with the neaxt smaller
        // element, which happens to be the first element of `arr2`.
        for (int i = 0; i < m; i++)
        {
            // compare the current element of `arr1[]` with the first element of `arr2[]`
            if (arr1[i] > arr2[0])
            {
                // swap `arr1[i]` with `arr2[0]`
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
 
                int first = arr2[0];
 
                // move `arr2[0]` to its correct position to maintain the sorted
                // order of `arr2[]`. see: `arr2[1…n-1]` is alreadarr2 sorted
                int k;
                for (k = 1; k < n && arr2[k] < first; k++) {
                    arr2[k - 1] = arr2[k];
                }
 
                arr2[k - 1] = first;
            }
        }
    }

    // O(N)
    public static int[] mergeArr(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            // if ((arr1[i] == 0) || (arr2[j] == 0)) {
            //     continue;
            // }

            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // remaning elements in arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // remaning elements in arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

}
