
// chatGPT code
// combination sum 2 is exactly same....
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

    // here I am using sum + arr[i] instead of target - arr[i]
    public static void printSubSequences2(int idx, ArrayList<Integer> list, int sum, int K, int arr[], int n) {
        // Base Case: If target sum is reached, print and return
        if (sum == K) {
            System.out.println(list);
            return;
        } 
        
        // Base Case: If sum exceeds K (only works for positive numbers) or out of bounds
        if (idx == n || sum > K) {
            return;
        }

        for (int i = idx; i < n; i++) {
            // Skip duplicate elements at the same recursion level
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }

            // Include the current element
            list.add(arr[i]);
            printSubSequences2(i + 1, list, sum + arr[i], K, arr, n);

            // Backtrack
            list.remove(list.size() - 1);
        }
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
        printSubSequences2(0, list, sum, K, arr3, n3); 
    }
}
