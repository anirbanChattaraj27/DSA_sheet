// LC 167 [2 pointer]
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
/*
Input: numbers = [2,7,11,15], target = 9 Sorted input
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
*/

public class O2_2SUM_2 {
    public int[] twoSum(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        int[] temp = new int[2]; 
        
        while (left < right) {
            int currentSum = arr[left] + arr[right]; // Calculate the combined sum

            if (currentSum == sum) {
                temp[0] = left + 1; // 1-indexed for LeetCode 167
                temp[1] = right + 1;
                break;
            } 
            else if (currentSum < sum) {
                left++;  // Combined sum is too small -> make it bigger
            } 
            else {
                right--; // Combined sum is too large -> make it smaller
            }
        }
            
        return temp;
    }
}
