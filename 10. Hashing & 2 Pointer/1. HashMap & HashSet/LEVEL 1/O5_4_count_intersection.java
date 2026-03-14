
import java.lang.*;
import java.util.*;

public class O5_4_count_intersection {
    
    static int getIntersection(int[] arr1, int[] arr2, int n, int m) {
        int count = 0;

        Set < Integer > set1 = new HashSet < Integer > ();
        Set < Integer > set2 = new HashSet < Integer > ();

        for (int i = 0; i < n; i++) { // adding value in hashSet
            set1.add(arr1[i]); 
        }

        for (int i = 0; i < m; i++) { // adding value in hashSet
            set2.add(arr2[i]);
        }

        for (int x: set2) {  // if x present in set2
            if (set1.contains(x)) {  // set1 elements are in x
                count++;
            }
        }
        return count;
    }
    

    public static void main(String[] args) {
        int[] arr1 = new int[] { 5, 8, 5, 7, 8, 10 };
        int[] arr2 = new int[] { 1, 5, 5, 8, 1, 8, 7 };

        int n = arr1.length;
        int m = arr2.length;

        System.out.println(getIntersection(arr1, arr2, n, m));

    }
}