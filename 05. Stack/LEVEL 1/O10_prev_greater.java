// previous greater element

public class O10_prev_greater {

    static void prevGreater(int[] arr, int size) {

        for (int i = 0; i < size; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
        }
    }

    static void prevGreater2(int[] arr, int size) {

        for (int i = 0; i < size; i++){ // it'll travarse hole array
        
            boolean flag = false; // take a flag as false, when flag will be true print element and if flag remain false print "-"

            for (int j = i - 1; j >= 0; j--){ // j starts from i-1 index // if i is in 3rd index j starts from 2nd index and move left side
            
                if (arr[j] > arr[i]){ // if j > i print j's value
                
                    System.out.print(arr[j] + " ");
                    flag = true; // here flag will be true bcz j's value find so break 2nd for loop and start travarsing from 1st loop
                    break;
                }
            }

            if (flag == false) // falg remain false, means no greater element found so print "-"
                System.out.print("- ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 30, 50, 20, 15, 25 };
        int size = arr.length;
        prevGreater(arr, size);

    }
}