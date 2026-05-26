// https://practice.geeksforgeeks.org/p roblems/count-pairs-with-given-sum5022/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
// https://www.geeksforgeeks.org/dsa/count-pairs-with-given-sum/
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

    // hash
    static int usingMap2(int arr[], int n, int sum) {

        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            if (m.containsKey(sum - arr[i])) {
                count += m.get(sum - arr[i]);   
            }
        }
        return count;
    }

    // 2 pointer
    public int countPairs3(List<Integer> nums, int target) {
        Collections.sort(nums);
        
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {
                left++; // Sum is too small -> move left up to get a bigger number
            } else if (sum > target) {
                right--; // Sum is too big -> move right down to get a smaller number
            } else {
                // MATCH FOUND! (sum == target)
                
                // Case A: All remaining elements between pointers are identical (e.g., [3, 3, 3], target=6)
                if (nums.get(left).equals(nums.get(right))) {
                    int elements = right - left + 1;
                    count += (elements * (elements - 1)) / 2;
                    break; 
                }
                
                // Case B: Count duplicates on the left side
                int leftVal = nums.get(left);
                int leftCount = 0;
                while (left <= right && nums.get(left) == leftVal) {
                    leftCount++;
                    left++;
                }
                
                // Count duplicates on the right side
                int rightVal = nums.get(right);
                int rightCount = 0;
                while (right >= left && nums.get(right) == rightVal) {
                    rightCount++;
                    right--;
                }
                
                // Multiply left duplicates by right duplicates to get all pair combinations
                count += (leftCount * rightCount);
            }
        }
        
        return count;
    }

    public static void main(String args[]) {
        int[] arr = { 10, 2, 15, 2, 9, 1, 3, 10, 9, 4}; // it can make 4 pairs [(10,3), (10,3), (9,4), (9,4)]
        int sum = 13;
        System.out.println("count using MAP ->" + usingMap2(arr, arr.length, sum));
        getPairsCount1 (arr, sum);
    }
}
