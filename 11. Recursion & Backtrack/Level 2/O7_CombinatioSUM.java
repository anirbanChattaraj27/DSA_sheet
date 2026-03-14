
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
    
    // this way of solving is similar to O4_1_subsequences_with_K
    public static void findCombinations1(int idx, int[] arr, int K, int sum, int n, List<List<Integer>> listOfList, List<Integer> list) {
        
        // base case
        if(sum > K) return;

        if (idx == n) {
            if(sum == K){
                listOfList.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(arr[idx]);
        sum += arr[idx]; // Increases sum by arr[idx].  
        findCombinations1(idx, arr, K, sum, n, listOfList, list); // Recursively calls printSubSequences() with idx + 1 to move to the next element. // as i am not taking 1 index multiple times so increase ind by idx+1 and moving to next idx 

        sum -= arr[idx]; // Backtracks by removing the last added element from list. // Restores sum by subtracting arr[idx] (to explore other subsequences).
        list.remove(list.size() - 1); 

        findCombinations1(idx + 1, arr, K, sum, n, listOfList, list);  // Calls the function again without adding arr[idx] to list, allowing us to explore subsequences where arr[idx] is not included.
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> listOfList = new ArrayList<>();
        findCombinations1(0, candidates, target, 0, candidates.length, listOfList, new ArrayList<>());
        return listOfList;
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
