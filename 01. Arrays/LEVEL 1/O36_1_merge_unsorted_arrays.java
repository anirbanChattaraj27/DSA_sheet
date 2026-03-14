// merge 2 unsorted arrays into a sorted array
// link--> https://www.geeksforgeeks.org/merging-two-unsorted-arrays-sorted-order/

import java.util.*;

public class O36_1_merge_unsorted_arrays{

    public static void Display(int arr[]){

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] mergeArr (int[] arr1,int[] arr2){

        int[] result = new int [arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while(i < arr1.length){
            result[k++] = arr1[i++];
        }

        while(j < arr2.length){
            result[k++] = arr2[j++];
        }

        Arrays.sort(result); // in interview write merge sort code insted of using collections
        return result;
    }

    public static void main(String[] args){
        int arr1[] = {12, 32, 45};
        int arr2[] = {13, 46, 72, 45, 74};
        int arr3[] = new int[arr1.length + arr2.length];
        arr3 = mergeArr(arr1, arr2);

        Display(arr3);
    }
}


/*
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();

        int arr1[] = new int [size1];
        int arr2[] = new int [size2];

        for(int i=0; i<arr1.length; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i=0; i<arr2.length; i++){
            arr2[i] = sc.nextInt();
        }

 */