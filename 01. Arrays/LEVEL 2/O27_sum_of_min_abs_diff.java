import java.util.*;;

/*
    Take a variable say result = Integer.MAX_VALUE, to hold the required minimum sum.
    Run an outer loop from index 0 to n,
    Create a variable say sum = 0,
    Run an inner loop from index 0 to n,
    Set, sum += Math.abs(arr[i]-arr[j])
    After complete iteration of inner loop set,
    result = Math.min(result, sum).
    Print result.
 */

public class O27_sum_of_min_abs_diff {
    
    static int sumOfMinAbsDifferences(int arr[], int n) {

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(arr[i] - arr[j]);
            }

            result = Math.min(sum, result);
        }

        return result;
    }

    static int sumOfMinAbsDifferences2(int arr[], int n) {

        // sort the given array
        Arrays.sort(arr);

        // initialize sum
        int sum = 0;

        sum += Math.abs(arr[0] - arr[1]);

        sum += Math.abs(arr[n - 1] - arr[n - 2]);

        for (int i = 1; i < n - 1; i++)
            sum += Math.min(Math.abs(arr[i] - arr[i - 1]), Math.abs(arr[i] - arr[i + 1]));

        // required sum
        return sum;
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 2, 4, 5, 3 };
        int n = arr.length;

        System.out.println("(1) Required Minimum Sum is " + sumOfMinAbsDifferences(arr, n));
        System.out.println("(2) Required Minimum Sum is " + sumOfMinAbsDifferences2(arr, n));
    }
}
