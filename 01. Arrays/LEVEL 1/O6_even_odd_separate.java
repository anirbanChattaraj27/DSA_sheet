
public class O6_even_odd_separate {

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }

    public static void seperateOddEven(int arr[]){
        int j = 0;  // j is looking for even elements
        int i = 0;

        while(i < arr.length){
            if(arr[i] % 2 != 0){ // for (int i = 0; i < arr.length; i++)
                i++;
            }
            else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }    

    public static void main(String[] args) {
        int[] arr = { 8, 3, 1, 2, 4 };

        O6_even_odd_separate.seperateOddEven(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
