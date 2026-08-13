/*
Input :  arr = [6, 5, 3, 2, 8, 10, 9], k = 3  
Output :  [2, 3, 5, 6, 8, 9, 10]  
Explanation :  The element 2 was at index 3, it moved to index 0. The element 3 was at index 2, it moved to index 1. The element 5 moved from index 1 to index 2. The element 6 moved from index 0 to index 3. The rest (8, 9, 10) were near their correct spots and shifted slightly.

Input :  arr = [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2  
Output :  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  
Explanation :  The element 2 moved from index 3 to index 1. The element 3 moved from index 4 to index 2. The element 4 moved from index 1 to index 3. The element 5 moved from index 2 to index 4. All others remained in or near their correct positions.

 */

import java.util.*;

public class O10_sort_K_sorted_array {

    public List<Integer> sortNearlySortedArray(List<Integer> arr, int k) {
        // Create a min heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Store the final result
        List<Integer> result = new ArrayList<>();

        // Add first k+1 elements to the heap
        for (int i = 0; i <= k && i < arr.size(); i++) {
            minHeap.add(arr.get(i));
        }

        // Process the rest of the array
        for (int i = k + 1; i < arr.size(); i++) {
            result.add(minHeap.poll()); // remove smallest
            minHeap.add(arr.get(i));    // insert current
        }

        // Remove and add remaining elements in heap
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }
}

// Driver class
class Main {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(6, 5, 3, 2, 8, 10, 9);
        int k = 3;

        O10_sort_K_sorted_array obj = new O10_sort_K_sorted_array();
        List<Integer> sortedArr = obj.sortNearlySortedArray(arr, k);

        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
    }
}
