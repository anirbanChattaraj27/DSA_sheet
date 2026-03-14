// NOTE:
// convert SET to Integer ARRAY

// https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/
// nth largest number in array

/*
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4

    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5
 */

import org.omg.CORBA.FieldNameHelper;
import java.util.*;

public class O5_kTh_largest_element {

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
        int arr[] = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(k + "th largest element is-> " + findKthLargest(arr, k));

        int arr2[] = {3,2,1,5,6,6,1,4,5,4};
        int k2 = 2;
        System.out.println(k + "th largest element is-> " + findKthLargest2(arr2, k2));
    }
}
