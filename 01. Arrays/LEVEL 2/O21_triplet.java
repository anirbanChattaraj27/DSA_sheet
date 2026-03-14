// Java program to find a triplet using Hashing
// https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/

/*
Approach: This approach uses extra space but is simpler than the two-pointers approach. Run two loops outer loop from start to end and inner loop from i+1 to end. Create a hashmap or set to store the elements in between i+1 to j-1. So if the given num is x, check if there is a number in the set which is equal to x – arr[i] – arr[j]. If yes print the triplet. 
 
Algorithm: 
Traverse the array from start to end. (loop counter i)
Create a HashMap or set to store unique pairs.
Run another loop from i+1 to end of the array. (loop counter j)
If there is an element in the set which is equal to x- arr[i] – arr[j], then print the triplet (arr[i], arr[j], x-arr[i]-arr[j]) and break
Insert the jth element in the set.

*/
  
/*
 * LOOK->
 * two pointer approches are aviailable in the above link
 */

import java.util.*;

class O21_triplet {

	static boolean find3Numbers(int A[], int arr_size, int sum) {

		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Fix the second element as A[j]
			for (int j = i + 1; j < arr_size - 1; j++) {

				// Now look for the third number
				for (int k = j + 1; k < arr_size; k++) {
					if (A[i] + A[j] + A[k] == sum) {
						System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
						return true;
					}
				}
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

	// returns true if there is triplet
	// with sum equal to 'sum' present
	// in A[]. Also, prints the triplet
	static boolean usingHash(int A[], int arr_size, int num) {
		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray A[i+1..n-1]
			// with sum equal to sum - A[i]
			HashSet<Integer> s = new HashSet<Integer>();
			int sum = num - A[i];
			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(sum - A[j])) {
					System.out.printf("Triplet is %d, %d, %d", A[i], A[j], sum - A[j]);
					return true;
				}
				s.add(A[j]);
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

	/* Driver code */
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int num = 22;
		int arr_size = A.length;

		find3Numbers(A, arr_size, num);
	}
}
