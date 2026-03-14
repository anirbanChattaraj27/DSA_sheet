// merge 2 unsorted arrays into an array
// merge 2 unsorted array ( join 2nd array after 1st array’s element)

import java.util.*;


public class O36_2_merge_unsorted_arrays{

    
    public static int[] mergeArr (int[] arr1,int[] arr2){
        
        int[] result = new int [arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length){
            result[k++] = arr1[i++];
        }
        
        while(j < arr2.length){
            result[k++] = arr2[j++];
        }
        return result;
    }
    
    public static void Display(int arr[]){

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();

        // read size of arr1 and arr2
        int arr1[] = new int [size1];
        int arr2[] = new int [size2];

        // enter elements
        for(int i=0; i<arr1.length; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i=0; i<arr2.length; i++){
            arr2[i] = sc.nextInt();
        }

        // int arr1[] = {2, 6, 4, 8};
        // int arr2[] = {1, 3, 2, 7, 5};

        int arr3[] = new int[arr1.length + arr2.length];
        arr3 = mergeArr(arr1, arr2);

        Display(arr3);
    }
}