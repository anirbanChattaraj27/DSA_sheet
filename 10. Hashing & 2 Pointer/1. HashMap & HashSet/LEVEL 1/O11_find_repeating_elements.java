// find repeating elements/ find duplicate/ remove non-repeateting elements

import java.util.*;

public class O11_find_repeating_elements {
    static void repeateting(int arr[], int n) {
        Map < Integer, Integer > map = new HashMap < Integer, Integer > ();

        for (int i = 0; i < n; i++) {

            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        } 

        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i]) != -1){
                if(map.get(arr[i]) > 1){
                    System.out.println(arr[i]);
                    map.put(arr[i], -1);
                }
            }
        }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue() > 1)
        //         System.out.println(entry.getKey()+" ");
        // }
    }

    public static void main(String[] args) {
        int arr[] = {12, 12, 1, 2, 13, 2};
        repeateting(arr, arr.length);

    }
}
