// Distinct Element :- Distinct elements are nothing but the unique (non-duplicate) elements present in the given array
// Distinct Element :- Every elemets will print one time in o/p terminal

// I/P--> 1, 1, 2, 2, 4, 4, 3, 3, 7, 7, 8, 4
// O/P--> 1, 2, 4, 3, 7, 8, 4





// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.lang.*;
import java.util.*;

public class O3_1_Count_distinct {

    // brute-Force ?
    static void countDistinct(int[] array, int size) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            int flag = 0;

            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0)
                count++;
        }
        System.out.println("count is: " + count);
    }

    // Sorting
    static int countDistinct2(int[] arr, int size){ 
        Arrays.sort(arr);
        int count = 0;

        for(int i=0; i<size; i++){
            if(i<size-1 && arr[i] == arr[i+1]){
                i++;
                // continue;  // i can also use continue keyword bt better to use i++
            }
            count++;
        }
        return count;
    }
 
    // hashSet
    static int countDistinct3(int[] arr, int size) {

        Set < Integer > set = new HashSet < Integer > ();
        // HashSet < Integer > set = new HashSet < Integer > ();  // both lines are same

        for (int i = 0; i < size; i++){
            set.add(arr[i]);
        }
        return set.size();
    }

    // insted of using loop using this function "(Arrays.asList(arr))" so that all elements get added
    static int countDistinct4(Integer[] arr) {
        Set < Integer > set = new HashSet < Integer > (Arrays.asList(arr)); 
        return set.size();
    }


    public static void main(String[] args) {
        int[] arr = { 5, 8, 5, 7, 8, 10 };
        int size = arr.length;
        System.out.println(countDistinct2(arr, size));
        // countDistinct2(arr, size);
    }
}
