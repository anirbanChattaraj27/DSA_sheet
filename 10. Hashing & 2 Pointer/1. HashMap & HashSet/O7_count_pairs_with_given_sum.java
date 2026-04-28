// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
// Input :
// arr[] = {1, 5, 7, -1}   sum = 6
// Output :2
// explain -> ( Pairs with sum 6 are (1, 5) and (7, -1) )

import java.util.*;

public class O7_count_pairs_with_given_sum {

    // Prints number of pairs in arr[0..n-1] with sum equa to 'sum'
    public static void getPairsCount1(int[] arr, int sum) {

        int count = 0; // Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;
        System.out.printf("Count pairs using LOOP is-> %d", count);
    } 

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

    public static void main(String args[]) {
        int[] arr = { 10, 2, 15, 2, 9, 1, 3, 10, 9, 4}; // it can make 4 pairs [(10,3), (10,3), (9,4), (9,4)]
        int sum = 13;
        System.out.println("count using MAP ->" + usingMap2(arr, arr.length, sum));
        getPairsCount1 (arr, sum);
    }
}
