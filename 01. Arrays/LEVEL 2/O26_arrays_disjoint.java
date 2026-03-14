/*
    Input: set1[] = {12, 34, 11, 9, 3}
           set2[] = {2, 1, 3, 5}
    Output: Not Disjoint
    3 is common in two sets.

    Input: set1[] = {12, 34, 11, 9, 3}
           set2[] = {7, 2, 1, 5}
    Output: Yes, Disjoint
    There is no common element in two sets.
 */

import java.util.*;



public class O26_arrays_disjoint {

    static boolean func(int arr[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        return set.size() == arr.length+arr2.length;
    }

    // This function prints all distinct elements
    static boolean Disjoint(int arr1[], int arr2[]) {
        HashSet set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++)
            set.add(arr1[i]);

        for (int i = 0; i < arr2.length; i++)
            if (set.contains(arr2[i]))
                return false;

        return true;
    }

    // Driver method to test above method
    public static void main(String[] args) {
        int arr1[] = { 10, 51, 3, 43, 6 };
        int arr2[] = { 80, 71, 5, 8 };

        System.out.println(Disjoint(arr1, arr2));

        System.out.println(func(arr1, arr2));
    }
}
