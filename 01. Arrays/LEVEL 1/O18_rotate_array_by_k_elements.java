/*
 *          "LEFT ROTATE"  "anti-clockwise"
 *  Input  : arr[] = {1, 2, 3, 4, 5} 
 *  k = 2 
 *  Output : 3 4 5 1 2 
*/

/*
 *         "RIGHT ROTATE"  "clockwise"
 * Input  : arr[] = {1, 2, 3, 4, 5} 
 * k = 2
 * Output : 4 5 1 2 3 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// rotate array means shifing array

public class O18_rotate_array_by_k_elements {
    // this will reverse the array
    public static void reverse(int arr[], int left, int ri) {
        while (left < ri) {
            int temp = arr[left];
            arr[left] = arr[ri];
            arr[ri] = temp;

            left++;
            ri--;
        }
        
    }

    public static void rightRotate(int arr[], int k) {

        int n = arr.length;
        k = k % n;
        
        // part 1 reverse || total reverse
        reverse(arr, 0, n - 1); // this will reverse 1st part upto k-1

        // part 2 reverse || left reverse
        reverse(arr, 0, k - 1);

        // part 3 reverse || right reverse
        reverse(arr, k, n - 1);
    }

    public static void leftRotate(int arr[], int k) {

        int n = arr.length;
        k = k % arr.length;

        // part 1 reverse || left reverse
        reverse(arr, 0, k - 1);
        
        // part 2 reverse || right reverse
        reverse(arr, k, n - 1);
        
        // part 3 reverse || total reverse
        reverse(arr, 0, n - 1); // this will reverse 1st part upto k-1
    }

    // another approch 
    /*
     * left rotate:
     * take extra array and enter last K elements in new array and then enter 1st k elements and print them
     */

    static void RightFun(int arr[], int k){

        // dont use single arrayList here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=k; i<arr.length; i++){
            list1.add(arr[i]);
        }
        for(int i=0; i<k; i++){
            list2.add(arr[i]);
        }

        for(int i=0; i<list2.size(); i++){
            System.out.print (list2.get(i) + " ");
        }
        for(int i=0; i<list1.size(); i++){
            System.out.print (list1.get(i) + " ");
        }
    }

    static void leftFun(int arr[], int k){

        // dont use single arrayList here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=k; i<arr.length; i++){
            list1.add(arr[i]);
        }
        for(int i=0; i<k; i++){
            list2.add(arr[i]);
        }

        for(int i=0; i<list1.size(); i++){
            System.out.print (list1.get(i) + " ");
        }        
        for(int i=0; i<list2.size(); i++){
            System.out.print (list2.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // int n;
        // System.out.println("Length of array: ");
        // n = s.nextInt();

        // int arr[] = new int[n];
        // System.out.print("enetr elements: ");
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = s.nextInt();
        // }

        // int k;
        // System.out.println("enter how many times want to rotate: ");
        // k = s.nextInt();

        int arr[] = {1,2,3,4,5};
        int arr2[] = {1,2,3,4,5};
        int k = 2;

        rightRotate(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // RightFun(arr, k);
        
        System.out.println();

        leftRotate(arr2, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        // leftFun(arr, k);


    }
}
