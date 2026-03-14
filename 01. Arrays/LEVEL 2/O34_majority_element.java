// https://leetcode.com/problems/majority-element/
// https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab


import java.util.*;

public class O34_majority_element {
    public static int majorityElement(int[] arr) {
        Map <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) +1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

        int res = 0;
        res = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        
        return res;

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue() > arr.length/2){
        //         return entry.getKey();
        //     }
        // }


    }

    public static void main(String[] args) {
        int arr[] = {3,1,3,3,2,2,3};
        System.out.print(majorityElement(arr));
    }
}
