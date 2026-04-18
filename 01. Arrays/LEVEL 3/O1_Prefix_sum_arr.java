
// https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/

/*
Input: arr[] = [10, 20, 10, 5, 15]
Output: [10, 30, 40, 45, 60]
Explanation: For each index i, add all the elements from 0 to i:
prefixSum[0] = 10, 
prefixSum[1] = 10 + 20 = 30, 
prefixSum[2] = 10 + 20 + 10 = 40 and so on.
*/

import java.util.*;

public class O1_Prefix_sum_arr {

    static List<Integer> prefSum (int arr[]){

        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            list.add(sum);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {30, 10, 10, 5, 50};
        List<Integer> prefixSum = prefSum(arr);
        for (int i : prefixSum) {
            System.out.print(i + " "); // O/P: [30, 40, 50, 55, 105]
        }
    }
}