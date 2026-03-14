

import org.omg.CORBA.FieldNameHelper;
import java.util.*;

public class O5_kTh_smallest{

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
    public static int findKthLargest(int[] arr, int k) {
        
        Arrays.sort(arr);  //1 2 3 4 5 6
        return arr[arr.length-k]; 
    }

    // using reverse method
    public static int findKth2(Integer[] arr, int k) {
        
        Arrays.sort(arr, Collections.reverseOrder());  //1 2 3 4 5 6
        // reverse(arr);  // 6 5 4 3 2 1 
        return arr[arr.length-k]; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int arr[] = {3,2,1,5,6,4};
        int kk = 2;
        
        // System.out.println("enter no of elements: ");
        // Integer n = sc.nextInt();

        // Integer Arr[] = new Integer[n];
        // System.out.println("enter all elements");
        // for(int i=0; i<n; i++){
        //     Arr[i] = sc.nextInt();
        // }

        // System.out.println("enter kth element: ");
        // int k = sc.nextInt();

        System.out.println(findKthLargest(arr, kk));
        System.out.println(findKthSmallest(arr, kk));

    }
}
