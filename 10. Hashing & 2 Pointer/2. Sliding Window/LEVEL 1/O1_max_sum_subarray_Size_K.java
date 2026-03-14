// i/p -> {2, 1, 5, 1, 3, 2}, k = 3
// o/p -> 9
// Explain -> 5+1+3 largest k size window sum is 9

public class O1_max_sum_subarray_Size_K {

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

    // striver
    public static int getSumSizeK_Window2(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            System.out.println("Invalid input: Array size is smaller than k");
            return -1;
        }

        int left = 0;
        int right = k - 1;
        int sum = 0;

        // Calculate the initial window sum
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Sliding window using while loop
        while (right < n - 1) {
            sum = sum - arr[left];
            left++;
            right++;
            sum = sum + arr[right];
            maxSum = Math.max(maxSum, sum);
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
