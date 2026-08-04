/*
LC 295: 

median: sort the list of numbers, middle element is median. if even, average of two middle elements.
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
        maxHeap.offer(num); // Insert into left.

        // Step 2: Move the largest from left to right
        minHeap.offer(maxHeap.poll());

        // Step 3: Keep maxHeap equal in size or one larger
        // Right became larger. Move one back. remove 5 from right insert into left.
        if (minHeap.size() > maxHeap.size()) { 
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // If total number of elements is odd,  maxHeap will have one extra element. The top of maxHeap is the median.
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        
        // If total number of elements is even, the median is the average of the two middle elements.
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/*
EXPLANATION

Why Two Heaps?
    We divide the numbers into two halves.

    Smaller Half          Larger Half
    1 3 5          |      8 10 15

    The median is always around the boundary.

So store
    Smaller half → Max Heap
    Larger half → Min Heap



Why Max Heap on Left?

    Suppose

    1 3 5

    We need the largest element of the smaller half.

    That's exactly what a Max Heap gives.

      5
     /
    3
   /
  1

peek() ---> returns ---> 5



Why Min Heap on Right?

    Suppose

    8 10 15

    We need the smallest element.

    Min Heap

     8
    / \
  10   15

peek() ---> returns ---> 8




Rule 1

    Every element in maxHeap must be smaller than every element in minHeap.

    maxHeap          minHeap
    1 3 5      |      8 10 15

    Never
    1 9 5      |      8 10

    because --- 9 > 8 --- Wrong.



Rule 2

Size difference should never exceed 1.

    Possible
        3 elements
        2 elements
    or
        4 elements
        4 elements

    Never
        5 elements
        2 elements




*/
