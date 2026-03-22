public class O12_sort_0s_1s_2s_in_given_array {
    
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }
     
	public static void sort0s1s2s(int arr[]) {
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        
        while(i <= k) {
            if(arr[i] == 0 ) { // i, j starting from same location, so even if arr[i] points to 0, i,j swap with each other
                swap(arr, i, j);
                i++;
                j++;  
            }

            else if (arr[i] == 1) { // when arr[i] will point to 1 then i will only move i, and j points to 1
                i++;
            }
            else if (arr[i] == 2) { // when arr[i] is 2 I will swap it with K, as K is at last idx so i will move k as k--
                swap(arr, i, k);
                k--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 1, 2, 0, 2, 0, 1};

        sort0s1s2s(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}