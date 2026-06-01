import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class O2_count_distinct_elements_in_window {
    static ArrayList<Integer> countDistinct(int[] arr, int k) {
        int n = arr.length;  
        ArrayList<Integer> res = new ArrayList<>();
      
        // Iterate over every window
        for (int i = 0; i <= n - k; i++) {
          
            // Hash Set to count unique elements
            HashSet<Integer> st = new HashSet<>();
            for(int j = i; j < i + k; j++)
                st.add(arr[j]);
          
            // Size of set denotes the number of unique elements
            // in the window
            res.add(st.size());
        }
        return res;
    }


    static ArrayList<Integer> countDistinct2(int[] arr, int k) {
        int n = arr.length;  
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
      
        // Store the frequency of elements of the first window
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
      
        // Store the count of distinct elements of the first window
        res.add(freq.size());
      
        for (int i = k; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            freq.put(arr[i - k], freq.get(arr[i - k]) - 1);
          
            // If the frequency of arr[i - k] becomes 0, remove it
            if (freq.get(arr[i - k]) == 0) {
                freq.remove(arr[i - k]);
            }
          
            res.add(freq.size());
        }
      
        return res;
    }
}
