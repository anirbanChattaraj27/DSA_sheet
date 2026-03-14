// move 0 to the left side and move 1s to the right side

public class O6_move_0s_left_1s_right {

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }

    public static void seperate0s1sNumbers(int arr[]){
        int i=0;
		int j=0;

		while(i<arr.length){
			if(arr[i] == 0){
				swap(arr,i,j);
				i++;
				j++;
			}
			else{
				i++;
			}
		}
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1 };

        seperate0s1sNumbers(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
