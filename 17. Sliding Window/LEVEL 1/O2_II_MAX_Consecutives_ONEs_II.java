// https://leetcode.com/problems/max-consecutive-ones-iii/description/
/*
 * arr[] = [1 1 1 0 0 0 1 1 1 1 0], K = 2
 * o/p: 6
 * explain: i can flip at most K zeroes to maximize the number of consecutive ones. 
 * from index 5 to 10 length is 6 and I am flipping 2 zeros
 */

public class O2_II_MAX_Consecutives_ONEs_II {
    static int maxOnes1(int[] arr, int k) {
        int res = 0;

        // Exploring all subarrays
        for(int i = 0; i < arr.length; i++) {
            
            // Counter for zeroes
            int cnt = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] == 0)
                    cnt++;
                
                // If cnt is less than or equal to k, then all zeroes can be flipped to one
                if(cnt <= k)
                    res = Math.max(res, (j - i + 1));
            }
        }
        return res;
    }

    static int maxOnes2(int[] arr, int k) {
        int res = 0;

        // Start and end pointer of the window
        int start = 0, end = 0;

        // Counter to keep track of zeros in current window
        int cnt = 0;

        while (end < arr.length) {
            if (arr[end] == 0)
                cnt++;

            // Shrink the window from left if no. of zeroes are greater than k
            while (cnt > k) { // USE "IF" insted of "WHILE" to reduce T.C.
                if (arr[start] == 0)
                    cnt--;
 
                start++;
            }

            res = Math.max(res, (end - start + 1));
          
            // Increment the end pointer to expand the window
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int k = 2;
        System.out.println(maxOnes1(arr, k));
        System.out.println(maxOnes2(arr, k));
    }
}
