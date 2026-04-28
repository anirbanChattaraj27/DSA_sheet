// print all subArrays with 0 sum{
// Java program to find
// if there is a zero sum subarray

// Input: {4, 2, -3, 1, 6}
// Output: true 
// Explanation:
// There is a subarray with zero sum from index 1 to 3.

// Input: {4, 2, 0, 1, 6}
// Output: true
// Explanation: The third element is zero. A single element is also a sub-array.

// Input: {-3, 2, 3, 1, 6}
// Output: false


import java.util.HashSet;
import java.util.Set;

class O7_getPair_with_0_sum {

	// Returns true if arr[] has a subarray with sero sum
	static Boolean subArrayExists(int arr[]) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0 || sum == 0 || set.contains(sum))
				return true;
				
			set.add(sum);
		}

		// We reach here only when there is no subarray with 0 sum
		return false;
	}

	// Driver's code
	public static void main(String arg[])
	{
		int arr[] = {4, 2, -3, 1, 6};

		// Function call
		if (subArrayExists(arr))
			System.out.println("Found a subarray with 0 sum");
		else
			System.out.println("No Such Sub Array Exists!");
	}
}
