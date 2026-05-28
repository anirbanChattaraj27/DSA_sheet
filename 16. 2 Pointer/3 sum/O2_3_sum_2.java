// All Triplets with Given Sum 
// All Distinct Triplets with given Sum in an Array
// https://www.geeksforgeeks.org/dsa/unique-triplets-sum-given-value/


// Java program to find all the distinct triplets having sum
// equal to target using two pointer technique

import java.util.*;

public class O2_3_sum_2 {

    // 2 pointer
    static List<List<Integer>> threeSum(int[] arr, int target) {

        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
          
            // Skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Two pointer technique
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    List<Integer> curr = Arrays.asList(arr[i], arr[j], arr[k]);
                    res.add(curr);
                    j++;
                    k--;

                    // Skip duplicates for j and k
                    while (j < n && arr[j] == arr[j - 1]) j++;
                    while (k > j && arr[k] == arr[k + 1]) k--;
                } 
              	else if (sum < target) { 
                    j++;
                }
              	else { 
                    k--;
                }
            }
        }
        return res;
    }

    // HASH
    static List<List<Integer>> threeSum2(int[] arr, int target) {

        int n = arr.length;
        
        // Set to handle duplicates
        Set<List<Integer>> resSet = new HashSet<>();
        
        // Generating all pairs
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = target - arr[i] - arr[j];
                
                // If the complement exists in the hash set then we 
                // have found the triplet with sum, target
                if (s.contains(complement)) {
                    List<Integer> curr = Arrays.asList(arr[i], arr[j], complement);
                    Collections.sort(curr);
                    resSet.add(curr);
                }
                
                s.add(arr[j]);
            }
        }

        return new ArrayList<>(resSet);
    }


    public static void main(String[] args) {
        int[] arr = {12, 3, 6, 1, 6, 9};
        int target = 24;

        List<List<Integer>> ans = threeSum(arr, target);
        for (List<Integer> triplet : ans) {
            System.out.println(triplet.get(0) + " " + triplet.get(1) + " " + triplet.get(2));
        }
    }
}