// https://leetcode.com/problems/subsets/description/
// copy 1
// print all subSets

// RECURSION POINT: list.remove() && cslling func with (idx+1)

import java.util.ArrayList;

public class O3_subSets_I {

    public static void printSubSequences(int idx, ArrayList<Integer> list, int arr[], int n) {
        if (idx == n) {
            System.out.println(list);
            return;
        } 

        // take the current element
        list.add(arr[idx]);
        printSubSequences(idx + 1, list, arr, n);
        list.remove(list.size() - 1);

        // Not take the current element
        printSubSequences(idx + 1, list, arr, n);
    }

    public static void printReverse(int idx, ArrayList<Integer> list, int arr[], int n) {
        if (idx == n) {
            System.out.println(list);
            return;
        }

        // Not take the current element
        printReverse(idx + 1, list, arr, n); 

        // take the curr e nt element
        list.add(arr[idx]);  
        printReverse(idx+1, list, arr, n);   
        list.remove(list.size()-1);  
    }
    
    public static void main(String[] args) {
        int arr[] = {3, 1, 2};
        int n = 3;
        ArrayList<Integer> list = new ArrayList<>();

        printSubSequences(0, list, arr, n);
        System.out.println();
        printReverse(0, list, arr, n);

    }
}
/*
[3, 1, 2]
[3, 1]
[3, 2]
[3]
[1, 2]
[1]
[2]
[]

[]
[2]
[1]
[1, 2]
[3]
[3, 2]
[3, 1]
[3, 1, 2] 

*/