// it means smalles elemnt if k=2 then 2nd smallest if k=4 then 4th smallest

import java.util.*;

public class O3_kTh_smallest_element {
    
    public static int kthSmallesttElement(int k, int[] array) {

        // using HEAP
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

    public static void reverse(int[] nums){
        int start = 0, end = nums.length-1;

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        } 
    }


    // without using reverse method
    public static int findKthSmallest(int[] arr, int k) {
        
        Arrays.sort(arr);  //1 2 3 4 5 6
        return arr[k-1]; 
    }

    // using reverse method
    public static int findKth2(Integer[] arr, int k) {
        
        Arrays.sort(arr, Collections.reverseOrder());  //1 2 3 4 5 6
        // reverse(arr);  // 6 5 4 3 2 1 
        return arr[arr.length-k]; 
    }

    public static void main(String[] args) {
        int[] array = { 7, 10, 4, 3, 20, 15, 2 };
        System.out.println(kthSmallesttElement(3, array)); // 3 means 3rd smallest
    }
}
