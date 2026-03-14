// leetcode: combination sum 1 question


// this code is not for COMBINATION SUM bcz here 1 number is not repeatedly use to get target K
// in COMBINATION SUM 1 number can be used multiple times to achive the target like 2 can be use twice or thrice or more to achive the target but here in this code it will not do so

// print all subSequences whose sum is K
// copy 2


// PROBLEM: here in this prblem i can't take 1 index multiple times to form the K i can take 1 index once

import java.util.*;

public class O4_1_print_subSequences_with_K {
    public static void printSubSequences(int idx, ArrayList<Integer> list, int sum, int K, int arr[], int n) {
        if (idx == n) {
            if(sum == K){
                System.out.println(list);
            }
            return;
        }

        list.add(arr[idx]);
        sum += arr[idx]; // Increases sum by arr[idx].  
        printSubSequences(idx + 1, list, sum, K, arr, n); // Recursively calls printSubSequences() with idx + 1 to move to the next element. // as i am not taking 1 index multiple times so increase ind by idx+1 and moving to next idx 

        sum -= arr[idx]; // Backtracks by removing the last added element from list. // Restores sum by subtracting arr[idx] (to explore other subsequences).
        list.remove(list.size() - 1); 

        printSubSequences(idx + 1, list, sum, K, arr, n);  // Calls the function again without adding arr[idx] to list, allowing us to explore subsequences where arr[idx] is not included.
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr1[] = {1, 2, 4, 2, 3, 5, 3, 2, 6};
        int n1 = arr1.length;

        int arr2[] = {1, 2, 4, 3, 5, 3, 6};
        int n2 = arr2.length;

        int arr3[] = {1, 4, 3, 2};
        int n3 = 3;

        int sum = 0;
        int K = 7;

        printSubSequences(0, list, sum, K, arr3, n3);

    }
}

/*
 
                                    []
                                   /  \
                                [1]   []
                               /   \    \
                           [1,2]   [1]   []
                          /     \    \     \
                    [1,2,4]   [1,2]  [1]    []
                    (sum=7)    (sum=3)      (sum=1)
                    X (backtrack)

Every element can either be included or excluded.
At each recursive step, a subsequence is built, and its sum is checked.
If sum == K, the subsequence is printed.


 */
