// it means largest elemnt if k=2 then 2nd largest if k=4 then 4th largest
// LC 215: https://leetcode.com/problems/kth-largest-element-in-an-array/

/*
heap always keeps the k largest elements.

*/

import java.util.*;
public class O2_kTh_LargestSmallest_element {

    public static int kthLargestElement(int k, int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int x : arr){
            minHeap.add(x); 

            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }

    public static int kthSmallestElement(int k, int[] arr) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {

            maxHeap.add(x);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] array = { 7, 10, 4, 3, 20, 15, 2 };
        System.out.println(kthLargestElement(3, array));  // 3 means 3rd largerst
    }
}


/*
Find	        Heap	    Remove
Kth Largest	    Min Heap	Smallest --> Kth Largest → keep the largest k numbers → remove the smallest → Min Heap.
Kth Smallest	Max Heap	Largest --> Kth Smallest → keep the smallest k numbers → remove the largest → Max Heap.
*/