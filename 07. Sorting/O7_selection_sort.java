public class O7_selection_sort{
    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){ // -1 bcz if n-1 element will be sort then last element will be automatically sort
            int minIndex = i;

            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {72, 58, 18, 44, 8, 20};

        selectionSort(arr);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}