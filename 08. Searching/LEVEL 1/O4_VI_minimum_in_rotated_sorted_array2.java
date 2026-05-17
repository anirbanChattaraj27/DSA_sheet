/*
leetcode 154. Find Minimum in Rotated Sorted Array II
leetcode: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/?envType=daily-question&envId=2026-05-16
*/


public class O4_VI_minimum_in_rotated_sorted_array2 {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int mini = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end - start) / 2;

            mini = Math.min(mini, arr[mid]);

            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                mini = Math.min(mini, arr[mid]);
                start++;
                end--;
            }

            else if(arr[start] <= arr[mid]){
                mini = Math.min(mini, arr[start]);
                start = mid +1;
            }
            else {
                mini = Math.min(mini, arr[mid]);
                end = mid - 1;
            }
            
        }
        return mini;   
    }
}