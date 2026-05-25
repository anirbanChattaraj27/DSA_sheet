// leetcode 40
// copy 5

/*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.
 */
import java.util.*;

public class O8_1_CombinationSum_II {

    private void findCombinations(int idx, int[] arr, int target, List<List<Integer>> LitOfList, List<Integer> list) {
        if (target == 0) {
            LitOfList.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue; // i > idx = ?? // arr[i] == arr[i - 1] = Skip duplicates | if it is repated element i am not gonna pick i will skip this
            if (arr[i] > target) break; // No need to continue if current number exceeds target

            list.add(arr[i]); // here i am adding arr[i] not arr[idx] that is why in next line i will increase i with i+1 not idx+1
            findCombinations(i + 1, arr, target - arr[i], LitOfList, list); // here increase i with i+1 not idx+1
            list.remove(list.size() - 1); // Backtracking step
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> LitOfList = new ArrayList<>();
        Arrays.sort(candidates); // Sorting to handle duplicates
        findCombinations(0, candidates, target, LitOfList, new ArrayList<>());
        return LitOfList;
    }

    public static void main(String[] args) {
        O8_1_CombinationSum_II obj = new O8_1_CombinationSum_II();

        int[] candidates = {1,1,1,2,2};
        int target = 4;
        System.out.println(obj.combinationSum2(candidates, target));  // here i can NOT take same idx value twice or thrice; 1 idx value can be used once 

        System.out.println();

        int[] candidates2 = {10, 1, 2, 7, 6, 1, 5};
        int target2 = 8;
        List<List<Integer>> result = obj.combinationSum2(candidates2, target2);
        
        System.out.println(result);
    }
}
