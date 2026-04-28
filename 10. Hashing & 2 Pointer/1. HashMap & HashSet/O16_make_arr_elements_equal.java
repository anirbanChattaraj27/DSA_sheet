import java.util.*;
 
public class O16_make_arr_elements_equal {
    public static int minOperation(int arr[], int n) {
        // Insert all elements in hash.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        // find the max frequency
        int max_count = 0;
        Set<Integer> s = map.keySet();

        for (int i : s) {
            if (max_count < map.get(i)) {
                max_count = map.get(i);
            }
        }

        // return result
        return (n - max_count);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = { 1, 5, 2, 1, 3, 2, 1 };
        int n = arr.length;
        System.out.print(minOperation(arr, n));

    }
}
