// it means largest elemnt if k=2 then 2nd largest if k=4 then 4th largest
// https://leetcode.com/problems/kth-largest-element-in-an-array/


// The peek() method only retrieved the element at the head but the 
// poll() also removes the element along with the retrieval. 
// It returns NULL if the queue is empty.


import java.util.*;;
public class O2_kTh_largest_element {

    public static int kthLargestElement(int k, int[] arr) {

        // using HEAP
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through the array elements
        for (int val : arr)
        {
            // Push the current element onto the max heap
            pq.add(val);

            // If the size of the max heap exceeds k, remove the largest element
            if (pq.size() > k)
                pq.poll();
        }

        // Return the kth smallest element (top of the max heap)
        return pq.peek();
    }


    // for distinct numbers
    public static int findKthLargest(int[] arr, int k) {
        
        Arrays.sort(arr);  //1 2 3 4 5 6
        return arr[arr.length-k];  // return arr[k-1] for kth smallest element
    } 


    // for repeateting numbers
    public static int findKthLargest2(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }

        Integer[] newArr = new Integer[set.size()];
        set.toArray(newArr);
        
        Arrays.sort(newArr);
        return newArr[newArr.length-k];
    }

    public static void main(String[] args) {
        int[] array = { 7, 10, 4, 3, 20, 15, 2 };
        System.out.println(kthLargestElement(3, array));  // 3 means 3rd largerst
    }
}
