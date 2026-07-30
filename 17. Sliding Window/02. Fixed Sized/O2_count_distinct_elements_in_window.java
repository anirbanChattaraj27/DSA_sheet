
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
                if (arr[start + i] == arr[start + j]) {
                    break;
                }
            }
            // If not found, increment distinct count
            if (j == i) {
                count++;
            }
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
    public List<Integer> countDistinct3(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            // 1. Add right element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // 2. Window size becomes k
            if (right - left + 1 == k) {

                // 3. Store answer
                ans.add(map.size()); // map.size gives the number of distinct elements in the current window

                // 4. update the the KEY and decresease the VALUE of that key (left element)
                map.put(arr[left], map.get(arr[left]) - 1); // here i am removing the value from the map by 1, if it becomes 0 then i will remove it from the map

                // Remove key if frequency becomes 0
                if (map.get(arr[left]) == 0) { // here i am checking if the value of the key is 0 then i will remove the KEY from the map
                    map.remove(arr[left]);
                }

                left++;
            }
        }
        return ans;
    }
}
