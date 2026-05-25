// copy: 8
import java.util.*;

class O11_2_printALL_Permutation_OPTIMIZED {
    private void recurPermute(int index, int[] nums, List<List<Integer>> listOfList) {
        if (index == nums.length) {
            // Copy the nums array to a list (current permutation)
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            listOfList.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums); // Swap to fix the element at current index
            recurPermute(index + 1, nums, listOfList); // Recurse for next index
            swap(i, index, nums); // Backtrack to restore original state
        }
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listOfList = new ArrayList<>();
        recurPermute(0, nums, listOfList);
        return listOfList;
    }


    public static void main(String[] args) {
        O11_2_printALL_Permutation_OPTIMIZED obj = new O11_2_printALL_Permutation_OPTIMIZED();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }
}
