/*
 * Search insert position of K in a sorted array
 * 
 * https://leetcode.com/problems/search-insert-position/description/
 * https://www.geeksforgeeks.org/search-insert-position-of-k-in-a-sorted-array/

Input: arr[] = [1, 3, 5, 6], k = 5
Output: 2
Explanation: Since 5 is found at index 2 as arr[2] = 5, the output is 2.

 */


import java.util.*;

public class O13_search_insert_position {

    // Linear Search – O(   n) Time and O(1) Space
    static int searchInsertK1(int arr[], int k) {  

        for(int i = 0; i < arr.length; i++) {  

            // If k is found or needs to be inserted before arr[i]
            if(arr[i] >= k) {  
                return i;  
            }  
        }  

        // If k is greater than all elements, insert at the end
        return arr.length;  
    }  

    // Binary Search – O(log n) Time and O(1) Space
    static int searchInsertK2(int arr[], int k) {  

        int left = 0, right = arr.length - 1;  

        while(left <= right) {  

            int mid = left + (right - left) / 2;  

            // If k is found at mid
            if(arr[mid] == k) {  
                return mid;  
            }  

            // If k is smaller, search in left half
            else if(arr[mid] > k) {  
                right = mid - 1;  
            }  

            // If k is larger, search in right half
            else {  
                left = mid + 1;  
            }  
        }  

        // If k is not found, return insert position
        return left;  
    }  

    // Binary Search – O(log n) Time and O(1) Space
    static int searchInsertK3(int arr[], int k) {  

        int left = 0, right = arr.length - 1;  

        while(left < right) {  

            int mid = left + (right - left) / 2;  

            // If arr[mid] is less than k, move to the right part
            if(arr[mid] < k) {  
                left = mid + 1;  
            }  

            // Otherwise, move to the left part
            else {  
                right = mid;  
            }  
        }  

        // Found place: arr[left] is the first element >= k
        return (arr[left] < k) ? left + 1 : left;  
    }  


    public static void main(String args[]) {  

        int arr[] = {1, 3, 5, 6};  
        int k = 5;  

        System.out.println(searchInsertK3(arr, k));  

    }  
}  
