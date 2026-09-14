
// can be saolved using hash and 2 pointer, same as 2 sum, target = 0 assume
import java.util.*;

public class O3_I_count_pairs_with_0_sum {

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

    // 2 pointer || TC: nlogn || SC: O(1)
    // assume target = 0 or any number
    public int countPairs(int[] arr, int target) { 

        Arrays.sort(arr); // Sort the array first

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {

            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                count++;
                left++;
                right--;
            } 
            
            else if (currentSum < target) {
                left++;
            } 
            
            else {
                right--;
            }
        }

        return count;
    }

    // hash---> TC: n || SC: n
    // it handles duplicate element in qs as well, if we have 2 same element in array then it will count them as well
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
}
