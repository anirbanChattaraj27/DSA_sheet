// Leetcode : 216: https://leetcode.com/problems/combination-sum-iii/
import java.util.ArrayList;
import java.util.List;

public class O17_CombinationSUM_III {
    private void func(int sum, int idx, List<Integer> list, int k, List<List<Integer>> ans) {

        if (sum == 0 && list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum <= 0 || list.size() > k) return;

        for (int i = idx; i <= 9; i++) {
            if (i <= sum) {
                list.add(i);
                func(sum - i, i + 1, list, k, ans);
                list.remove(list.size() - 1);
            } 
            else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // Call the recursive function with initial parameters
        func(n, 1, list, k, ans);
        return ans;
    }

    public static void main(String[] args) {

        O17_CombinationSUM_III sol = new O17_CombinationSUM_III();

        int k = 3; // Number of elements in the combination
        int n = 7; // Target sum
        List<List<Integer>> result = sol.combinationSum3(k, n);

        // Print the result
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
