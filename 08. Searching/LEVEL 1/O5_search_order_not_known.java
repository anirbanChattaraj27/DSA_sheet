// search in array and order means accending or decending is not known... means the 
// array has given bt the array is in accending or decending not known search in that array

// 1. so 1stly we find array is accending or decending then call search function
// 2. if accending array has given then call BS function otherwise call reverse BS function


public class O5_search_order_not_known{

    // if array is in Accending order
    public static int binaryFunction(int arr[], int element){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(element == arr[mid])
            {
                return mid;
            }

            else if(element < arr[mid]){
                end = mid - 1;
                // return end;
            }

            else{
                start = mid + 1;
                // return start;
            }
        }
        return -1;
    }
    
    // if array is decending
    public static int reverseBinaryFunction(int arr[], int element){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(element == arr[mid])
            {
                return mid;
            }

            else if(element < arr[mid]){
                start = mid + 1;                
                // return end;
            }

            else{
                end = mid - 1;
                // return start;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // int arr[] = {99, 87, 75, 55, 18, 5};
        int arr[] = {45, 23, 5, 3};
        int x = 45;

        if(arr[0] < arr[1] ){
            int result = binaryFunction(arr, x);

            if(result == -1)
                System.out.println("not found");
            else
                System.out.println("value " + x + " found at " + result + " index");
        }

        else{
            int result = reverseBinaryFunction(arr, x);

            if(result == -1)
                System.out.println("not found");
            else
                System.out.println("value " + x + " found at " + result + " index");
        }
    }
}

