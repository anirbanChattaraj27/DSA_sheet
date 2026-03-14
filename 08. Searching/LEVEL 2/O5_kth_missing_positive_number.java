// copy: 5

import java.util.*;

public class O5_kth_missing_positive_number {

    static int missingK(int[] vec, int n, int k) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] vec = {2, 3, 4, 7, 11};
        int n = vec.length;
        int k = 5;

        int result = missingK(vec, n, k);
        System.out.println(result);
    }
}
