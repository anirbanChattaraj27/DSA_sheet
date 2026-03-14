// longest substring length withount repeated charecter

// same as Longest consecutive array sequence [go subArray folder its 1st qs]
/*
 * i/p = abcbcacbacab
 * o/p = 3
 * 
 * i/p = abcddcbaacbbca
 * o/p = 4
 */

 // POINT: Longest consecutive subSequence is-> sort array then find consecutive characteres
 //        Longest consecutive subString -> dont sort array its window based problem

import java.util.*;

public class O9_longest_substring_length {
    public static int longestConsecutive1(String str) { // 1 method // O(nlogn)

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        // Storing length of longest consecutive sequence.
        int mx = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // Check if the previous value is consecutive to the current value.
            if (i > 0 && (arr[i] == arr[i - 1] + 1)) {
                count++;
            }

            // Skip if the current value is equal to the previous value.
            else if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            // Resetting count for next upcoming consecutive sequence.
            else {
                count = 1;
            }
            mx = Math.max(mx, count);
        }
        return mx;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println("Length of the Longest contiguous subsequence is " + longestConsecutive1(s));
    }
}