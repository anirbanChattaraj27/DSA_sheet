/* 43.	 find non duplicates / unique / find non repeating elements */

// unique I/P: 12, 32, 45, 12, 32, 65
// unique O/P: 45, 65 

// approch:
/*
    in different place of i and j if number will be same then increment counter and dont print the element if count = 0 then print the element
*/

import java.util.*;

public class O12_unique_elements {

    static void unique_nestedLoops(int arr[], int n) {
        
        int count = 0;
        for(int i=0; i<arr.length; i++){
            count = 0;

            for(int j=0; j<arr.length; j++){
                if(i != j) {    // when value of i and j are in different indices in this case will check element of i and j are equal ? if equal then increse count
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }
            }

            if(count == 0){
                System.out.println( arr[i]);
            }
        }
    }

    static void unique_HashMap(int arr[], int n) {
        Map < Integer, Integer > map = new HashMap < Integer, Integer > ();

        for (int i=0; i<n; i++) {            
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // default means if element is not there in map then its value is default means 0 if already value is present then its value is +1 means old count value and add +1 with it.
        } // upto this code is similar like print frequency of elements

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue() == 1)  // if map value is ==1 then that means every element appears once in map
        //         System.out.println(entry.getKey()+" ");
        // }

        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i]) != -1){
                if(map.get(arr[i]) == 1){
                    System.out.println(arr[i]);
                    map.put(arr[i], -1);
                }
            }
        }
    }

    public static void main(String[] args){

        int arr[] = {10, 20, 10, 30, 30, 50, 40};
        unique_HashMap(arr, arr.length);
    }
}
