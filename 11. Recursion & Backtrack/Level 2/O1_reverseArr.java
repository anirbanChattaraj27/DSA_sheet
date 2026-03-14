

public class O1_reverseArr {

    public static void rev(int arr[], int n){
        
        if(n == -1 ){ // if(n < 0)
            return;
        }
        System.out.print(arr[n] + " ");
        rev(arr, n-1);
    }

    public static void swap(int l, int r){
        int temp = l;
        l = r;
        r = temp;
    }


    public static void main(String[] args) {
        
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};

        rev(arr, n-1);
        System.out.println();
        
    }
}
