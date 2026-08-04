// LC 703: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

import java.util.*;

public class O3_Kth_largest_element_in_a_Stream {
    
    private PriorityQueue<Integer> minHeap;
    private int k;

    public O3_Kth_largest_element_in_a_Stream(int k, int[] nums) {

        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();  
            }
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
