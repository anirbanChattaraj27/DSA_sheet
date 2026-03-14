// frequncy sort qs in LEETCODE... solve that //1636 -> https://leetcode.com/problems/sort-array-by-increasing-frequency/

// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.lang.*;
import java.util.*;;

class O4_frequncy {

    // ✨✨✨✨✨✨✨✨brute-Force✨✨✨✨✨✨✨✨
    static void countFrequency(int[] array, int size) {

        for (int i = 0; i < size; i++) {
            int flag = 0;
            int count = 0;

            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    flag = 1;
                    break;
                }
            }

            // The continue keyword is used to end the current iteration
            // in a for loop (or a while loop), and continues to the next iteration
            if (flag == 1)
                continue;

            for (int j = 0; j <= i; j++) {
                if (array[i] == array[j])
                    count++;
            }
            System.out.println(array[i] + ": " + count);
        }
    }

    // ✨✨✨✨✨✨✨✨sorting✨✨✨✨✨✨✨✨
    public static void countFrequency2(int[] arr, int n) {

        Arrays.sort(arr);

        // Traverse the sorted array
        for (int i = 0; i < n; i++) {
            int count = 1;

            // Move the index ahead whenever
            // you encounter duplicates
            if (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
                count++;
            }

            System.out.println(arr[i] + ": " + count);
            count++;
        }
    }

    // ✨✨✨✨✨✨✨✨hashMap✨✨✨✨✨✨✨✨
    static void countFrequency3(int arr[], int n) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> X : map.entrySet())
            System.out.println(X.getKey() + ": " + X.getValue());
    } 
    // 1 prblm is there with this, --> it cant print in same order like it would not
      // print like 5 then 8 then then 7 then 10... it would print any order... this
      // is what map does...

    // ✨✨✨✨✨✨✨✨hashMap✨✨✨✨✨✨✨✨
    static void countFrequency4(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            // int key = arr[i]; // no need to use this, without using this ans comes
            // perfectly

            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        } // upto this code is similar like prev code

        // from here things have changed
        for (int i = 0; i < n; i++) // here i travarse the array
        {
            if (map.get(arr[i]) != -1) // if value of map is not -1 then print key nd value
            {
                System.out.println(arr[i] + ": " + map.get(arr[i])); // here we prinitng the key nd value
                map.put(arr[i], -1); // make the value as -1, after getting key nd value
            }
        }
    } // here prev prblm has solved and elements will print in same order

    public static void main(String[] args) {
        
        int[] arr = { 5, 8, 5, 7, 8, 10 };
        int size = arr.length;
        countFrequency4(arr, size);
    }
}
