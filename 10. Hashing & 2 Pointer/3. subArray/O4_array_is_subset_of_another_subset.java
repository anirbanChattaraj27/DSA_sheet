// https://practice.geeksforgeeks.org/problems/array-subset-of-another-array/0
// one array is subset of another

import java.util.HashSet;
import java.util.Set;

public class O4_array_is_subset_of_another_subset {

    public static boolean subset1(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr1[i] == arr2[j]){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean subset2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        Set < Integer > set1 = new HashSet < Integer > ();

        for (int i = 0; i < n; i++) { // adding value in hashSet
            set1.add(arr1[i]); 
        }

        for(int x : arr2){
            if(set1.contains(x)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {6,3};

        System.out.println(subset2(arr1, arr2));
        System.out.println(subset1(arr1, arr2)); 
    }
}
