import java.util.*;

// Input: arr[] = { 1, 2, 6, 6, 6, 6, 6, 10 }, K = 4
// Output: 6
// Explanation:  The frequency of 6 in the array is greater than N / K(= 2). Therefore, the required output is 6.

// Input: arr[] = { 3, 4, 4, 5, 5, 5, 5 }, K = 4 
// Output: 4 5 
// Explanation:  The frequency of 4 in the array is greater than N / K(= 1).  The frequency of 5 in the array is greater than N / K(= 1). Therefore, the required output is 4 5.


public class O32_print_all_elements_appear_more_than_kBY2_times {

    
    // this approch is same as O34_majority elements
    public static void usingMap(int arr[], int N, int k) {
        Map <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > k/2){
                System.out.print( entry.getKey() + " ");
            }
        }
    }

    static void nDivKWithFreq(int arr[], int N, int K) {
        // Sort the array, arr[]
        Arrays.sort(arr);

        // Traverse the array
        for (int i = 0; i < N;) {

            // Stores frequency of arr[i]
            int count = 1;

            // Traverse array elements which
            // is equal to arr[i]
            while ((i + 1) < N && arr[i] == arr[i + 1]) {

                // Update count
                count++;

                // Update i
                i++;
            }

            // If frequency of arr[i] is
            // greater than (N / K)
            if (count > (N / K)) {

                System.out.print(arr[i] + " ");
            }
            i++;
        }
    }  

    // Driver Code
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1};
        int N = arr.length;
        int K = 4;

        usingMap(arr, N, K);
    }
}
