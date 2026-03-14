/* print how many sub sequesnce it can form with K=6 */

import java.util.ArrayList;

public class O6_print_count_of_subSequences {

    public static int printCount1(int idx, ArrayList<Integer> list, int sum, int K, int arr[], int n) {

        if (idx == n) {
            if (sum == K) {
                return 1;
            }
            return 0;
        }

        int count = 0;

        // TAKE the element
        list.add(arr[idx]);
        sum += arr[idx];
        count += printCount1(idx + 1, list, sum, K, arr, n);

        // BACKTRACK
        sum -= arr[idx];
        list.remove(list.size() - 1);

        // NOT TAKE the element
        count += printCount1(idx + 1, list, sum, K, arr, n);

        return count;
    }

    public static int printCount2(int idx, int sum, int K, int arr[], int n) {
        if (idx == n) {
            if (sum == K) {
                return 1;
            } else {
                return 0;
            }
        }

        sum += arr[idx];
        int leftCount = printCount2(idx + 1, sum, K, arr, n);

        sum -= arr[idx];
        int rightCount = printCount2(idx + 1, sum, K, arr, n);

        return leftCount + rightCount;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 4, 3, 5, 3, 6};
        int n = arr.length;
        int K = 6;

        // Method 1: Using list (can also print subsequences if needed)
        ArrayList<Integer> list = new ArrayList<>();
        int count1 = printCount1(0, list, 0, K, arr, n);
        System.out.println("Count using printCount1: " + count1);

        // Method 2: Without extra list (best for counting only)
        int count2 = printCount2(0, 0, K, arr, n);
        System.out.println("Count using printCount2: " + count2);

    }
}
