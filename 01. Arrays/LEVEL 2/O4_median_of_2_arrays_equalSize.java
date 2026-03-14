
// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class O4_median_of_2_arrays_equalSize {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }

        while (j < n) {
            merged[k++] = nums2[j++];
        }

        int mid = (m + n) / 2;

        if ((m + n) % 2 == 0) {
            return (merged[mid - 1] + merged[mid]) / 2.0;
        } else {
            return merged[mid];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 45, 1, 0, 4, 7 };
        int arr2[] = { 125, 5, 51, 45, 12, 0 };
        System.out.println(findMedianSortedArrays(arr, arr2));
    }
}
