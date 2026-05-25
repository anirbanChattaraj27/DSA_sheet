// i can solve this in 3 ways...
// 1 is with loop (nested loop) --> O(n^2)
// 2nd is with hasing using 2 loops --> O(n) + O(n)
// 3rd is using hasing using 1 loop only --> O(n)



import java.lang.reflect.Array;
import java.util.*;

public class O7_getPair_with_given_sum {
	
	public static int[] getDistinct(int[] array, int size) {
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
            	return array;
        }
        return array;
    }

    
    // O(n^2log(n))
    public static void pairSum(int arr[], int n, int sum){

    	Arrays.sort(arr);  // nlogn
        getDistinct(arr, arr.length);

        int left = arr[0];
        int right = arr.length-1;

        while(left < right){   // O(n)
            if(arr[left] + arr[right] == sum){
                System.out.println(arr[left] + ", " + arr[right]);
            }

            if(arr[left] + arr[right] < sum){
                left++;
            }

            else{
                right--;
            }
        }
    }


    // using O(n^2)
    public static void pairSum2(int[] arr, int n, int sum){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    System.out.print(arr[i] + " " + arr[j]);
                    return; // if i do not return here it will give wrong output
                }
            }
        }
    } //Using the return statement in this way allows the function to stop executing as soon as a pair is found, which can be more efficient than continuing to search the entire array for additional pairs.
    


    // similar to 2Sum problem, BUT in 2SUm I need to print indices not elements
    // did not get ans for count pair with given sum using bellow approch
    // using hashing O(n)
    public static int pairSum3(int[] arr, int n, int sum){
        HashSet hs = new HashSet<>();

        for(int i=0; i<n; i++){
            if(hs.contains(sum-arr[i])){
                System.out.println(arr[i] + ", " + (sum-arr[i]));
            }
            else{
                hs.add(arr[i]);
            }
        }
        return 0;
    }
    
	public static void main(String args[]) {
		int arr[] = {10, 2, 15, 2, 9, 1, 3};
		int k = 13;

		pairSum2(arr, arr.length, k );
	}
}

