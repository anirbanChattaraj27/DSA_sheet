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

    // Gemini --> verify
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return 0;

        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char inChar = s.charAt(right);
            // 1. Expand the head: Add incoming character
            freqMap.put(inChar, freqMap.getOrDefault(inChar, 0) + 1);

            // 2. Contract the tail: Shrink window if unique characters exceed K
            while (freqMap.size() > k) {
                char outChar = s.charAt(left);
                freqMap.put(outChar, freqMap.get(outChar) - 1);
                
                // If frequency drops to 0, completely remove the key to lower map size
                if (freqMap.get(outChar) == 0) {
                    freqMap.remove(outChar);
                }
                left++; // Crawl tail forward
            }

            // 3. Keep track of the longest valid length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
