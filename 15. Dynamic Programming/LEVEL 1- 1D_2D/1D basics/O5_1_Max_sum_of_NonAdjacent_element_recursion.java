
// copy: 5
// Simple recursion
// TC: O(2^n)
// SC: O(1)

public class O5_1_Max_sum_of_NonAdjacent_element_recursion {

    static int fun(int idx, int arr[]){
        if(idx == 0) return arr[idx];
        if(idx < 0) return 0;

        int pick = arr[idx] + fun(idx-2, arr);
        int notPick = 0 + fun(idx-1, arr);

        return Math.max(pick, notPick);
    }

    static int maxAdjSum(int arr[]){
        int n = arr.length;
        return fun(n-1, arr);
    }

    public static void main(String args[]){
        int arr[] = {2, 1, 9, 4};
        System.out.println( maxAdjSum(arr));
    }
}
