// Input: arr[] = {3, 10, 2, 1, 20}
// Output: Length of LIS = 3
// The longest increasing subsequence is 3, 10, 20

// Input: arr[] = {3, 2}
// Output: Length of LIS = 1
// The longest increasing subsequences are {3} and {2}

// Input: arr[] = {50, 3, 10, 7, 40, 80}
// Output: Length of LIS = 4
// The longest increasing subsequence is {3, 7, 40, 80}


//  time and spaace --> O(n^2)

import java.util.*;

public class O2_Longest_Increasing_SubSequence {

    public static int array(int arr[], int n) {

        int arr2[] = new int[n];
        arr2[0] = 1;

        for (int i = 1; i < n; i++) {
            arr2[i] = 1;

            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j] && arr2[i] < arr2[j] + 1){
                    arr2[i] = arr2[j] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr2.length; ++i) {
            if (arr2[i] > ans) {
                ans = arr2[i];
            }
        }
        return ans;
    }

    public static void main (String[]args) {

        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of arr2 is " + array(arr, n));
    }
}

