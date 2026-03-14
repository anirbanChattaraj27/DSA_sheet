// https://www.geeksforgeeks.org/maximise-the-number-of-toys-that-can-be-purchased-with-amount-k/

// Input:  N = 10, K =  50,  cost = { 1, 12, 5, 111, 200, 1000, 10, 9, 12, 15 }
// Output: 6
// Explanation: Toys with amount 1, 5, 9, 10, 12, and 12  can be purchased resulting in a total amount of 49. Hence, maximum number of toys is 6.

// Input: N = 7, K = 5,  cost = { 1, 12, 5, 111, 200, 1000, 10 }
// Output: 1

import java.util.*;

public class O35_number_of_toys_with_K_amount {
    static int maximum_toys(int arr[], int N, int K) {
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            
            if(sum + arr[i] <= K){
                sum = sum+arr[i];  
                count++;
            }
        }
        return count;
    }

    // Driver Code
    public static void main(String[] args) {
        int K = 7;
        int cost[] = { 2,3,1,4,5 };
        int N = cost.length;

        System.out.print(maximum_toys(cost, N, K));
    }
}
