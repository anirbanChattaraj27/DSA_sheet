// LC 347 : https://leetcode.com/problems/top-k-frequent-elements/description/
/*
Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

Example 2:
    Input: nums = [1], k = 1
    Output: [1]

Example 3:
    Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
    Output: [1,2]

 */
import java.util.*;

public class O5_Top_K_Frequent {

    // map + sorting || TC: O(nlogN) || SC: O(n)
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert map to list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort by frequency (descending)
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Store answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }

    // MIN HEAP || TC: O(nlogK) || SC: O(n)
    public int[] topKFrequent2(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        // The root is always the smallest frequency.
        // Create a Min Heap that stores (number, frequency) pairs, and compare them by frequency.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Keep only k most frequent elements 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();  // Heap always removes the ROOT / starting of array (index 0)
            }
        }

        // Step 4: Build answer
        int[] ans = new int[k];

        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll().getKey();
        }

        return ans;
    }
}

/*
Time Complexity: O(n + m log k), where n is the number of elements and m is the number of unique elements. In the worst case (m = n), this becomes O(n log k).
Space Complexity: O(m) for the frequency map (plus O(k) for the heap and answer, which is dominated by O(m)).
*/

/*
Step 1: Count Frequencies
    Given array
    1 1 2 2 2 3 3 3 3 3 4 4 4 4 4 4
    Meaning:
        1 → appears 2 times
        2 → appears 3 times
        3 → appears 5 times
        4 → appears 6 times

Step 2: What is Map.Entry<Integer, Integer>?

    Normally a map looks like:
        1 -> 2
        2 -> 3
        3 -> 5
        4 -> 6

Each pair is called a Map.Entry.

    Map.Entry<Integer, Integer> entry;
        Key = 3
        Value = 5

    Access them like this:
        entry.getKey();    // 3
        entry.getValue();  // 5


Step 3: What is Stored in the Heap?

    The heap stores entries like:
        (1,2), (2,3) ... (number, frequency)


Step 4: Understanding the Comparator

    (a, b) -> a.getValue() - b.getValue()

    Compare using frequency.
        a = (2,3)
        b = (4,6)

    Then
        a.getValue() = 3
        b.getValue() = 6

    Comparison--->  3 - 6 = -3

    Negative means--> 3 comes before 6 --> smaller frequency comes first. 
*/