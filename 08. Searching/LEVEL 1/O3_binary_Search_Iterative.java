public class O3_binary_Search_Iterative {

    public static int binaryFunction(int arr[], int x) {
        int lo=0;
        int hi=arr.length-1; 

        while(lo <= hi){
            int mid = lo + (hi -lo) / 2;

            if(x == arr[mid]){
                return mid;
            }

            else if(x < arr[mid]){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 12, 45, 78, 97 };
        int x = 97;

        int size = array.length;

        int result = binaryFunction(array, x);

        if (result == -1)
            System.out.println("not found");
        else
            System.out.println("value " + x + " found at " + result + " index");

    }
}