

import java.util.*;

public class O1_koko_eating_bananas {

    // Function to find maximum element in array
    static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    // Function to calculate total hours needed at given eating rate
    static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;

        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) v[i] / (double) hourly);
        }
        return totalH;
    }

    // Function to find minimum eating rate
    static int minimumRateToEatBananas(int[] v, int h) {
        int low = 1;
        int high = findMax(v);

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(v, mid);

            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] bananas = {3,6,7,11};

        int h = 8;

        int result = minimumRateToEatBananas(bananas, h);
        System.out.println(result);

        sc.close();
    }
}
