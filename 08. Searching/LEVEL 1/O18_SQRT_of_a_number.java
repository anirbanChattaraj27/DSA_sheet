


/*
 * https://leetcode.com/problems/sqrtx/description/

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
 */

public class O18_SQRT_of_a_number {

    // Striver || L.S.
    public static int floorSqrt1 (int n) {
        int ans = 0;
        // linear search on the answer space
        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= (long) n) {
                ans = (int) i;
            } 
            else { // when value will be greated than n then loop will break and prev value will be stored
                break;
            }
        }
        return ans;
    }

    public static int floorSqrt2(int n) {
        int ans = (int) Math.sqrt(n);
        return ans;
    }

    // Striver || B.S.
    public static int floorSqrt3(int n) {
        int low = 1, high = n;
        
        //Binary search on the answers:
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= (long)(n)) {
                //eliminate the left half:
                low = (int)(mid + 1);
            } else {
                //eliminate the right half:
                high = (int)(mid - 1);
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int n = 18;
        int ans = floorSqrt3(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
}


