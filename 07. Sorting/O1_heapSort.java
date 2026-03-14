// some error occurs 
// https://www.youtube.com/watch?v=SkeQsjpG_fo

public class O1_heapSort{

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }

    public static void sort(int[] arr) {
        int n = arr.length;
    
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i);
    
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--) {
            // Move current root to end
            swap(arr, i, 0);
    
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    

    public static void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
     
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
     
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
     
        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
     
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    

    public static void display(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+ " ");
        }            
    }

    public static void main(String[] args){
        int[] arr = {22, 13, 17, 11, 10, 14, 12};

        sort(arr);
        display(arr);
    }

}