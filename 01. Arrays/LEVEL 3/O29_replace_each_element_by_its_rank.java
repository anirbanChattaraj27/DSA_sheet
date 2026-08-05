/*

LC 1331: https://leetcode.com/problems/rank-transform-of-an-array/description/

Replace Elements by Their Rank

Input:  20 15 26 2 98 6
Output: 4  3  5  1 6  2
Explanation: When sorted,the array is 2,6,15,20,26,98. So the rank of 2 is 1,rank of 6 is 2,rank of 15 is 3 and so.

Input:  1 5 8 15 8 25 9
Output: 1 2 3 5  3 6  4
Explanation :When sorted,the array is 1,5,8,8,9,15,25. So the rank of 1 is 1,rank of 5 is 2,rank of 8 is 3 and so.

 */

import java.util.*;

public class O29_replace_each_element_by_its_rank {

    // Brute Force
    static void replaceWithRank(int[] arr) {

        int n = arr.length;
        int[] res = new int[n];

        // For each value
        for (int i = 0; i < n; i++) {
            int rank = 0;
            for (int j = 0; j < n; j++) {
      
                // Count all elements smaller than arr[i]
                if (arr[j] < arr[i]) {
                    rank++;
                } // For equal elements, count only those appearing before the current index
                else if (arr[j] == arr[i] && j < i) {
                    rank++;
                }
            }
            res[i] = rank; // Rank of current element
        }

        // Replace array elements with their ranks
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }
    }

    public static int[] replaceWithRank2(int[] arr) {

        int[] temp = arr.clone();

        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;
 
        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {20, 15, 26, 2, 98, 6};

        System.out.println(Arrays.toString(replaceWithRank2(arr)));
    }
}

/*
Original Array
       │
       ▼
Clone the array
       │
       ▼
Sort the cloned array
       │
       ▼
Assign ranks to unique numbers using a HashMap
       │
       ▼
Traverse the original array
       │
       ▼
Replace each number with its rank from the HashMap
       │
       ▼
Return the updated array
*/
