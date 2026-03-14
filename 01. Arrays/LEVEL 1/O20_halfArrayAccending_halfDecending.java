
// for odd no of array formula is ---> n/2 + 1
// for even no of array formula is ---> n/2 

// check afterwards this qs

import java.util.*;
import java.util.Collections;
import java.util.Scanner;
 
public class O20_halfArrayAccending_halfDecending {

    static void func1(int arr[]){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0; i<(arr.length/2); i++){
            list1.add(arr[i]);
        }

        for(int i=(arr.length/2); i<arr.length; i++){
            list2.add(arr[i]);
        }

        Collections.sort(list1);
        Collections.sort(list2, Collections.reverseOrder());

        for(int i=0; i<list1.size(); i++){
            System.out.print (list1.get(i) + " ");
        }
        for(int i=0; i<list2.size(); i++){
            System.out.print (list2.get(i) + " ");
        }
        
    }

    static void func2(int arr[]){
        for (int i = 0; i < (arr.length / 2); i++) {
            for (int j = i + 1; j < (arr.length / 2); j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // sorting second half in descending order
        for (int i = (arr.length / 2); i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int x : arr)
            System.out.print(x + " ");
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 7, 8 , 99};

        func2(arr);
        System.out.println();

        System.out.println("using Arraylist: ");
        func1(arr);
    }
}