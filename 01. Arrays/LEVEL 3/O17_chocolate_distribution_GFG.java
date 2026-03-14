

//https://www.geeksforgeeks.org/chocolate-distribution-problem/

//Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
//Output: Minimum Difference is 6 
//Explanation:
//The set goes like 3,4,7,9,9 and the output 
//is 9-3 = 6



import java.util.Arrays;

public class O17_chocolate_distribution_GFG {

	static int findMinDiff(int arr[], int n, int m) {

		if (m == 0 || n == 0)
			return 0;

		Arrays.sort(arr);

		if (n < m)
			return -1;

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i + m - 1 < n; i++) {
			int min = arr[i];
			int max = arr[i+m-1];
			int gap = max - min;
			
			if(gap < ans) {
				ans = gap;
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 7, 9, 9, 12, 56 };
		int m = 5;  // Number of students
		
		System.out.println("Minimum difference is " + findMinDiff(arr, arr.length, m));
	
	}
}
