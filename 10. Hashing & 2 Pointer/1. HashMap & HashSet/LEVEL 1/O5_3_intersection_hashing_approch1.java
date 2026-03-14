/*
 * NOTE: if i return a LIST then i just need to print it in main function no need to create display func for arrayList
 */


import java.lang.*;
import java.util.*;

public class O5_3_intersection_hashing_approch1 {

    //using (set1.contains)
    static ArrayList<Integer> getIntersection(int[] arr1, int[] arr2, int n, int m) {

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set1.add(arr1[i]);
        }

        for (int i = 0; i < m; i++) {
            set2.add(arr2[i]);
        }

        for (int x : set2) {
            if (set1.contains(x)) {
                result.add(x);
            }
        }
        return result;
    }

    //using (!set1.contains)
    static ArrayList<Integer> getIntersection2(int[] arr1, int[] arr2, int n, int m) {

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!set1.contains(arr1[i]))
                set1.add(arr1[i]);
        }

        for (int i = 0; i < m; i++) {
            if (!set2.contains(arr2[i]))
                set2.add(arr2[i]);
        }

        for (int x : set2) {
            if (set1.contains(x)) {
                result.add(x);
            }
        }
        return result;
    }

    static ArrayList < Integer > getIntersection3(int[] arr1, int[] arr2, int n, int m) {
        
        Set < Integer > set1 = new HashSet < Integer > ();
        Set < Integer > set2 = new HashSet < Integer > ();
        ArrayList < Integer > result = new ArrayList < > ();

        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }

        for (int k = 0; k < arr2.length; k++) {
            if (set1.contains(arr2[k])) {
                result.add(arr2[k]);
                set1.remove(arr2[k]); // if multiple times same num will be there in set2 or array2 then i have to remove them bcz only distinct elements i need so i have to remove theme
            }
        }

        return result;
    }

    // simple way
    // without using arrayList
    static void getIntersection4(int[] arr1, int[] arr2, int n, int m) {

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        int count=0;

        for (int i = 0; i < n; i++) { // adding value in hashSet
            set1.add(arr1[i]);
        }

        for (int i = 0; i < m; i++) { // adding value in hashSet
            set2.add(arr2[i]);
        }

        for (int x : set2) { // if x present in set2
            if (set1.contains(x)) { // set1 elements are in x
                System.out.print (x + " ");
                count++;
            }
        }
        System.out.println("count is -> " + count);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 5, 8, 5, 7, 8, 10 };
        int[] arr2 = new int[] { 1, 5, 5, 8, 1, 8, 7 }; // o/p => 5,7,8

        int n = arr1.length;
        int m = arr2.length;
        getIntersection4(arr1, arr2, n, m);

        System.out.println(getIntersection3(arr1, arr2, n, m));
    }
}

