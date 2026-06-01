// Count Triplets with Smaller Sum
// https://www.geeksforgeeks.org/dsa/count-triplets-with-sum-smaller-than-a-given-value/

import java.util.Arrays;

public class O4_triplet_with_smaller_sum {

    static int countTriplets(int sum, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            
            int j = i + 1, k = n - 1;

            while (j < k) {

                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--; 
                }
                
                else {
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }
}
