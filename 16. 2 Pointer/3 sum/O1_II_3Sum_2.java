// https://www.geeksforgeeks.org/dsa/find-a-triplet-that-sum-to-a-given-value/
/*
Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
Output: true
Explanation: The triplet [1, 4, 8] sums up to 13

Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10 
Output: true
Explanation: The triplets [1, 3, 6] and [1, 2, 7] both sum to 10. 

Input: arr[] = [40, 20, 10, 3, 6, 7], sum = 24 
Output: false
Explanation:  No triplet in the array sums to 24.
*/

// same as 3 sum, but here we just need to return true or false, not the triplet

import java.util.*;

public class O1_II_3Sum_2 {
    public static boolean f(int arr[], int n, int target){
        Arrays.sort(arr);

        for(int i=0; i<n; i++){

            if(i > 0 && arr[i] == arr[i-1]) continue;
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum =  arr[i] + arr[left] + arr[right];
                if(target == sum){
                    return true;
                }
                else if(sum > target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return false;
    }
}
