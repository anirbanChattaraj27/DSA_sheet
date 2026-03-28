// https://leetcode.com/problems/top-k-frequent-elements/

// WRONG
// use PQ to solve this
//  leetcode test cases failed

import java.util.*;
import java.util.Map;

public class O4_top_K_frequent_element {

     static void unique_HashMap(int arr[], int n, int k) {

        Map < Integer, Integer > map = new HashMap < Integer, Integer > ();

        for (int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        } 

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue() >= k)  
        //         System.out.println(entry.getKey()+" ");
        // }  
        
        // to maintain the order this is must line
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i]) != -1){
                
                if(map.get(arr[i]) >= k){
                    System.out.println(arr[i]);
                    map.put(arr[i], -1);
                }
            }
        }
    }

    public static void main(String[] args){

        int arr[] = {2, 3, 2, 1, 2, 2, 3, 3, 4, 5, 3, 1};
        int n = arr.length;
        int k = 2;
        unique_HashMap(arr, n, k);
    }
}
