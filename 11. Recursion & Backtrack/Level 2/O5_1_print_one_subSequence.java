
// using global variable 
// though this is right but not recomended to use 
import java.util.*;

public class O5_1_print_one_subSequence {
    static boolean flag = false;

    public static void printSubSequences(int idx, ArrayList<Integer> list, int sum, int K, int arr[], int n) {
        if (idx == n) {
            if(sum == K && flag == false){
                flag = true; // just by writing this i can avoid print other subSequences
                System.out.println(list);
            }
            return;
        }

        list.add(arr[idx]);
        sum += arr[idx];

        printSubSequences(idx + 1, list, sum, K, arr, n);
        sum -= arr[idx];
        list.remove(list.size() - 1);

        printSubSequences(idx + 1, list, sum, K, arr, n);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // int arr[] = {1, 2, 1}; // Given input
        // int K = 2;
        int arr[] = {1, 2, 4, 2, 3, 5, 3, 2, 6};
        int n = 9;
        int sum = 0;
        int K = 6;

        printSubSequences(0, list, sum, K, arr, n);

    }
}
