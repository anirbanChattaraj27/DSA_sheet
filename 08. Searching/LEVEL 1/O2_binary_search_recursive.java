
public class O2_binary_search_recursive {
    
    public static int binaryFunction(int[] arr, int low, int high, int x){

        if(low <= high){

            int mid = low + (high-low) / 2;

            if(x == arr[mid])
                return mid;

            if(x < arr[mid]) // if arr[mid] is greater than Key then move to left
                return binaryFunction(arr, low, mid-1, x);

            else  // if arr[mid] is smaller than Key then move to right
                return binaryFunction(arr, mid+1, high, x);
        }
        else
            return -1;
    }
    
    public static int BinarySearch(int arr[], int target){
        return binaryFunction(arr, 0, arr.length, target);
    }

    public static void main(String[] args) {
        int array[] = {12, 45, 78, 97};
        int x = 78;

        int size = array.length;

        int result = binaryFunction(array, 0, size-1, x);

        if(result == -1)
            System.out.println("not found");
        else
            System.out.println("value " + x + " found at " + result + " index");

    }
}

