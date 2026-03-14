// it means smalles elemnt if k=2 then 2nd smallest if k=4 then 4th smallest

import java.util.*;

public class O3_kTh_smallest_element {
    
    public static int kthSmallesttElement(int k, int[] array) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int size = array.length;

        for (int i = 0; i < size; i++) {
            minHeap.add(array[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] array = { 7, 10, 4, 3, 20, 15, 2 };
        System.out.println(kthSmallesttElement(3, array)); // 3 means 3rd smallest
    }
}
