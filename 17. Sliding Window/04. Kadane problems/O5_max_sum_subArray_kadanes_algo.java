
//https://leetcode.com/problems/maximum-subarray/

// follow up question for kadane's algo: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/

// maximum sum subArray
// kadane's algorithm
// kadane algorithm

/*
	Example 1:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	
	Example 2:
	Input: nums = [1]
	Output: 1
	
	Example 3:
	Input: nums = [5,4,-1,7,8]
	Output: 23
*/

/*
 * algorithm:
 * 			So, for maximum sum subarray i need pair of elements from the array which will be the maximum from all the elements.
 * 			For this i need 2 loops, 1 will travarse hole array and 2nd will travarse from i to length of array and i need a variable maxSum which will be 0 initially and I need another variable sum which is also 0 initially after that if sum will be increment with subarrays total sum and if maxSum > sum then print maxSum
 * */



public class O5_max_sum_subArray_kadanes_algo {

	// O(n^2)
	public static int sumSubArray(int[] arr) {
		
		int maxSum = 0;
		for(int i=0; i<arr.length; i++) {
			int sum = 0;
			for(int j=i; j<arr.length; j++) {
				sum += arr[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	// O(n) // kadane's algo
	public static int sumSubArray2(int[] arr) {
		int sum = 0;
		int max = Integer.MIN_VALUE;	
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			max = Math.max(sum, max);
			
			if(sum < 0) {
				sum = 0;
			}
		}
		
		return max;
	}
	
	// maximum product subarray
	static int maxProductArray(int arr[]){
		int sum = 1;
		int max = 1;	
		
		for(int i=0; i<arr.length; i++) {
			sum *= arr[i];
			max = Math.max(sum, max);
			
			if(sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int arr[] = {5,4,-1,7,8};
		
		// sumSubArray(arr);
		
        System.out.print(sumSubArray(arr));
		System.out.println();
        System.out.print(sumSubArray2(arr));
        // System.out.print(maxProductArray(arr));
	}
}
