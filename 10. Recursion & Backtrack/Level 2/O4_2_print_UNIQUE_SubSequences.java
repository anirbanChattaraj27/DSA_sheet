
// chatGPT code
import java.util.*;

public class O4_2_print_UNIQUE_SubSequences {

    public static void printSubSequences(int idx, ArrayList<Integer> list, int sum, int K, int arr[], int n, Set<String> set) {
        if (idx == n) {
            if (sum == K) {
                String key = list.toString(); // Convert list to string as a unique identifier
                if (!set.contains(key)) {
                    set.add(key); // Mark this sequence as printed
                    System.out.println(list);
                }
            }
            return;
        }

        // Include the current element
        list.add(arr[idx]);
        sum += arr[idx];
        printSubSequences(idx + 1, list, sum, K, arr, n, set);

        // Backtrack
        list.remove(list.size() - 1);
        sum -= arr[idx];

        // Exclude the current element
        printSubSequences(idx + 1, list, sum, K, arr, n, set);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr1[] = {1, 2, 4, 2, 3, 5, 3, 2, 6};
        int n1 = arr1.length;

        int arr2[] = {1, 2, 4, 3, 5, 3, 6};
        int n2 = arr2.length;

        int arr3[] = {1, 2, 3};
        int n3 = 3;

        int sum = 0;
        int K = 6;
        Set<String> set = new HashSet<>(); // Store unique subsequences

        printSubSequences(0, list, sum, K, arr3, n3, set);
    }
}
