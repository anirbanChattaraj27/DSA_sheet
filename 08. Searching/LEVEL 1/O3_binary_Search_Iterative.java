public class O3_binary_Search_Iterative {

    public static int binaryFunction(int arr[], int X) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (X == arr[mid]) {
                return mid;
            }

            else if (X < arr[mid]) {
                end = mid - 1;
                // return end;
            }

            else {
                start = mid + 1;
                // return start;
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