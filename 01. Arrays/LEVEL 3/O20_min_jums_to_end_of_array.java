
/*
 * problem link -->  https://leetcode.com/problems/jump-game-ii/

 * time--> O(n)
 * space--> O(1)
 * 
 * YT --> https://www.youtube.com/watch?v=Yrw3MNh_368
 */

public class O20_min_jums_to_end_of_array {

	public static int jump(int[] arr) {

		int countJump = 0;
		int position = 0;
		int destiny = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			destiny = Math.max(destiny, arr[i] + i);

			if (position == i) {
				position = destiny;
				countJump++;
			}
		}
		return countJump;
	}

	public static void main(String[] args) {
		// TODO a-generated method stub
		int arr[] = { 2, 1, 3, 2, 4, 3, 5, 1, 2, 8 };
		System.out.println("Minimum number of jumps to reach end is : " + jump(arr));
	}

}
