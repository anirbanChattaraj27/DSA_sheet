import java.util.*;

public class O8_2_CombinationSum_II_hashSet {

    private void findCombinations( int idx, int[] arr, int target, Set<List<Integer>> set, List<Integer> list) {

        // If target is achieved
        if(idx == arr.length){ // If index is out of bounds
            if (target == 0) {
                set.add(new ArrayList<>(list)); // HashSet removes duplicates
            }
            return;
        }

        // -------- TAKE --------
        if (arr[idx] <= target) {
            list.add(arr[idx]);
            findCombinations(idx + 1, arr, target - arr[idx], set, list);
            list.remove(list.size() - 1); // backtrack
        }

        // -------- NOT TAKE --------
        findCombinations(idx + 1, arr, target, set, list);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> uniqueCombinations = new HashSet<>();
        Arrays.sort(candidates); // Sorting to handle duplicates
        findCombinations(0, candidates, target, uniqueCombinations, new ArrayList<>());

        return new ArrayList<>(uniqueCombinations);
    }

    public static void main(String[] args) {
        O8_2_CombinationSum_II_hashSet obj = new O8_2_CombinationSum_II_hashSet();


        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(obj.combinationSum2(candidates1, target1));

        System.out.println();
        
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(obj.combinationSum2(candidates2, target2));
    }
}

/*
[[1, 2, 5], [1, 1, 6], [2, 6], [1, 7]]

[[1, 2, 2], [5]]
 */