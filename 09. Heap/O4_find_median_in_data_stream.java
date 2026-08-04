/*
LC 295: 
 */

import java.util.*;


public class O4_find_median_in_data_stream {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public O4_find_median_in_data_stream() {

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to max heap
        maxHeap.offer(num);

        // Step 2: Move the largest from left to right
        minHeap.offer(maxHeap.poll());

        // Step 3: Keep maxHeap equal in size or one larger
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
