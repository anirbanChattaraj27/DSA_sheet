/*
    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order, we 
    get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.

    Example 1:
    Input: n = 3, k = 3
    Output: "213"

    Example 2:
    Input: n = 4, k = 9
    Output: "2314"

    Example 3:
    Input: n = 3, k = 1
    Output: "123"
 
*/

import java.util.*;

public class O14_Kth_permutation {

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        
        // Build the list and calculate (n - 1)!
        for (int i = 1; i < n; i++) {
            fact *= i;
            list.add(i);
        }
        list.add(n); // Add the last number

        String ans = "";
        k = k - 1; // Convert k to zero-based index

        while (true) {
            ans += list.get(k / fact);
            list.remove(k / fact);

            if (list.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / list.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        O14_Kth_permutation solver = new O14_Kth_permutation();
        int n = 4, k = 9; // Example: 4th permutation of list 1 to 4
        System.out.println("Kth Permutation: " + solver.getPermutation(n, k));
    }
}
