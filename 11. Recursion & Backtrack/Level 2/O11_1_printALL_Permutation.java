// leetCode 46: https://leetcode.com/problems/permutations/description/
// copy: 8
/*
You can return the listOfListwer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */

import java.util.*;

class O11_1_printALL_Permutation {
    private void recurPermute(int[] nums, List<Integer> list, List<List<Integer>> listOfList, boolean[] freq) {

        if (list.size() == nums.length) { // when list size and arr size will become same then will 
            listOfList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                list.add(nums[i]);
                recurPermute(nums, list, listOfList, freq);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums, list, listOfList, freq);
        return listOfList;
    }

    public static void main(String[] args) {
        O11_1_printALL_Permutation obj = new O11_1_printALL_Permutation();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }
}
