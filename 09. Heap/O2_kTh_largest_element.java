// it means largest elemnt if k=2 then 2nd largest if k=4 then 4th largest
// https://leetcode.com/problems/kth-largest-element-in-an-array/


// The peek() method only retrieved the element at the head but the 
// poll() also removes the element along with the retrieval. 
// It returns NULL if the queue is empty.


import java.util.*;;
public class O2_kTh_largest_element {

    public static int kthLargestElement(int k, int[] array) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int size = array.length;

        for (int i = 0; i < size; i++) {
            heap.add(array[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] array = { 7, 10, 4, 3, 20, 15, 2 };
        System.out.println(kthLargestElement(3, array));  // 3 means 3rd largerst
    }
}
