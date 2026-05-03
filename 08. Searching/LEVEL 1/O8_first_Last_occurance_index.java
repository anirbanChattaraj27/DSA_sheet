/*
https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/#alternate-approach-2-using-inbuilt-functions-olog-n-time-and-o1-space

* Find first and last positions of an element in a sorted array


Input : arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
Output : 2 5
Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5

Input : arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125 ], x = 7
Output : 6 6
Explanation: First and last occurrence of 7 is at index 6

Input: arr[] = [1, 2, 3], x = 4
Output: -1 -1
Explanation: No occurrence of 4 in the array, so, output is [-1, -1]
 */
 

import java.util.*;

public class O8_first_Last_occurance_index {

    // Function for finding first and last occurrence of x
    static ArrayList<Integer> find1(int[] arr, int x) {
        int n = arr.length;
        int first = -1, last = -1;
        
        for (int i = 0; i < n; i++) {
            
            // If x is different, continue
            if (x != arr[i])
                continue;
            
            // If first occurrence found
            if (first == -1)
                first = i;
            
            // Update last occurrence
            last = i; 
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }

    // Binary Search – O(log n) Time and O(1) Space
    static int findFirst(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int first = -1; // Initialize first occurrence
        
        // Find first occurrence of x
        while(low <= high) {
            
            int mid = (low + high) / 2;
            
            if(x == arr[mid]) {
                first = mid;
                high = mid - 1;
            }
            
            // If x is less than arr[mid], then search in the left subarray
            else if(x < arr[mid])
                high = mid - 1;
            
            // If x is greater than arr[mid], then search in the right subarray
            else
                low = mid + 1;
        }
        
        return first;
    }

    static int findLast(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int last = -1; // Initialize last occurrence
        
        // Find last occurrence of x
        while(low <= high) {
            
            int mid = (low + high) / 2;
            
            if(x == arr[mid]) {
                last = mid;
                low = mid + 1;
            }
            
            // If x is less than arr[mid], then search in the left subarray
            else if(x < arr[mid])
                high = mid - 1;
            
            // If x is greater than arr[mid],  then search in the right subarray
            else
                low = mid + 1;
        }
        
        return last;
    }
    
    static ArrayList<Integer> find2(int[] arr, int x) {
        int n = arr.length;
        
        // Find first and last index
        int first = findFirst(arr, x);
        int last = findLast(arr, x);
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }

    // EFFICIENT WAY ||  Binary Search – O(log n) Time and O(1) Space

    static ArrayList<Integer> find(int[] arr, int x) {
        int n = arr.length;
        
        // return index of first occurrence
        int first = search(arr, x, true);
        
        // return index of last occurrence
        int last = search(arr, x, false);
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }
    
    static int search(int[] arr, int x, boolean findStart) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ind = -1;
        
        while(low <= high) {
            
            int mid = (low + high) / 2;
            
            if(x == arr[mid]) {
                ind = mid;
                if(findStart)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            
            else if(x < arr[mid]){ // If x is less than arr[mid], then search in the left subarray
                high = mid - 1;
            }
            
            else {   // If x is greater than arr[mid], then search in the right subarray
                low = mid + 1;
            }
        }
        return ind;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        ArrayList<Integer> res = find1(arr, x);
        System.out.println(res.get(0) + " " + res.get(1));
    }
}
