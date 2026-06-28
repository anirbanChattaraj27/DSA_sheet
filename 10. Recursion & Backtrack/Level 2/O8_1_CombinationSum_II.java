// leetcode 40: https://leetcode.com/problems/combination-sum-ii/
// copy 5

/*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.
 */
import java.util.*;

public class O8_1_CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        fun(0, ans, list, candidates, target, 0, candidates.length);
        return ans;
    }

    public void fun(int idx, List<List<Integer>> ans, List<Integer> list, int arr[], int target, int sum, int n){

        if(target == sum){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<n; i++){
            if(i > idx && arr[i-1] == arr[i]) continue;
            if(arr[i] > target) break;
            if(sum + arr[i] > target) break; 

            list.add(arr[i]);
            fun(i+1, ans, list, arr, target, sum+arr[i], n);

            list.remove(list.size()-1);
        }
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
