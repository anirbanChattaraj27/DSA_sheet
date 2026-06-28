
// HOW THIS IS DIFFERENT FROM printSubSequence with K
// ans------> here i can take 1 number multiple times just like 2, I can take twice. So, to meet the target i can take any number any times to add upto target. 
// LOGIC----> 2 option is there for recursion 1 is take another one is dont take so for take condition i will  call function with same index [DON'T do idx+1]. this is for left side. Then next recursively calling so i will move the index by 1 [idx+1] then i will recursively do the qs for right side

// copy 4
// leetcode 39
// https://leetcode.com/problems/combination-sum/

/* 
    example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Example 2:
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:
    Input: candidates = [2], target = 1
    Output: []
*/

import java.util.*;

public class O7_CombinatioSUM {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fun(0,ans, list, 0, candidates, candidates.length, target);

        return ans;
    }

    public void fun(int idx, List<List<Integer>> ans, List<Integer> list, int sum, int arr[], int n, int target){

        if(sum > target) return;

        if (idx == n) {
            if(sum == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }           

        list.add(arr[idx]);
        sum = sum+arr[idx];
        fun(idx, ans, list, sum, arr, n, target);

        sum = sum - arr[idx];
        list.remove(list.size()-1);
        fun(idx+1, ans, list, sum, arr, n, target);
    }

    // 2nd way of solving
    private void findCombinations2(int idx, int[] arr, int target, List<List<Integer>> listOfList, List<Integer> list) {
        if (idx == arr.length) {
            if (target == 0) {
                listOfList.add(new ArrayList<>(list));
            }
            return;
        }

        if (arr[idx] <= target) { // here i am checking for left side if target is equal ofr less then i will continues searching on the same index i.e. left side
            list.add(arr[idx]);
            findCombinations2(idx, arr, target - arr[idx], listOfList, list); // i can take 1 element multiple times so idx is not idx+1
            list.remove(list.size() - 1); // when i will continues going with same index i may not get the target so i have to backtrack and then i have to remove last element from the list and next i have to search on the  other side ie. right side 
        }

        // if (arr[idx] > target) then i will check right side and here i will increase the index by 1 and previsou line i have removed last element from the LIST
        findCombinations2(idx + 1, arr, target, listOfList, list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listOfList = new ArrayList<>();
        findCombinations2(0, candidates, target, listOfList, new ArrayList<>());
        return listOfList;
    }

    public static void main(String[] args) {
        O7_CombinatioSUM obj = new O7_CombinatioSUM();

        int[] candidates = {2, 3, 6, 7}; 
        int target = 7; 
        List<List<Integer>> result = obj.combinationSum2(candidates, target);
        System.out.println(result); // here i can take same idx value twice pr thrice 
    }
}
