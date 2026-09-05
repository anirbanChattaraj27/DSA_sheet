/* when COUNT is there, there are 2 types of question
    1. count pair with given sum || with 0 sum
    2.count pair with less than or equal to target || greater than or equal to target
        a) count pairs < target
        b) count pairs <= target
        c) count pairs > target
        d) count pairs >= target
*/
// can be saolved using hash and 2 pointer

import java.util.*;
import java.util.List;

public class O3_II_print_pair_with_0_sum {

    public static List<List<Integer>> countPairs(int[] arr, int target) {

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {

            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {

                List<Integer> list = new ArrayList<>();

                list.add(arr[left]);
                list.add(arr[right]);
                ans.add(list); // adding each list in listOfList

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

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 0;

        List<List<Integer>> pairs = countPairs(arr, target);

        System.out.println("Pairs with sum 0:");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }

}
