// https://webrewrite.com/count-distinct-elements-in-every-window-of-size-k/

import java.util.*;

public class O4_count_distinct_elements_in_windows {

    public static List<Integer> distinctElements(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int len = arr.length;

        /*
         * Create a first window and put all the element and it's 
         * count of this window in a HashMap.
        */

        for (int j = 0; j < k; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        }

        result.add(map.size()); // window size means total number of keys in a window. //->1,2,3 -> size of map // is 3 //-> 1,1,2 ->size of map is 2 bcz 1s count is 2 and 2s count is 1

        for (int j = 1; j <= len - k; j++) {

            int removeElem = arr[j - 1];
            int addElem = arr[j + k - 1];

            // Remove element from map
            mapFunction(map, removeElem);

            // Add element from map
            map.put(addElem, map.getOrDefault(addElem, 0) + 1);

            result.add(map.size());
        }
        return result;
    }

    private static void mapFunction(Map<Integer, Integer> map, int elem) {

        Integer count = map.get(elem);

        if (count != null && count > 1) {
            map.put(elem, count - 1);
        } 
        else {
            map.remove(elem);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 9, 3, 3, 7, 3 };
        int k = 3;

        List<Integer> result = distinctElements(arr, k);

        result.forEach(elem -> {
            System.out.print(elem + " ");
        });
    }
}