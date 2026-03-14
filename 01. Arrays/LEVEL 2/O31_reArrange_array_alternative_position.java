// NOTE: convert Arraylist to array[] 🥎🥎🥎
//       convert array to arrayList🎈🎈🎈

import java.util.*;

public class O31_reArrange_array_alternative_position {

    static void func(int arr[]){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        

        for(int i=0; i<arr.length; i++){ // 🎈🎈🎈
            if(arr[i] < 0){
                list1.add(arr[i]);
            }
        }
        for(int i=0; i<arr.length; i++){  // 🎈🎈🎈
            if(arr[i] >= 0){
                list2.add(arr[i]);
            }
        }

        /* IMPORTANT */ // 🥎🥎🥎
        int arr1[] = list1.stream().mapToInt(i->i).toArray();
        int arr2[] = list2.stream().mapToInt(i->i).toArray();

        /* COMPLETE THIS CODE (difficult) */
    }

    static void fill1(int a[], int neg, int pos) {
        if (neg % 2 == 1) {
            for (int i = 1; i < neg; i += 2) {
                int c = a[i];
                int d = a[i + neg];
                int temp = c;
                a[i] = d;
                a[i + neg] = temp;
            }
        } else {
            for (int i = 1; i <= neg; i += 2) {
                int c = a[i];
                int d = a[i + neg - 1];
                int temp = c;
                a[i] = d;
                a[i + neg - 1] = temp;
            }
        }
    }

    static void fill2(int a[], int neg, int pos) {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2) {
                int c = a[i];
                int d = a[i + pos];
                int temp = c;
                a[i] = d;
                a[i + pos] = temp;
            }
        } else {
            for (int i = 1; i <= pos; i += 2) {
                int c = a[i];
                int d = a[i + pos - 1];
                int temp = c;
                a[i] = d;
                a[i + pos - 1] = temp;
            }
        }
    }

    // Reverse the array
    static void reverse(int a[], int n) {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    // Print the array
    static void print(int a[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) throws java.lang.Exception {
        // Given array
        int[] arr = { -1, 6, -2, 3, -4, 9 };
        int n = arr.length;
        // System.out.println("Given array is ");
        // print(arr, n);
        // int neg = 0, pos = 0;
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] < 0)
        //         neg++;
        //     else
        //         pos++;
        // }
        // // Sort the array
        // Arrays.sort(arr);
        // if (neg <= pos) {
        //     fill1(arr, neg, pos);
        // } else {
        //     // reverse the array in this condition
        //     reverse(arr, n);
        //     fill2(arr, neg, pos);
        // }
        // System.out.println("Rearranged array is ");
        // print(arr, n);

        func(arr);
    }
}