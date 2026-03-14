public class O5_quick_sort {

    public static void Display(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }

    public static int partition(int[] arr, int low, int high ){

        int swapIndex = low - 1; // swapIndex starts from -1 index
        int pivot = arr[high]; // make high index means last index as pivot 

        for(int i=low; i<high; i++){ // i starts from low means 0th index and goes upto last index-1 bcz last index itself is pivot so ignore last index and goes upto previous index of last index

            if(arr[i] <= pivot){ // if element is < pivot then increse swapIndex
                swapIndex++;
                swap(arr, i, swapIndex);   
            }
        } 
        
        swap(arr, swapIndex+1, high);
        
        return (swapIndex + 1);  // this will return middle portion of the array
    }

    public static void quickSort(int[] arr, int low, int high){
        
        if(low < high){
            int partitionIndex = partition(arr, low, high); // this partition will return mid value from where i will devide the array and will do quick sort again on the prgrm

            quickSort(arr, low, partitionIndex-1); // this will apply quickSort for left side array means from low to middle half // here middle is pivo bcz, after swapping pivot will comes to the middle part of array
            quickSort(arr, partitionIndex+1, high); // this will apply QuickSort from middle+1 upto high
        }
    }

    public static void main(String[] args) {
        int arr[] = {70, 90, 100, 5, 4, 3, 500};
        int n = arr.length;

        quickSort(arr, 0, n-1);  // length-1 bcz last element is pivot so upto lastIndex-1 i will apply quickSort

        Display(arr);
    }
}
