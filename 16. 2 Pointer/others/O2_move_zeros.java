// Leetcode 283

public class O2_move_zeros {
    public static void f(int arr[]){
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            else{
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 3, 0, 0};
        f(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
