
// leetcode 90: https://leetcode.com/problems/subsets-ii/
// copy: 7
/*
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
*/
  
import java.util.*;

public class O10_subSet_II {
    public void findSubsets(int ind, int[] nums, List<Integer> list, List<List<Integer>> ListOfList) {

        ListOfList.add(new ArrayList<>(list));

        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            findSubsets(i + 1, nums, list, ListOfList);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // without sorting the list i cant get whether duplicate elements are present or not "if (i != ind && nums[i] == nums[i - 1]) continue"
        List<List<Integer>> ListOfList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ListOfList);
        return ListOfList;
    }

    public static void main(String[] args) {
        O10_subSet_II obj = new O10_subSet_II();
        int[] nums = {1, 2, 2}; // Example input
        List<List<Integer>> result = obj.subsetsWithDup(nums);
        
        System.out.println("Unique Subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
