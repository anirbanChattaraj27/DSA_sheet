// i/p -> {2, 1, 5, 1, 3, 2}, k = 3
// o/p -> 9
// Explain -> 5+1+3 largest k size window sum is 9

public class O1_I_max_sum_subarray_Size_K {

    public static int getSumSizeK_bruteForce(int arr[], int k) {

        // Declare a variable and assigned value 0
        int maxSum = 0;

        // Traverse an array from 0 to n-k
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;

            // Run a loop from i to i+k
            for (int j = i; j < i + k; j++) {
                sum = sum + arr[j];
            }

            // Keep track of maximum sum
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static int getSumSizeK_Window(int arr[], int k) {
        int start = 0;
        int sum = 0;
        int maxSum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum = sum + arr[end];

            if (end >= k - 1) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - arr[start];
                start++;
            }
        }
        return maxSum;
    }


    static int getSumSizeK_Window2(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        // compute sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k]; // basically i am subtracting 1st element of array and adding next element of array || K' value is constant and "i" keeps changing its value || 1st iteration: 4-4 || 2nd iteration: 5-4 ||
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    
    public static void main(String[] args) {

        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        int result = getSumSizeK_Window(arr, k);
        System.out.println(result);

        int result2 = getSumSizeK_Window2(arr, k);
        System.out.println(result2);
    }
}
