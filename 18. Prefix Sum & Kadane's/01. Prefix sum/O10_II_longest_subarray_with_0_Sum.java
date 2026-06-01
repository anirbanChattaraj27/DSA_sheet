/*
Example 1:
Input: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!
 */ 

import java.util.HashMap;
import java.util.Map;

public class O10_II_longest_subarray_with_0_Sum {

    public static int maxLen1(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; ++i) {
            int sum = 0;
            for (int j = i; j < a.length; ++j) {
                sum += a[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

	// TC & SC -> O(N)
    public static int maxLen2(int A[], int n) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += A[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (map.get(sum) != null) {

                    maxi = Math.max(maxi, i - map.get(sum));
                } else {

                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }

    // another approch
    // TC & SC -> O(N)
    public static int maxLength(int[] arr) {
        int n = arr.length;

        // prefixSum -> first index
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // insert prefix sum 0 at index -1
        // to handle sum from start
        firstSeen.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // prefix sum has been seen before
            if (firstSeen.containsKey(prefixSum)) {
                int prevIndex = firstSeen.get(prefixSum);
                int length = i - prevIndex;
                maxLen = Math.max(maxLen, length);
            } else {
                
                // Store first occurrence of this prefix sum
                firstSeen.put(prefixSum, i);
            }
        }

        return maxLen;
    }


    public static void main(String args[]) {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(maxLen1(a));
        System.out.println(maxLen2(a, a.length));
    }
}
