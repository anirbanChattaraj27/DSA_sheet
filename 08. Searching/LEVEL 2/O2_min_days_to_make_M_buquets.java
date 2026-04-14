// copy: 2



public class O2_min_days_to_make_M_buquets {

    // Checks if it is possible to make m bouquets
    // each bouquet needs k consecutive flowers
    // that bloom on or before 'day'
    static boolean possible(int[] arr, int day, int m, int k) {
        int cnt = 0;
        int noOfB = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }

        // Count remaining flowers
        noOfB += (cnt / k);

        return noOfB >= m;
    }

    // Binary search to find minimum day
    static int roseGarden(int[] arr, int r, int b) {
        long val = (long) r * b;
        if (val > arr.length) return -1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int x : arr) {
            mini = Math.min(mini, x);
            maxi = Math.max(maxi, x);
        }

        int low = mini;
        int high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(arr, mid, r, b)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Main method with direct input
    public static void main(String[] args) {

        // Direct input (no Scanner)
        int[] arr = {1, 10, 3, 10, 2};
        int r = 3;   // number of bouquets
        int b = 1;   // flowers per bouquet

        int result = roseGarden(arr, r, b);
        System.out.println("Minimum days required: " + result);
    }
}
