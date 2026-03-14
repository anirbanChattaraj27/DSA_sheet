import java.util.*;

// Time Complexity is : O(n^2)
// Space Complexity is : O(1)

// i/p -> 12, 14, 15, 7, 15, 17, 5
// o/p -> 1   2   3   1   5  6   1 
// no element smaller before 12 so 1
// 1 element smaller before 14 and 14 itself so 2
// 2 element smaller before 15 and 15 itself so 3
// so on...

public class O8_span_of_stock{

    static void usingPrevGreater(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            int count = 0;

            for (int j = i; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
        System.out.println();
    }

    static void stockSpan(int[] arr, int size) {

        for (int i = 0; i < size; i++){
            
            int curr_span = 0;
            for (int j = i; j >= 0; j--){ // when j will encounter an element larger than starting element loop will stop previous index of 
                if(arr[j] <= arr[i]){
                    curr_span++;
                }
            }
            System.out.print( + curr_span + " ");
        }
        // for (int i = 0; i < size; i++){
            
        //     int curr_span = 1;
        //     for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) // when j will encounter an element larger than starting element loop will stop previous index of 
        //         curr_span++;
        //     System.out.print( + curr_span + " ");
        // }
    }

    public static void main(String[] args){

        int[] arr = {12, 14, 15, 7, 15, 17, 5};
        int size = arr.length;
        prevGreater(arr, size);
        stockSpan(arr, size);
    }
}
