// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
// Input :
// arr[] = {1, 5, 7, -1}   sum = 6
// Output :2
// explain -> ( Pairs with sum 6 are (1, 5) and (7, -1) )
// HASH

import java.util.*;

public class O4_II_count_pairs_with_given_sum {

    // brute
    public static void getPairsCount1(int[] arr, int sum) {

        int count = 0; // Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;
        System.out.printf("Count pairs using LOOP is-> %d", count);
    } 

    // hash---> TC: n  || SC: n
     static int countPairsMAP(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
          
            // Check if the complement (target - arr[i])
            // exists in the map. If yes, increment count
            if (map.containsKey(target - arr[i])) {
                cnt += map.get(target - arr[i]); 
            }
          
            // Increment the mapuency of arr[i]
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
        }
        return cnt;
    }

    // 2 pointer--> TC: nlogn and SC: O(1)
    static int countPairs2Pointer(int[] arr, int target) {
        int res = 0;
        int n = arr.length;
        int left = 0, right = n - 1;

        // Sort the array before applying 
        // two-pointer technique
        Arrays.sort(arr);

        while (left < right) {

            // If sum is less than target
            if (arr[left] + arr[right] < target) {
                left++;
            }

            // If sum is more than target
            else if (arr[left] + arr[right] > target) {
                right--;
            }

            // If sum is equal to target
            else {
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];

                // Count mapuency of first element
                while (left <= right && arr[left] == ele1) {
                    cnt1++;
                    left++;
                }

                // Count mapuency of second element
                while (left <= right && arr[right] == ele2) {
                    cnt2++;
                    right--;
                }

                // If both elements are same
                if (ele1 == ele2) {
                    res += (cnt1 * (cnt1 - 1)) / 2;
                } else {
                    res += cnt1 * cnt2;
                }
            }
        }

        return res;
    }

    public static void main(String args[]) {
        int[] arr = { 10, 2, 15, 2, 9, 1, 3, 10, 9, 4}; // it can make 4 pairs [(10,3), (10,3), (9,4), (9,4)]
        int sum = 13;
    }
}
