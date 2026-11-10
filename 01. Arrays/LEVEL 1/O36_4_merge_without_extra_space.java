// Qs link --> https://www.geeksforgeeks.org/merge-two-sorted-arraarr2s-o1-earr1tra-space/
// dont see the solution from gfg.... what i have done this is the solution

import java.util.*;

public class O36_4_merge_without_extra_space{
    // Function to in-place merge two sorted arraarr2s arr1[] and arr2[]
    // invariant: `arr1[]` and `arr2[]` are sorted at anarr2 point
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
 
    public static void main (String[] args)
    { 
        int[] arr1 = { 1, 4, 7, 8, 10 };
        int[] arr2 = { 2, 3, 9 };
 
        merge(arr1, arr2);
 
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
} 