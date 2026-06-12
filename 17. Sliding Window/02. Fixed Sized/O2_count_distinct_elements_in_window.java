import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class O2_count_distinct_elements_in_window {
    public int windows(int[] arr, int start, int k) {
        int count = 0;
        // Traverse each element in the current window
        for (int i = 0; i < k; i++) {
            int j;
            // Check if this element appeared earlier in the window
            for (j = 0; j < i; j++) {
                if (arr[start + i] == arr[start + j])
                    break;
            }
            // If not found, increment distinct count
            if (j == i)
                count++;
        }
        return count;
    } 

    // Time Complexity: O(k2 × (n - k + 1)),    
    // Space Complexity: O(1), 
    public void countDistinct(int[] arr, int n, int k) {
        // Slide window
        for (int i = 0; i <= n - k; i++) {
            System.out.print(windows(arr, i, k) + " ");
        }
    }

    // map + sliding window
    public ArrayList<Integer> countDistinct3(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        // We use a HashMap because we need to track frequencies, not just existence
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 1. Add new element to the window
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // 2. Remove the element that fell out of the window
            if (i >= k) {
                int outOfWindowElement = nums[i - k];
                if (map.get(outOfWindowElement) == 1) {
                    map.remove(outOfWindowElement);
                } else {
                    map.put(outOfWindowElement, map.get(outOfWindowElement) - 1);
                }
            }

            // 3. Once the first full window is reached, record the size of the map
            if (i >= k - 1) {
                result.add(map.size()); // map.size() gives the count of distinct elements
            }
        }
        return result;
    }
}

