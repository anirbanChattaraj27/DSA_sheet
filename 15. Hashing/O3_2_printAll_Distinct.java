
import java.util.*;
import java.lang.*;

public class O3_2_printAll_Distinct {

    static void printDistinct(int[] arr, int size) {
        Arrays.sort(arr);

        for (int i = 0; i < size; i++) {
            if (i < size - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
            System.out.print(arr[i] + " ");
        }
    }

    static int[] printDistinctMethod2(int[] array, int size) {
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
                System.out.println(array[i]);
        }
        return array;
    }

    static void usingHash(int arr[], int n) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                // System.out.print(arr[i] + " "); // if i use this then order will be maintained
            }
        }
        for(int x: set){ // if i use this then order will not be maintained
            System.out.print(x + " "); 
        }                           
        System.out.println();
    }

    static void usingMAP(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            // map.put(arr[i], map.getOrDefault(arr[i], 0) +1); // both above and this line can give the same result
        }

        System.out.println("Distinct elements are -> " + map.keySet()); // this line or bellow lines both are correct
                                                                        // for printing elements inside map
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            System.out.print(en.getKey() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 5, 8, 5, 7, 8, 10 };
        int size = arr.length;

        usingHash(arr, size);
        usingMAP(arr, size);
    }
}