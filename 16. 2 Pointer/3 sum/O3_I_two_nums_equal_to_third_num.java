// https://www.geeksforgeeks.org/dsa/find-triplet-sum-two-equals-third-element/
// Check for Triplet with One as Sum of other Two
// find whether there exist three elements such that the sum of two elements is equal to the third element.

/*
Input: arr[] = [1, 2, 3, 4, 5]
Output: true
Explanation: The pair (1, 2) sums to 3.

Input: arr[] = [3, 4, 5]
Output: false
Explanation: No triplets satisfy the condition.

Input: arr[] = [1, 8, 5, 15, 10]
Output: true
Explanation: The pair (5,10) sums to 15.

SIMIALR to 3SUM, with small change
here,
l = 0, 
r = i-1, 
i=2 to n-1;
so check arr[l] + arr[r] == arr[i]
*/
import java.util.*;

public class O3_I_two_nums_equal_to_third_num {
    public static boolean f(int arr[]){
        Arrays.sort(arr);
        int sum =0;

        for(int i=2; i<arr.length; i++){
            int l = 0, r = i-1;  

            while(l < r){
                sum = arr[l] + arr[r];

                if(sum == arr[i]) return true;

                else if(sum < arr[i]) l++;

                else r--;
            }
        }
        return false;
    }
}
