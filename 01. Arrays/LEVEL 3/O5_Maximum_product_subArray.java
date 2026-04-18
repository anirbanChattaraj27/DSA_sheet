/* LEETCODE: 152

https://leetcode.com/problems/maximum-product-subarray/description/

Given an array arr[] consisting of positive, negative, and zero values, find the maximum product that can be obtained from any contiguous subarray of arr[].

Examples:

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.

Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.

Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
*/ 

public class O5_Maximum_product_subArray{
   
    public int maxProductSubArray(int[] arr) {
            // Get the length of the array
            int n = arr.length;

            // Initialize prefix and suffix product
            int pre = 1, suff = 1;

            // Initialize answer with smallest integer
            int ans = Integer.MIN_VALUE;

            // Traverse from both left and right
            for (int i = 0; i < n; i++) {
                // Reset prefix if zero
                if (pre == 0) pre = 1;

                // Reset suffix if zero
                if (suff == 0) suff = 1;

                // Multiply prefix with current element from front
                pre *= arr[i];

                // Multiply suffix with current element from back
                suff *= arr[n - i - 1];

                // Update maximum value so far
                ans = Math.max(ans, Math.max(pre, suff));
            }

            // Return the final result
            return ans;
        }
    }

    // Separate Main class for testing
class Main {
    public static void main(String[] args) {
        // Sample input
        int[] arr = {2, 3, -2, 4};

        // Create object of Solution
        O5_Maximum_product_subArray obj = new O5_Maximum_product_subArray();

        // Call the method and print the result
        System.out.println(obj.maxProductSubArray(arr));
    }
}
