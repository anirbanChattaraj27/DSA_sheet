/*
LC 692: https://leetcode.com/problems/top-k-frequent-words/description/

*/
import java.util.*;

public class O10_Top_K_Frequent_words {
    
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap (2 sorting Condition unlike LC 347 1 sorting condition)
        // 1. Frequency  ||  2. Lexicographical order (when frequencies are equal)
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> {

                    // If frequencies are different, smaller frequency should come first.
                    if (a.getValue().equals(b.getValue())) {
                        return b.getKey().compareTo(a.getKey());
                    }
  
                    // If frequencies are same, lexicographically larger word should come first.
                    return a.getValue() - b.getValue();
                });
 
        // Step 3: Keep only top k words
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build answer
        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }

        Collections.reverse(ans);

        return ans;
    }
}
/*
Time Complexity: O(n + m log k), where n is the total number of words and m is the number of unique words. In the worst case (m = n), this becomes O(n log k).
Space Complexity: O(m) for the frequency map (plus O(k) for the heap and result list, which is dominated by O(m)).
*/

/*
LC 347 (Numbers)	            LC 692 (Words)
Key = Integer                   Key = String
Value = Frequency	            Value = Frequency
Compare by frequency only	    Compare by frequency, then reverse lexicographical order for ties
Reverse answer at the end	    Reverse answer at the end
*/