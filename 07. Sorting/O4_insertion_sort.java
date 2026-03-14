public class O4_insertion_sort {

    public static void Display(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertion(int[] arr){ 
        int n = arr.length;

        for(int i=1; i<n; i++){  // this loop is for passes  // i have to start the loop from index 1 bcz i have to compare index 1 with index 0 that is why 
            int temp = arr[i]; // at first temp = 1 
            int j = i-1; // then j = 0

            while(j>=0 && arr[j] > temp ){  // this loop is for shifting elements // in the time of comparing elements j should not go out of bound means j should go upto 0th index  // whenever arr[j] means arrays elements are greater than temp loop will stop              arr[j+1] = arr[j];
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 4, 28, 24, 2, 18, 12};

        insertion(arr);
        Display(arr);
    }

}
