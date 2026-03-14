// problem

import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

/*
    2 array has given i have to print sum of 2 arrays from user input
    a[] =    [2, 5, 7, 2]
    b[] = [1, 2, 3, 6, 5]
    o/p = [1, 5, 9, 3, 7]
*/

// public class O12_sum_of_2_arrays {
//     public static void main(String[] args) { 
//         Scanner s = new Scanner((System.in));

//         // 1st array
//         System.out.println("Enter how many elements u want to print in 1st Array");
//         int n1 = s.nextInt();
//         int[] arr1 = new int[n1];
//         // elemets in array 1
//         System.out.println("Enter elemets in 1st array");
//         for(int i=0; i<arr1.length; i++){
//             arr1[i] = s.nextInt();
//         }

//         // 2nd array
//         System.out.println("Enter how many elements u want to print in 2nd Array");
//         int n2 = s.nextInt();
//         int[] arr2 = new int[n2];
//         // elemets in array 2
//         System.out.println("Enter elemets in 2nd array");
//         for(int i=0; i<arr2.length; i++){
//             arr2[i] = s.nextInt();
//         }

//         // 3rd array
//         int[] sum = new int [n1 > n2? n1 : n2]; // if n1 > n2 then create an array of n1 size otherwise n2 size

//         //  carray variable initialized with 0
//         int carry = 0;

//         int i = arr1.length-1; // if array elemets are 7 then array size is 6 means 7-1 so length-1
//         int j = arr2.length-1;
//         int k = sum.length-1;

//         while(k >= 0){ // loop is executing when k willl be >= 0
//             int digit = carry;

//             if(i >= 0){
//                 digit += arr1[i];
//             }

//             if(j >= 0){
//                 digit += arr2[j];
//             }

//             carry = digit / 10;
//             digit = digit % 10;

//             sum[k] = digit;

//             i--;
//             i--;
//             k--;
//         }

//         if (carry != 0){
//             System.out.print("**" + carry);
//         }

//         for(int val : sum){
//             System.out.print("--" + val);
//         }
//     }
// }

public class O2_sum_of_2_arrays {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner((System.in));
        int n1 = 5;
        int[] a1 = new int[]{ 3, 1, 0, 7, 5 };
        int n2 = 6;
        int[] a2 = new int[]{ 1, 1, 1, 1, 1, 1 };

        int[] sum = new int[n1 > n2 ? n1 : n2];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = sum.length - 1;
        int c = 0;
        while (i >= 0 || j >= 0) {
            int d = c;

            if (i >= 0)
                d += a1[i];

            if (j >= 0)
                d += a2[j];

            c = d / 10;
            d = d % 10;
            sum[k] = d;

            i--;
            j--;
            k--;
        }

        if (c > 0) {
            System.out.print(c);
        }
        for (int val : sum) {
            System.out.print(val);
        }
    }
}