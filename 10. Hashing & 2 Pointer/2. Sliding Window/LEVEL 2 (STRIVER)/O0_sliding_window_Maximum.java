// this is from stack chapter
// https://takeuforward.org/data-structure/sliding-window-maximum
// Java Program to find the maximum
// max from all subArr
// sliding window maximum

// convert bellow code in python?

// Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
// Output: 3 3 4 5 5 5 6
// Explanation: Maximum of 1, 2, 3 is 3
            //  Maximum of 2, 3, 1 is 3
            //  Maximum of 3, 1, 4 is 4
            //  Maximum of 1, 4, 5 is 5
            //  Maximum of 4, 5, 2 is 5 
            //  Maximum of 5, 2, 3 is 5
            //  Maximum of 2, 3, 6 is 6

public class O0_sliding_window_Maximum {

    // this is better way i think but use both functions in leetcode and check all test cases passes or not
    static void printKMax(int arr[], int n, int k) {
        
        int max = arr[0];
        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
                // if (arr[j] > max) {
                //     max = arr[j];
                // }
            }
            System.out.print(max + " ");
        }
    }

    // if qs says to return array
	public static void maxSlidingWindow(int[] nums, int n, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            // return new int[0];
            System.out.println("null");
        } 

        int[] maxes = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            maxes[i] = max;
            System.out.print(maxes[i] + " "); // i just use this to print the array but if qs says return array dont write this write bellow line
        }
        // return maxes;
    }

    

    // Driver's code
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int K = 3;

        // Function call
        printKMax(arr, arr.length, K);
        System.out.println();
        maxSlidingWindow(arr, arr.length, K);
        
    }
}
