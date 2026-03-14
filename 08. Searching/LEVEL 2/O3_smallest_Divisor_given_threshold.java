// copy: 3
public class O3_smallest_Divisor_given_threshold {

    // Function to compute sum of ceil(arr[i] / div)
    static int sumByD(int[] arr, int div) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (int) Math.ceil((double) arr[i] / (double) div);
        }

        return sum;
    }

    // Binary search to find smallest divisor
    static int smallestDivisor(int[] arr, int limit) {

        int n = arr.length;
        if (n > limit) return -1;

        int low = 1;
        int high = Integer.MIN_VALUE;

        // find max element
        for (int x : arr) {
            high = Math.max(high, x);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sumByD(arr, mid) <= limit) {
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
        int[] arr = {1, 2, 5, 9};
        int limit = 6;

        int result = smallestDivisor(arr, limit);
        System.out.println("Smallest divisor: " + result);
    }
}
