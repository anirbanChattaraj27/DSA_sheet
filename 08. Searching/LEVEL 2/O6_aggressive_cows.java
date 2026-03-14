// copy: 6


import java.util.*;

public class O6_aggressive_cows {

    // Function to check if we can place 'cows' with at least 'dist' distance
    static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1;              // first cow placed at first stall
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows) {
                return true;
            }
        }
        return false;
    }

    // Function to find the largest minimum distance
    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canWePlace(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stalls ={0, 3, 4, 7, 10, 9};

        int k = 4;

        int result = aggressiveCows(stalls, k);
        System.out.println(result);

        sc.close();
    }
}
