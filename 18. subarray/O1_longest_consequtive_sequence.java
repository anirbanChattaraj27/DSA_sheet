// longest consecutive subsquence

// N = 7
// a[] = {2,6,1,9,4,5,3}
// Output:
// 6
// Explanation:
// The consecutive numbers here
// are 1, 2, 3, 4, 5, 6. These 6 
// numbers form the longest consecutive subsquence


import java.util.Arrays;
import java.util.*;

public class O1_longest_consequtive_sequence {

    public static int longestConsecutive1(int[] arr){ // 1 method  // O(nlogn)

        // Sorting the given array.
        Arrays.sort(arr);

        // Storing length of longest consecutive sequence.
        int mx = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++){

            // Check if the previous value is consecutive to the current value.
            if (i > 0 && (arr[i] == arr[i - 1] + 1)) {
                count++;
            }

            // Skip if the current value is equal to the previous value.
            else if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            
            // Resetting count for next upcoming consecutive sequence.
            else {
                count = 1;
            }
            mx = Math.max(mx, count);
        }
        return mx;
    }


    public static int longestConsecutive2(int[] arr) { // 2nd method // O(n)
        Set <Integer> hashSet = new HashSet<Integer>();
        
        for(int x : arr){
            hashSet.add(x);
        }
        
        int longestCount = 0;
        
        for(int x : arr){
            if(!hashSet.contains(x-1)){ // if hashSet doesn't contains value element-1 then if block executes
                int currentNum = x;
                int currentCount = 1;
                
                while(hashSet.contains(currentNum +1)){
                    currentNum += 1;
                    currentCount += 1;
                }
                longestCount =Math.max(longestCount, currentCount);    
            }        
        }
        return longestCount;
    }


    public static void main(String[] args)
    {
        int arr[] = {1,2,4,5,2,8};

        System.out.println("Length of the Longest contiguous subsequence is " + longestConsecutive1(arr));
    }
}
