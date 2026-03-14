import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

public class O3_bubble_sort {

    public static void Display(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubble(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){  // this is for pass

            for(int j=0; j<n-i-1; j++){ // this is for swapping

                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // display array
        for(int i=0; i<arr.length; i++){
            System.out.print (arr[i] + " ");
        }
    }
 
    public static void main(String[] args) {
        int[] arr = {18, 12, 7, 6, 5, 11, 15, 2};

        bubble(arr);
        // Display(arr);
    }
}
