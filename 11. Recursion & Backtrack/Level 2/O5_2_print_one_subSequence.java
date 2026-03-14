
// without using global variable
// this way of solving is PREFFERED

import java.util.*;

public class O5_2_print_one_subSequence {
    public static boolean printSubSequences(int idx, ArrayList<Integer> list, int sum, int K, int arr[], int n) {
        if (idx == n) {
            if (sum == K) {
                System.out.println(list);
                return true;
            }
            else{
                return false;
            }
        }

        list.add(arr[idx]);
        sum += arr[idx];

        if(printSubSequences(idx + 1, list, sum, K, arr, n)){
            return true;
        }
        sum -= arr[idx];
        list.remove(list.size() - 1);

        if(printSubSequences(idx + 1, list, sum, K, arr, n)){
            return true;
        }
        return false;
    }
    

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // int arr[] = {1, 2, 1}; // Given input
        // int K = 2;
        int arr[] = {1, 2, 4, 2, 3, 5, 3, 2, 6};
        int n = 9;
        int sum = 0;
        int K = 6;
        printSubSequences(0, list, sum, K, arr, n); // Pass arr.length
    }
}
