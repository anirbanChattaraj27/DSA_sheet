// https://www.geeksforgeeks.org/suffix-sum-array/

import java.util.*;

public class O2_Suffix_sum_arr {
    
    static List<Integer> suffSum (int arr[]){

        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=arr.length-1; i>=0; i--){
            sum += arr[i];
            list.add(sum);
        }
        return list.reversed();
    }

    public static void main(String[] args) {
        int[] arr = {15, 10, 25, 5, 10, 20 };
        List<Integer> prefixSum = suffSum(arr);
        for (int i : prefixSum) {
            System.out.print(i + " "); // O/P: [85, 70, 60, 35, 30, 20]
        }
    }
}


