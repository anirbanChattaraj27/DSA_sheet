// GFG: 
// copy: 6
/* WHY BACKTRACKING is not using here ? */ // ans: bellow
/*
I/P: 3 1 2
O/P: [0, 1, 2, 3, 3, 4, 5, 6]
 */
import java.util.*;
 
public class O9_subSet_SUM {
    
    /* WHY BACKTRACKING is not using here ? */

    static void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> list) {
        if (ind == N) {
            list.add(sum);
            return;
        }

        // Pick the element
        func(ind + 1, sum + arr.get(ind), arr, N, list);

        // Do not pick the element
        func(ind + 1, sum, arr, N, list);
    }

    // Function to return sorted subset sums
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        func(0, 0, arr, N, list);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 1, 2));
        int N = arr.size();
        ArrayList<Integer> result = subsetSums(arr, N);
        
        // Printing the subset sums
        System.out.println(result);
    }
}

/*
BCZ, 
in other scenario i was using list and list is non premitive data type so the value inside it will not get removed
BUT, in this case here sum is premitve data type and every time i call the function and when it done its 1 recursive call then it eill destroy it and new call will start from 0
as it is premetive type so no need of backtrack
*/